package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAO<T> {

    protected Connection connection = null;

    public DAO() {
        if(this.connection == null) {
                try {
                    this.connection = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/computer-database-db?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
                            "admincdb",
                            "qwerty1234");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public abstract boolean create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract T find(Long id);

    public abstract ArrayList<T> findAll();
}
