package postgres;

import java.sql.Connection;
import java.sql.Statement;


public class CreateTable {
    public static void main(String args[]) {
        DatabaseUtil databaseUtil = new DatabaseUtil();
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = databaseUtil.getConnection();
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE COMPANY " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}