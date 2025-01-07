<%-- 
    Document   : Cart
    Created on : 24-Feb-2024, 10:57:32 am
    Author     : HP
--%>

<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%@page import="connection.Dbcom"%>
<%@page import="Dao.ProductDao"%>
<%@page import="model.Registration"%>

<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="deo.CheckOutServlet"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     Registration auth = (Registration) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}

    DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
    if (cart_list != null) {
	ProductDao pDao = new ProductDao(Dbcom.getConnection());
	cartProduct = pDao.getCartProducts(cart_list);
        double total = pDao.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);
	request.setAttribute("cart_list", cart_list);
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        /* Custom styles */
        .container {
            margin-top: 50px;
        }
        .table tbody td {
            vertical-align: middle;
        }
        .btn-incre,
        .btn-decre {
            font-size: 25px;
        }
        .btn-group {
            display: flex;
            align-items: center;
        }
        .btn-group .btn {
            margin-right: 5px;
        }
        .total-price {
            font-size: 24px;
        }
    </style>
    
}
           </style>
    </head>
    <body>
      
	<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price:  ${(total>0)?dcf.format(total):0} </h3>
                    <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a> 
                </div>
		<table class="table table-light">
			<thead>
				<tr>
					
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
                                        <th scope="col">Quantity</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
                            <%
                            if(cart_list !=null)
                            {
                                for (Cart c : cartProduct)
                                {%>
                                
                                    
                                    
                                    <tr>
					         <td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
                                          <td><%= c.getPrice()%></td>
                                                   
					<td>
						<form action="order-now" method="post" class="form-inline">
						<input type="hidden" name="id" value="1" class="form-input">
							<div class="form-group d-flex justify-content-between">
                                                          <a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a>
                                                        
                                                          <input type="text" name="quantity" class="form-control "  value="<%=c.getquantity()%> Kg " readonly> 
								<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
								<button type="submit" class="btn btn-primary btn-sm">Buy</button>
							</div>
                                                               
                                                                
							
						</form>
					</td>
                                        <td><a href="remove-from-cart?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
					
				    </tr>
                               <% }
                            }
                            
                            
                            %>
				

				
			</tbody>
		</table>
	</div>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
