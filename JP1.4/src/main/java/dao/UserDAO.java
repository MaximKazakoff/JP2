package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void editUser(User user);
    void deleteUser(User user);
    boolean isExistUser(User user);
    List<User> getAllUsers();
}
