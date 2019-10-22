package by.epam.webpayment.dao.impl;

import by.epam.webpayment.dao.PaymentsDAO;
import by.epam.webpayment.entity.Payment;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentsDAOImpl implements PaymentsDAO {
    public List<Payment> findPayments() {

        Connection connection = ConnectionPool.getInstance().getConnection();
        List<Payment> payments = new ArrayList<Payment>();
        try {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM payments");
                while (rs.next()) {
                    payments.add(new Payment(rs.getInt("id"), rs.getDouble("amount"),
                            rs.getString("name"), rs.getString("number_payment")));
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
}
