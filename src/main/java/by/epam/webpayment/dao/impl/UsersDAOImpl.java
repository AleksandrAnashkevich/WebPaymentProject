package by.epam.webpayment.dao.impl;

import by.epam.webpayment.dao.UserDAO;
import by.epam.webpayment.entity.User;

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

    public User findByLogin(String login) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE login='" + login+"'");
                while (rs.next()) {
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



}
