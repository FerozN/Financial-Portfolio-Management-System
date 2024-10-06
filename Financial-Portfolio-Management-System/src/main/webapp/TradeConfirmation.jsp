<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trade Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
            text-align: center;
        }
        p {
            margin: 10px 0;
            color: #555;
        }
        .confirmation-info {
            margin-top: 20px;
            border-top: 1px solid #ddd;
            padding-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Trade Confirmation</h2>
        <p>Thank you for your trade request!</p>
        <div class="confirmation-info">
            <p><strong>Stock Symbol:</strong> <%= session.getAttribute("stockSymbol") %></p>
            <p><strong>Quantity:</strong> <%= session.getAttribute("quantity") %></p>
        </div>
    </div>
</body>
</html>