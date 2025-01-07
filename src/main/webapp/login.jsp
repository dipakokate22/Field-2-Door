<%-- 
    Document   : login
    Created on : 31-Jan-2024, 5:16:07 pm
    Author     : HP
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
<%@page import="model.Registration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	Registration  auth = (Registration ) request.getSession().getAttribute("auth");
	if (auth != null) {
		response.sendRedirect("welcome.jsp");
	}
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	if (cart_list != null) {
		request.setAttribute("cart_list", cart_list);
	}
	%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Page</title>
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
            width: 25%;
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
        .new-registration {
            text-align: center;
            margin-top: 10px;
        }
        .new-registration a {
            color: #007bff;
            text-decoration: none;
        }
        .new-registration a:hover {
            text-decoration: underline;
        }
    </style>
    </head>
    <body>
      <h1>Login Page</h1>
        <form action =NewServlet method="post">
            
            <fieldset>
                <pre>
              <label for="name"><b>User ID<b></label>   <input type ="text" placeholder="Enter your UserId" name="name" required> 
             <label for="password">Password</label>  <input type ="Password" placeholder="Enter your Password" name="password" required>
          <button>Submit</button>  <button type="button" onclick="window.close()">Close</button>
</pre>
                <div class="new-registration">
                <a href="newregistration.jsp"> New Registration </a>
                </div>
            </fieldset>
             
        </form>
    </body>
</html>
