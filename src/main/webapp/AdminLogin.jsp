<%-- 
    Document   : AdminLogin
    Created on : 19-Mar-2024, 12:45:11 am
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login </title>
         <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            text-align: center;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #555;
            font-size: 16px;
            
        }
        input[type="text"],
        input[type="password"] {
            width: 20%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }
        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
    </head>
    <body>
        <h1>Admin Login</h1>
         <form action =AdminServlet method="post">
            <center>
            <fieldset>
                <pre>
            <lablel><b>  UserId </b></lablel>
                <input type ="text" placeholder="Enter your UserId" name="name"/> 
            <lablel><b> Password</b></lablel>   
            <input type ="Password" placeholder="Enter your Password" name="password"/>
            <button>Submit</button>  <button type="button" onclick="window.close()">Close</button>
</pre>
              
            </fieldset>
             </center>
        </form>
    </body>
</html>
