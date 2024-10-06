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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  java.util.List;
import java.util.ArrayList;
import torontomu.ca.lab4.Helper.PersonalAccountData;
import torontomu.ca.lab4.Helper.*;
/**
 *
 * @author student
 */
@WebServlet(name = "Transactions_CRUD", urlPatterns = {"/Transactions_CRUD"})
public class Transactions_CRUD extends HttpServlet {

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
    
    public static List<TransactionData> getAllTransactions(){
        List<TransactionData> transaction = new ArrayList<>();
        
        try{
            Connection connection = getConnection();
            String query = "SELECT * FROM Transactions ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double Amount = resultSet.getDouble("Amount");
                String Tran_Type = resultSet.getString("Tran_Type");
                String Status = resultSet.getString("Status");
                String Dates= resultSet.getString("Dates");
                double price = resultSet.getDouble("Price");
               
               TransactionData transactionData = new TransactionData(Amount, Tran_Type,Status,price,Dates);
               transaction.add(transactionData);
                       
            }   
             connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return transaction;
    }
        }
