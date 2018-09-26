import java.sql.*;

public class JDBCExample {

    public static void main(String[] argv) {

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");



        Statement stmt;
        ResultSet rs;

        try {

            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();
            return;

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
                    "database123");

            // Step 3 - Execute statement
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * from student");

            // Step 4 - Get result
            while (rs.next()) {
                System.out.println(rs.getString(1) + " :: " + rs.getString(2) );
            }

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

}