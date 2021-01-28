package persistence;

import model.Company;
import model.Computer;
import service.CompanyService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;


public class ComputerDAO extends DAO<Computer> {
    final String SQL_SELECT = "SELECT * FROM computer";
    final String SQL_CREATE = "INSERT INTO computer (id,name,introduced,discontinued,company_id) VALUES (NULL,?,?,?,?);";
    final String SQL_DELETE = "DElETE FROM computer WHERE id=?";
    final String SQL_UPDATE = "UPDATE computer SET name = ?, introduced = ?, discontinued = ?, company_id = ? WHERE id = ";
    final String SQL_SELECT_ONE = "SELECT * FROM computer WHERE id = ";
    private CompanyService companyService = CompanyService.getInstance();

    @Override
    public boolean create(Computer obj) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_CREATE);
            preparedStatement.setObject(1, obj.getName());
            preparedStatement.setObject(2, Date.valueOf(obj.getIntroduced()));
            preparedStatement.setObject(3, Date.valueOf(obj.getDiscontinued()));
            if(obj.getCompany() == null || obj.getCompany().getId() == 0)
                preparedStatement.setObject(4, null);
            else
                preparedStatement.setObject(4, obj.getCompany().getId());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Computer obj) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_DELETE);
            preparedStatement.setLong(1, obj.getId());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Computer obj) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_UPDATE+obj.getId()+";");
            preparedStatement.setObject(1, obj.getName());
            preparedStatement.setObject(2, obj.getIntroduced());
            preparedStatement.setObject(3, obj.getDiscontinued());
            if(obj.getCompany() == null || obj.getCompany().getId() == 0)
                preparedStatement.setObject(4, null);
            else
                preparedStatement.setObject(4, obj.getCompany().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Computer find(Long id) {
        Computer computer = new Computer();
        try {
            ResultSet result = this.connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(SQL_SELECT_ONE+id);
            if(result.first()) {
                Date introduced = result.getDate("introduced");
                LocalDate convDate = null;
                if(introduced !=null) {
                    convDate = introduced.toLocalDate();
                }
                Date discontinued = result.getDate("discontinued");
                LocalDate convDate1 = null;
                if(discontinued != null) {
                    convDate1 = discontinued.toLocalDate();
                }

                computer.setId(result.getInt("id"));
                computer.setName(result.getString("name"));
                computer.setIntroduced(convDate);
                computer.setDiscontinued(convDate1);
                int company_id = result.getInt("company_id");
                if (company_id != 0) {
                    Company company = companyService.find(company_id);
                    computer.setCompany(company);
                } else
                    computer.setCompany(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computer;    }

    @Override
    public ArrayList<Computer> findAll() {
        ArrayList<Computer> computer_list = new ArrayList<Computer>();
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
                Computer computer = new Computer();

                computer.setId(result.getInt("computer.id"));
                computer.setName(result.getString("computer.name"));
                computer.setIntroduced(convDate);
                computer.setDiscontinued(convDate1);
                int company_id = result.getInt("company_id");
                if (company_id != 0) {
                    Company company = companyService.find(company_id);
                    computer.setCompany(company);
                } else
                    computer.setCompany(null);
                computer_list.add(computer);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return computer_list;
    }


}
