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
@WebServlet(name = "Watchlist_CRUD", urlPatterns = {"/Watchlist_CRUD"})
public class Watchlist_CRUD extends HttpServlet {

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
    
    public static List<WatchlistItem> getAllWatchlistitems(){
        List<WatchlistItem> watchlist = new ArrayList<>();
        
        try{
            Connection connection = getConnection();
            String query = "SELECT * FROM Watchlist ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double price = resultSet.getDouble("Price");
                String Wname = resultSet.getString("Wname");
               
               WatchlistItem watchlists= new WatchlistItem(price,Wname);
               watchlist.add(watchlists);
                       
            }   
             connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return watchlist;
    }
        }