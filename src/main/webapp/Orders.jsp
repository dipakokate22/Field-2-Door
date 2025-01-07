<%-- 
    Document   : Orders
    Created on : 02-Apr-2024, 7:43:26 pm
    Author     : HP
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cart"%>
<%@page import="connection.Dbcom"%>
<%@page import="Dao.OrderDao"%>
<%@page import="java.util.List"%>
<%@page import="model.Order"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.Registration"%>
<%@page import="java.util.*"%>
<%@page import="Dao.ProductDao"%>
	
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<%
	DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
	Registration auth = (Registration) request.getSession().getAttribute("auth");
	List<Order> orders = null;
	if (auth != null) {
	    request.setAttribute("person", auth);
	    OrderDao orderDao  = new OrderDao(Dbcom.getConnection());
		orders = orderDao.userOrders(auth.getId());

	}else{
		response.sendRedirect("login.jsp");
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
        <title>Order</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
    </head>
    <body>
        <div class="container">
		<div class="card-header my-3">All Orders</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
                                       	<tbody>
			
			<%
			if(orders != null){
				for(Order o:orders){%>
					<tr>
						<td><%=o.getDate() %></td>
						<td><%=o.getName() %></td>
						<td><%=o.getCategory() %></td>
						<td><%=o.getQunatity() %> Kg</td>
						<td><%=dcf.format(o.getPrice()) %></td>
						<td>
                                <a class="btn btn-sm btn-danger" href="cancelorder?id=<%= o.getOrderId() %>" onclick="return confirm('Are you sure you want to cancel this order?')">Cancel Order</a>
                            </td>
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>
                         <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
