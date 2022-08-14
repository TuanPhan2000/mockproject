package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static DbUtil instance = null;

    public static DbUtil getInstance(){
        return instance != null ? instance : new DbUtil();
    }

    private Connection connection = null;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mockproject", "root", "admin");
        }

        return connection;
    }

}
