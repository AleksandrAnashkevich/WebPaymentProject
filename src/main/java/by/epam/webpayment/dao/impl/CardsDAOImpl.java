package by.epam.webpayment.dao.impl;

import by.epam.webpayment.dao.CardsDAO;
import by.epam.webpayment.dao.util.DAOUtils;
import by.epam.webpayment.entity.Card;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CardsDAOImpl implements CardsDAO {

    @Override
    public List<Card> findAll(int idAccount) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        List<Card> cards = new ArrayList<Card>();
        try {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlFindAll(idAccount));
                while (rs.next()) {
                    cards.add(new Card(rs.getInt("id"), rs.getDouble("deposit"),
                            rs.getString("number"), rs.getString("cvc"),
                            rs.getInt("arrays_id")));
                }
                rs.close();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cards;

    }

    @Override
    public Card findById(int id) {
        {

            Connection connection = ConnectionPool.getInstance().getConnection();

            try {
                try {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM cards WHERE id=" + id);
                    while (rs.next()) {
                        return new Card(rs.getInt("id"), rs.getDouble("deposit"),
                                rs.getString("number"), rs.getString("cvc"),
                                rs.getInt("arrays_id"));
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

    @Override
    public void insert(Card card) {
        DAOUtils.executeUpdateUtil(sqlInsert(card));
    }

    @Override
    public void update(Card card) {
        System.out.println(sqlUpdate(card));
        System.out.println(card.toString());
        DAOUtils.executeUpdateUtil(sqlUpdate(card));
    }

    @Override
    public void delete(Card card) {
        DAOUtils.executeUpdateUtil(sqlDelete(card));
    }

    private String sqlFindAll(int idAccount) {
        return "SELECT * FROM cards WHERE arrays_id=(" +
                sqlSelectForUserId(idAccount) + ")";
    }

    private String sqlById(int id) {
        return "SELECT * FROM cards WHERE id=" + id;
    }

    private String sqlSelectForUserId(int userId) {
        return "SELECT card_arrays.id FROM accounts \n" +
                "INNER JOIN card_arrays\n" +
                "ON accounts.id=card_arrays.account_id\n" +
                "WHERE user_id=" + userId;
    }

    private String sqlInsert(Card card) {
        return "INSERT INTO cards (number, cvc, arrays_id)" +
                " VALUES " +
                "('" + card.getNumber() +
                "','"+ card.getCvv() +
                "',(" + sqlSelectForUserId(card.getArrayId()) +
                "));";
    }

    private String sqlUpdate(Card card) {
        return "UPDATE cards SET " +
                "deposit=" + card.getDeposit() +
                " WHERE Id=" + card.getId();
    }

    private String sqlDelete(Card card) {
        return "DELETE FROM cards " +
                "WHERE id=" + card.getId();
    }
}
