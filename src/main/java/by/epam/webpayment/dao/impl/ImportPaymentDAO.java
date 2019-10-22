package by.epam.webpayment.dao.impl;

import java.sql.*;

public class ImportPaymentDAO {

    public static String getPayment(){



            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return "null";
            }

            System.out.println("PostgreSQL JDBC Driver successfully connected");
            Connection connection = null;

            connection= ConnectionPool.getInstance().getConnection();
            /*
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return "null";
        }
*/
            if (connection != null) {
                System.out.println("You successfully connected to database now");
            } else {
                System.out.println("Failed to make connection to database");
            }
            try {
                try {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM payments");
                    while (rs.next()) {
                        String str = rs.getString("id") + ":" + rs.getString(2) + " "
                                + rs.getString(3) + " " + rs.getString(4);
                        //double money=rs.get;
                        System.out.println("Contact:" + str);
                        return str;
                    }
                    rs.close();
                    stmt.close();
                } finally {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return "null";

    }
}
