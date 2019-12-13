package by.epam.webpayment.dao.impl;

import by.epam.webpayment.dao.UserDAO;
import by.epam.webpayment.dao.util.DAOUtils;
import by.epam.webpayment.entity.User;

import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl implements UserDAO {
    public List<User> findAll() {
        Connection connection = ConnectionPool.getInstance().getConnection();
        List<User> users = new ArrayList<User>();
        try {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users");
                while (rs.next()) {
                    users.add(new User(rs.getInt("id"), rs.getString("first_name"),
                            rs.getString("second_name"), rs.getString("login"),
                            rs.getString("password"), rs.getString("email"),
                            rs.getInt("role_id")));
                }
                rs.close();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }

    public User findById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id=" + id);

                if (rs.next()) {

                    return new User(rs.getInt("id"), rs.getString("first_name"),
                            rs.getString("second_name"), rs.getString("login"),
                            rs.getString("password"), rs.getString("email"),
                            rs.getInt("role_id"));
                }
                rs.close();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public User findByLogin(String login) {
        try {
            Connection connection= ConnectionPool.getInstance().getConnection();
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE login='" + login + "'");

                if (rs.next()) {

                    return new User(rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("second_name"),
                            rs.getString("login"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getInt("role_id"));
                }
                rs.close();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void insert(User user) {
        DAOUtils.executeUpdateUtil(sqlInsert(user));
        DAOUtils.executeUpdateUtil(sqlInsertAccount(user));
        DAOUtils.executeUpdateUtil(sqlInsertArray(user));
    }



    private String sqlInsert(User user) {
        return "INSERT INTO users (first_name, second_name, login, email, password, role_id)" +
                "VALUES " +
                "('" + user.getFirstName() +
                "','" + user.getSecondName() +
                "','" + user.getLogin() +
                "','" + user.getEmail() +
                "','" + user.getPassword() +
                "',"
                + "(SELECT id FROM roles WHERE name_role='regular'));";
    }

    private String sqlInsertAccount(User user){
        return "insert into accounts (user_id, locked)\n" +
                "values ((select id from users where login='"+user.getLogin()+"'), false)";
    }

    private String sqlInsertArray(User user){
        return "insert into card_arrays (account_id)\n" +
                "values ((select id from accounts where user_id=" +
                "(select id from users where login='"+user.getLogin()+"')))";
    }
}
