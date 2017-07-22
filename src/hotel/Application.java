package hotel;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hotel";
        String login = "root";
        String password = "root";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM clients");
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("name")
                        + " Surname: " + resultSet.getString("surname")
                        + " Date of birth: " + resultSet.getString("date_of_birth")
                        + " Country: " + resultSet.getString("country")
                        + " City: " + resultSet.getString("city")
                        + " Address: " + resultSet.getString("address")
                        + " Zip code: " + resultSet.getString("zip_code")
                        + " Arrival: " + resultSet.getString("arrival")
                        + " Departure: " + resultSet.getString("departure"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
