/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torontomu.ca.lab4.Persistence;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import torontomu.ca.lab4.Helper.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;


@WebServlet(name = "Financial_Data_CRUD", urlPatterns = {"/Financial_Data_CRUD"})
public class Financial_Data_CRUD extends HttpServlet {
    
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
    public static List<FinancialData> getAllFinancialData(){
        List<FinancialData> financialDatas = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM FinancialData";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double Volume = resultSet.getDouble("Volume");
                double Price = resultSet.getDouble("Price");
                String Symbol = resultSet.getString("Symbol");
                boolean Watchlist = resultSet.getBoolean("Watchlist");
                
                FinancialData financialData= new FinancialData(Volume,Price,Symbol,Watchlist); 
                financialDatas.add(financialData);
            }   
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return financialDatas;
    }
    public static String getStockSymbol(String Symbol){
        String symbol = "";
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM FinancialData where Symbol = '"+ Symbol+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String s = resultSet.getString("Symbol");
                symbol = s;
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return symbol;
    }
}
