package torontomu.ca.lab4.Persistence;


import torontomu.ca.lab4.Helper.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class user_CRUD {

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FGF?autoReconnect=true&useSSL=false", "root", "student");
            System.out.println("Connection established.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    // username and password method
    public static UserData getUserByUsernameAndPassword(String username, String password) {
        System.out.println(username + " "+ password);
        UserData userData = null;
        
        //get username and password from database
        try {
            Connection connection = getConnection();
            // creatres query varible
            String query = "SELECT * FROM ACCOUNT WHERE Acc_Name = '" + username + "' AND Password = '" + password + "'";
            // looks up the query variable from the database if no mathc is found the table == NULL
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            // takes the valid query output and sets it as a variable 
            ResultSet resultSet = preparedStatement.executeQuery();
            //splits username and password
            if (resultSet.next()) {
                String accName = resultSet.getString("Acc_Name");
                String pass = resultSet.getString("Password");
                userData = new UserData(accName, pass); 
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return userData;
    }

    
}