package persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public abstract class DAO<T> {

    protected Connection connection = null;

    public DAO() {
        if(this.connection == null) {
            final Properties prop = new Properties();
            InputStream input = null;
            try {
                input = new FileInputStream("db.properties");
                prop.load(input);

                try {
                    this.connection = DriverManager.getConnection(
                            prop.getProperty("db.url"),
                            prop.getProperty("db.username"),
                            prop.getProperty("db.password"));


                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }catch(final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public abstract boolean create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract T find(int id);

    public abstract ArrayList<T> findAll();
}
