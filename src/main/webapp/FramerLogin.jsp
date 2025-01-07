<%-- 
    Document   : FramerLogin
    Created on : 06-Feb-2024, 11:34:09 pm
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
            color: #333;
        }
        form {
            max-width: 300px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        fieldset {
            border: none;
            padding: 0;
            margin: 0;
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
            color: #555;
        }
        input[type="text"],
        input[type="password"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
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
       <h1>Login Page </h1>
        <form action =FramerLoginServlet method="post">
            <center>
            <fieldset>
                
                <lablel><b>  UserId </b></lablel>
                <input type ="text" placeholder="Enter your UserId" name="name" ><br>
                <lablel><b> Password</b></lablel>  
                <input type ="Password" placeholder="Enter your Password" name="password"><br>
            <button>Submit</button>  

                
            </fieldset>
             </center>
        </form>
   
    </body>
</html>
