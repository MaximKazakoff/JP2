package service;

import connected.HibernateConnectedDB;
import dao.UserHibernateDAO;
import model.User;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserService implements UserServiceInterface {

    private static UserService userService;

    private SessionFactory sessionFactory;

    private UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(HibernateConnectedDB.getSessionFactory());
        }
        return userService;
    }

    @Override
    public void addUser(User user){
        System.out.println("<---- Used method: addUser() ---->");
        System.out.println(user.toString());
//        HibernateUserDAO dao =  new HibernateUserDAO(sessionFactory.openSession());
        if (!new UserHibernateDAO(sessionFactory.openSession()).isExistUser(user)) {
            new UserHibernateDAO(sessionFactory.openSession()).addUser(user);
        }
    }

    @Override
    public void updateUser(User user) {
        System.out.println("<---- Used method: editUser() ---->");
        System.out.println(user.toString());
//        JDBCConnectedDB.getUserDAO().editUser(user);
        new UserHibernateDAO(sessionFactory.openSession()).editUser(user);
    }

    @Override
    public void deleteUser(User user) {
        System.out.println("<---- Used method: deleteUser() ---->");
        System.out.println(user.toString());
//        JDBCConnectedDB.getUserDAO().deleteUser(user);
        new UserHibernateDAO(sessionFactory.openSession()).deleteUser(user);
    }

    public List<User> getAllUsers() {
        System.out.println("<---- Used method: getAllUsers() ---->");
//        return JDBCConnectedDB.getUserDAO().getAllUsersList();
        return new UserHibernateDAO(sessionFactory.openSession()).getAllUsers();
    }



}
