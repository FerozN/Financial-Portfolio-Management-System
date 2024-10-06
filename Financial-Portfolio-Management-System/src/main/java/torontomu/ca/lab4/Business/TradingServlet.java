/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torontomu.ca.lab4.Business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import torontomu.ca.lab4.Helper.FinancialData;
import torontomu.ca.lab4.Persistence.Financial_Data_CRUD;


/**
 *
 * @author student
 */
@WebServlet(name = "TradingServlet", urlPatterns = {"/TradingServlet"})
public class TradingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TradingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TradingServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        List<FinancialData> financialDatas=Financial_Data_CRUD.getAllFinancialData();
        request.setAttribute("financialDatas", financialDatas);
        RequestDispatcher rd= request.getRequestDispatcher("trading.jsp");
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
        String stockSymbol = request.getParameter("stockSymbol");
        String quantity = request.getParameter("quantity");
        String userName = (String)request.getSession().getAttribute("userName");
        request.getSession().setAttribute("userName", userName);
        request.getSession().setAttribute("stockSymbol", stockSymbol);
        request.getSession().setAttribute("quantity", quantity);
        if(stockSymbol.equals(Financial_Data_CRUD.getStockSymbol(stockSymbol))){
           
            RequestDispatcher rd = request.getRequestDispatcher("TradeConfirmation.jsp");
             rd.forward(request, response);
        }
        else{
            doGet(request,response);
        }
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