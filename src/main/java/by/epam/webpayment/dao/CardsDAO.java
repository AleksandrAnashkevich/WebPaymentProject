package by.epam.webpayment.dao;

import by.epam.webpayment.entity.Card;

import java.util.List;

public interface CardsDAO {
    List<Card> findAll (int idAccount);

    Card findById (int id);

    void insert (Card card);

    void delete (Card card);

    void update (Card card);
}
