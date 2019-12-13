package by.epam.webpayment.dao.impl;

import by.epam.webpayment.dao.PaymentDAO;
import by.epam.webpayment.dao.util.DAOUtils;
import by.epam.webpayment.entity.Payment;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    public List<Payment> findPayments() {

        Connection connection = ConnectionPool.getInstance().getConnection();
        List<Payment> payments = new ArrayList<Payment>();
        try {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM payments");
                while (rs.next()) {
                    payments.add(new Payment(rs.getInt("id"), rs.getDouble("amount"),
                            rs.getString("number_payment"), rs.getString("name")));
                }
                rs.close();
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payments;
    }

    public Payment findById(int id) {

        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlSelectById(id));
                while (rs.next()) {
                    return new Payment(rs.getInt("id"), rs.getDouble("amount"),
                            rs.getString("name"), rs.getString("number_payment"));
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

    public Payment findByNumber(String number) {

        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sqlSelectByNumber(number));
                while (rs.next()) {
                    return new Payment(rs.getInt("id"), rs.getDouble("amount"),
                            rs.getString("number_payment"), rs.getString("name"));
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

    public void insert(Payment payment) {

        DAOUtils.executeUpdateUtil(sqlInsert(payment));
    }

    public void update(Payment payment) {

        DAOUtils.executeUpdateUtil(sqlUpdate(payment));
    }

    public void delete(Payment payment) {
        System.out.println(sqlDelete(payment));
        DAOUtils.executeUpdateUtil(sqlDelete(payment));
    }

    private String sqlSelectById(int id) {
        return "SELECT * FROM payments WHERE id=" + id;
    }

    private String sqlSelectByNumber(String number) {
        return "SELECT * FROM payments WHERE number_payment=" + number;
    }

    private String sqlInsert(Payment payment) {
        return "INSERT INTO payments (amount, name, number_payment)" +
                " VALUES " +
                "(" + payment.getAmount() +
                ",'" + payment.getName() +
                "','" + payment.getNumber() +
                "');";
    }

    private String sqlUpdate(Payment payment) {
        return "UPDATE payments SET " +
                "amount=" + payment.getAmount() +
                ", name='" + payment.getName() +
                "', number_payment='" + payment.getNumber() +
                "' WHERE Id=" + payment.getId();
    }

    private String sqlDelete(Payment payment) {
        return "DELETE FROM payments " +
                "WHERE id=" + payment.getId();
    }
}
