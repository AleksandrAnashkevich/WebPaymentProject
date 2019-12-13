package by.epam.webpayment.dao;

import by.epam.webpayment.entity.User;

import java.sql.Connection;
import java.util.List;

public interface UserDAO {
    List<User> findAll ();

    User findById (int id);

    User findByLogin (String login);

    void insert (User user);

}
