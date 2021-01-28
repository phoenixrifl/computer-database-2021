package persistence;

import model.Company;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CompanyDAO extends DAO<Company> {
    final String SQL_SELECT = "SELECT * FROM company";
    final String SQL_SELECT_ONE = "SELECT * FROM company WHERE id =";

    @Override
    public boolean create(Company obj) {
        return false;
    }

    @Override
    public boolean delete(Company obj) {
        return false;
    }

    @Override
    public boolean update(Company obj) {
        return false;
    }

    @Override
    public Company find(Long id) {
        Company tmp = null;
        try{
            ResultSet resultSet = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery(SQL_SELECT_ONE+id);
            if(resultSet.first()){
                tmp = new Company(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return tmp;
    }

    @Override
    public ArrayList<Company> findAll() {
        ArrayList<Company> company_list = new ArrayList<Company>();
        Company tmp = null;
        try {
            ResultSet result = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(SQL_SELECT);
            while(result.next()) {
                tmp = new Company(
                        result.getLong("id"),
                        result.getString("name"));
                company_list.add(tmp);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return company_list;
    }
}
