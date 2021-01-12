package persistence;

import model.Computer;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;


public class ComputerDAO extends DAO<Computer> {
    final String SQL_SELECT = "SELECT * FROM computer";
    final String SQL_CREATE = "INSERT INTO computer (id,name,introduced,discontinued,company_id)";
    final String SQL_DELETE = "DElETE * FROM computer WHERE name=";
    final String SQL_UPDATE = "SELECT * FROM computer";
    final String SQL_SELECT_ONE = "SELECT * FROM computer WHERE id = ";

    @Override
    public boolean create(Computer obj) {
        return false;
    }

    @Override
    public boolean delete(Computer obj) {
        return false;
    }

    @Override
    public boolean update(Computer obj) {
        return false;
    }

    @Override
    public Computer find(int id) {
        return null;
    }

    @Override
    public ArrayList<Computer> findAll() {
        ArrayList<Computer> computer_list = new ArrayList<Computer>();
        Computer tmp = null;
        try {
            ResultSet result = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(SQL_SELECT);
            while(result.next()) {
                Date intro = result.getDate("introduced");
                LocalDate convDate = null;
                if(intro !=null) {
                    convDate = intro.toLocalDate();
                }
                Date disco = result.getDate("discontinued");
                LocalDate convDate1 = null;
                if(disco != null) {
                    convDate1 = disco.toLocalDate();
                }
                tmp = new Computer(
                        result.getInt("id"),
                        result.getString("name"),
                        convDate,
                        convDate1,
                        result.getInt("company_id"));
                computer_list.add(tmp);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return computer_list;
    }
}
