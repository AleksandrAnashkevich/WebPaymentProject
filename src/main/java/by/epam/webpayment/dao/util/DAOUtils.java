package by.epam.webpayment.dao.util;

import by.epam.webpayment.dao.impl.ConnectionPool;

import java.sql.Connection;
import java.sql.Statement;

public class DAOUtils {
    public static void executeUpdateUtil(String sql)
    {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try {
            try {
                Statement stmt = connection.createStatement();

                stmt.executeUpdate(sql);
                stmt.close();
            } finally {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
