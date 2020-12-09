package sk.it.jdbc;

import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful!");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
