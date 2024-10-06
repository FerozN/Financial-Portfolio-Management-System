<%@page import="torontomu.ca.lab4.Helper.PersonalAccountData"%>
<%@page import="torontomu.ca.lab4.Helper.TransactionData"%>
<%@page import="torontomu.ca.lab4.Helper.WatchlistItem"%>
<%@page import="torontomu.ca.lab4.Persistence.Personal_Accounts_CRUD"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import ="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Financial Portfolio</title>
    <style>
        body { 
            background-image:url('Images/background.jpg');
            background-color: #fff;
            background-size:cover;
            background-postion: center;   
            font-family: Arial, sans-serif; 
            margin: 0;
            padding: 0;
            background-color: #f8f8f8;
        }
        .container { 
            max-width: 800px; 
            margin: auto; 
            padding: 20px; 
            background-color: #fff; 
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); 
            border-radius: 5px; 
        }
        h1 { 
            color: #4CAF50; 
            text-align: center; 
        }
        section {
            margin-top: 30px;
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
        .btn-container {
            display: flex;
            justify-content: center;
            margin-top: 50px;
        }
        .btn {
            cursor: pointer;
            padding: 10px 20px;
            background-color: #333366;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .btn:hover {
            background-color: #5D76A9;
        }
        .no-data {
            text-align: center;
            color: #777;
        }
    </style>
</head>
<body>
    <%
        String userName = (String)session.getAttribute("userName");
        request.getSession().setAttribute("userName",session.getAttribute("userName"));
        List<PersonalAccountData> personalAccounts = (List)request.getAttribute("personalAccounts");
        List<TransactionData> transactions = (List)request.getAttribute("transactions");
        List<WatchlistItem> watchlistitems = (List)request.getAttribute("watchlistitems");
    %>
    <div class="container">
        <h1>Financial Portfolio Menu</h1>
        
        <section id="transaction">
            <h2>Transactions</h2>
            <table>
                <tr>
                    <th>Amount</th>
                    <th>Type</th>
                    <th>Status</th>
                    <th>Price</th>
                    <th>Time</th>
                </tr>
                <% if(transactions.size() > 0) { %>
                    <% for (TransactionData transactionData : transactions) { %>
                        <tr>
                            <td><%= transactionData.getAmount() %></td>
                            <td><%= transactionData.getType() %></td>
                            <td><%= transactionData.getStatus() %></td>
                            <td><%= transactionData.getPrice() %></td>
                            <td><%= transactionData.getTimeStamp() %></td>   
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="5" class="no-data">No data available</td>
                    </tr>
                <% } %>
            </table>
        </section>
        
        <section id="PersonalAccounts">
            <h2>Personal Accounts</h2>
            <table>
                <tr>
                    <th>Account Type</th>
                    <th>Primary User</th>
                    <th>Available Funds</th>
                    <th>Total Balance</th>
                    <th>All Time Return</th>
                </tr>
                <% if(personalAccounts.size() > 0) { %>
                    <% for (PersonalAccountData personalAccountData : personalAccounts) { %>
                        <tr>
                            <td><%= personalAccountData.getAccountPortfolio() %></td>
                            <td><%= personalAccountData.getPortfolioType() %></td>
                            <td><%= personalAccountData.getPrimaryUser() %></td>
                            <td><%= personalAccountData.getAvailableFunds() %></td>
                            <td><%= personalAccountData.getTotalBalance() %></td>
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="6" class="no-data">No data available</td>
                    </tr>
                <% } %>
            </table>
        </section>
        
        <section id="watchlist">
            <h2>Watch list</h2>
            <table>
                <tr>
                    <th>Price</th>
                    <th>Name</th>                
                </tr>
                <% if(watchlistitems.size() > 0) { %>
                    <% for (WatchlistItem watchlistitemData : watchlistitems) { %>
                        <tr>
                            <td><%= watchlistitemData.getPrice() %></td>
                            <td><%= watchlistitemData.getName() %></td>
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="6" class="no-data">No data available</td>
                    </tr>
                <% } %>
            </table>
        </section>
        
        <div class="btn-container">
            <form action="trading">
                <button class="btn">Trade</button>
            </form>
            <form action="login.html" >
                <button class="btn">Logout</button>
            </form>
            <form action="login.html" >
                <button class="btn">Settings</button>
            </form>
        </div>
    </div>
</body>
</html>
