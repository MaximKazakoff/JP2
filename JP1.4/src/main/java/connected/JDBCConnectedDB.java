package connected;

import dao.UserJdbcDAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectedDB {

    private static Connection getMysqlConnection() {
        try {
            Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.registerDriver(driver);

            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_example?serverTimezone=Europe/Moscow",
                    "root",
                    "root1234");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public static UserJdbcDAO getUserDAO() {
        return new UserJdbcDAO(getMysqlConnection());
    }

}
