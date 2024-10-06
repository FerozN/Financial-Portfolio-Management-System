<%@page import="torontomu.ca.lab4.Helper.FinancialData"%>
<%@page import="torontomu.ca.lab4.Persistence.Personal_Accounts_CRUD"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import ="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perform Trade</title>
    <style>
        body {
            background-image:url('Images/background.jpg');
            background-color: #fff;
            background-size:cover;
            background-postion: center;   
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
            text-align: center;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #666;
        }
        input[type="text"],
        input[type="number"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
    </style>
</head>
<body>
    <%
        String userName = (String)session.getAttribute("userName");
        request.getSession().setAttribute("userName",session.getAttribute("userName"));
        List<FinancialData> financialDatas = (List)request.getAttribute("financialDatas");
        
    %>
    <div class="container">
        <h2>Trade Form</h2>
        <form action="trading" method="post">
            <label for="stockSymbol">Stock Symbol:</label>
            <input type="text" id="stockSymbol" name="stockSymbol" required><br><br>
            
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" min="1" required><br><br>
            
            <input type="submit" value="Submit">
        </form>

        <h2>Financial Data</h2>
        <table>
            <tr>
                <th>Volume</th>
                <th>Price</th>
                <th>Symbol</th>
                <th>Watchlist</th>
             </tr>
             <% 
                int watchlist = 0;
                if(financialDatas.size()>0){
                    for (FinancialData financialData:financialDatas){
                        if(financialData.getWatchlist() == true){
                            watchlist = 1;
                        }
             %>
                        <tr>
                            <td><%= financialData.getVolume() %></td>
                            <td><%= financialData.getPrice() %></td>
                            <td><%= financialData.getSymbol() %></td>
                            <td><%= watchlist%></td>   
                        </tr>
             <% 
                        }  
                    }
                    else{
             %>
                        <tr>
                            <td colspan="6">No data available</td>
                        </tr>
                <% 
                    }
                %>        
        </table>
    </div>
</body>
</html>
