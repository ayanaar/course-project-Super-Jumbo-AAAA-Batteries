// code for checking database connection on intellij

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJDBC {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYSQL_SERVER_NAME", "USER", "PASSWORD");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from TABLE NAME");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("COLUMN NAME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
