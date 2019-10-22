package by.epam.webpayment.dao.impl;

import by.epam.webpayment.dao.RolesDAO;
import by.epam.webpayment.entity.Payment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RolesDAOImpl implements RolesDAO {
    public String findById(int id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(selectById(id));
                while (rs.next()) {
                    return rs.getString("name_role");
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

    private String selectById(int id) {
        return "SELECT * FROM roles WHERE id=" + id;
    }
}

