<%-- 
    Document   : welcome
    Created on : 31-Jan-2024, 7:48:14 pm
    Author     : HP
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@ page import="java.util.Base64" %>
<%@page import="Helper.helper"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@page import="connection.Dbcom"%>
<%@page import="model.Registration"%>
<%@page import="Dao.ProductDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  Registration auth = (Registration) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
  
}
//ProductDao pd = new ProductDao(Dbcom.getConnection());
ProductDao pd = new ProductDao(Dbcom.getConnection());
List<Product> products = pd.getAllProducts();

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <link href="navbar.css" ref="stylesheet"/>
    </head>
    <body>
             <form action =NavbarServlet method="post" enctype="multipart/form-data">
     
        <div class = "navbar">
            
            <nav class="navbar1">
                <a href="FramerRegistration.jsp"> FarmerRegistration </a><br>
                <a href="categery.jsp"> category </a>             
                <a href="Cart.jsp"> Cart </a>
                <a href="Orders.jsp"> orders </a>
            </nav>
        </div>
          
          <div class="container">
              <div class="card-header my-3"> All Product</div>
              <div class="row">
                  <%
                  if(!products.isEmpty())
                  {
                      for(Product p:products){
                           String imageDataString = p.getImage();
                             byte[] imageDataBytes;
                            String base64Image;
    try {
        imageDataBytes = Base64.getDecoder().decode(imageDataString);
        base64Image = Base64.getEncoder().encodeToString(imageDataBytes);
    } catch (IllegalArgumentException e) {
        // Handle the exception (e.g., provide a fallback image or log the error)
        base64Image = ""; // Provide a fallback image or set it to an empty string
        e.printStackTrace(); // Log the exception for debugging
    }
                      
                         %>
			<div class="col-md-3 my-3">
				 <div class="card mb-4">
			
                            <img class="card-img-top" src="data:image/jpeg;base64,<%= base64Image %>" alt="Product Image">
					
						<h5 class="card-title"><%=p.getName() %></h5>
                                           
						<h6 class="price">Price: Rs<%=p.getPrice() %></h6>                                            
						<h6 class="category">Category: <%=p.getCategory() %></h6>
                                                  <h6 class="Quantity">Quantity: <%=p.getQuantity()%> kg </h6>  
                                                <h6 class="Discount">discount:<%=p.getDiscount()%> Off</h6>
                                              
						 <div class="mt-3">
							<a class="btn btn-dark" href="add-to-cart?id=<%=p.getId()%>">Add to Cart</a>
                                                        
                                                       <a class="btn btn-primary" href="order-now?quantity=1&id=<%=p.getId()%>">Buy Now</a>
						</div>
					
				
			</div>
                                                </div>
                                                
			<%
                      }
                  
                  }else {
			out.println("There is no proucts");
			}
                  
                  
                  %>     
              </div>
              
          </div>
          
        </div>
        </form>
              <style>
    .navbar {
        display: flex;
        justify-content: center;
        align-items: right;
        border-bottom: 1px solid black transparent;
        box-shadow: 0 5px 10px rgba(0, 0, 0, .4);
        background-color: #f8f9fa; 
        padding: 10px 0; 
    }
    .navbar a {
        margin: 0 10px; 
        color: black;
        text-decoration: none; /* Remove underline from links */
        transition: color 0.3s; /* Add smooth color transition */
    }
    .navbar a:hover {
        color: blue; /* Change color on hover */
    }
    
    .card {
        border: 1px solid #ccc; /* Add border */
        border-radius: 5px; /* Add border radius */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Add shadow */
        margin-bottom: 20px; /* Add margin between cards */
    }
    .card-img-top {
        object-fit: cover; /* Ensure images fit within the card */
        border-top-left-radius: 5px; /* Add border radius to image corners */
        border-top-right-radius: 5px;
    }
    .card-body {
        padding: 10px; /* Add padding to card body */
    }
    .card-title {
        font-size: 18px; /* Increase font size for title */
        margin-bottom: 10px; /* Add margin below title */
    }
    .price, .category, .quantity, .discount {
        margin-bottom: 5px; /* Add margin between product details */
        font-size: 14px; /* Adjust font size */
        color: #555; /* Add a subtle color for details */
    }
    .btn {
        margin-top: 10px; /* Add margin above buttons */
    }
    
    body {
        font-family: Arial, sans-serif; /* Use a common font for better readability */
        background-color: #f8f9fa; /* Set background color */
        color: #333; /* Set text color */
        margin: 0; /* Remove default margin */
        padding: 20px; /* Add padding to the body */
    }
    .container {
        max-width: 1200px; /* Limit container width for better readability */
        margin: 0 auto; /* Center the container */
    }
    
</style>

    </body>
</html>
