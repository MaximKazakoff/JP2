package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {
    private Connection connection;

    public UserJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    public void addUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO bank_client(name, password, money) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getMoney());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("update bank_client set name= ?, password= ?, money= ? where id = ?")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getMoney());
            preparedStatement.setLong(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from bank_client where id= ?")) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isExistUser(User user) {
        boolean res = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from bank_client where name= ? and password= ? and money= ?")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setLong(3, user.getMoney());
            ResultSet result = preparedStatement.executeQuery();
            res = result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<User> getAllUsers() {
        List<User> resultList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from bank_client")) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                resultList.add(new User(
                        result.getLong("id"),
                        result.getString("name"),
                        result.getString("password"),
                        result.getLong("money")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<List<String>> getAllUsersList() {
        List<List<String>> resultList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from bank_client")) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                List<String> userList = new ArrayList<>();
                userList.add(String.valueOf(result.getLong("id")));
                userList.add(result.getString("name"));
                userList.add(result.getString("password"));
                userList.add(String.valueOf(result.getLong("money")));
                resultList.add(userList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }



}
