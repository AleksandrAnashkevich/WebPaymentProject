package by.epam.webpayment.dao;

import by.epam.webpayment.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll ();

    User findByLogin (String login);

}
