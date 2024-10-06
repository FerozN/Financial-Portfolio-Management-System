/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torontomu.ca.lab4.Business;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import torontomu.ca.lab4.Helper.*;
import torontomu.ca.lab4.Persistence.*;
/**
 *
 * @author student
 */

public class MenuServlet extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = (String)request.getSession().getAttribute("userName");
        request.getSession().setAttribute("userName", userName);
        List<PersonalAccountData> personalAccounts = Personal_Accounts_CRUD.getAllPersonalAccountData();
        
        request.setAttribute("personalAccounts", personalAccounts);
        List<TransactionData> transactions = Transactions_CRUD.getAllTransactions();
        
        request.setAttribute("transactions", transactions);
        List<WatchlistItem> watchlistitems = Watchlist_CRUD.getAllWatchlistitems();
        
        request.setAttribute("watchlistitems", watchlistitems );
        RequestDispatcher rd= request.getRequestDispatcher("Menu.jsp");
        rd.forward(request, response);
        
        
      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}