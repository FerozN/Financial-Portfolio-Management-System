package torontomu.ca.lab4.Business;

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


public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
   //synchronus login change to asynch with microservices (jwt)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Do Post");
        //request parameters from Login.html
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
     
        //Creates userData object and will only return username and password if its valid
        UserData userData = user_CRUD.getUserByUsernameAndPassword(username, password);
          
        
        System.out.println("this is "+(userData==null));
        request.setAttribute("userName",username);
        if (userData == null) {
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
        } else {
            request.getSession().setAttribute("userName", username);
            response.sendRedirect("menu");
          
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
