package torontomu.ca.lab4.Persistence;

import torontomu.ca.lab4.Helper.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Personal_Accounts_CRUD {

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FGF?autoReconnect=true&useSSL=false", "root", "student");
            System.out.println("Connection established.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public static List<PersonalAccountData>getAllPersonalAccountData() {
        List<PersonalAccountData> personalAccounts = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM Personal_Accounts";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String accountPortfolio = resultSet.getString("AccountPortfolio");
                String portfolioType = resultSet.getString("PortfolioType");
                String primaryUser = resultSet.getString("PrimaryUser");
                double availableFunds = resultSet.getDouble("AvailableFunds");
                double totalBalance = resultSet.getDouble("TotalBalance");
                double allTimeReturn = resultSet.getDouble("AllTimeReturn");
                PersonalAccountData personalAccountData = new PersonalAccountData(accountPortfolio, portfolioType, primaryUser, availableFunds, totalBalance, allTimeReturn); 
                personalAccounts.add(personalAccountData);
            }   
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return personalAccounts;
    }
}