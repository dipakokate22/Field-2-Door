/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;

/**
 *
 * @author HP
 */
@WebServlet("/quantity-inc-dec")
public class QuantityIncDecServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));
            ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

            if (action != null && id >= 1 && cartList != null) {
                if (action.equals("inc")) {
                    for (Cart cart : cartList) {
                        if (cart.getId() == id) {
                            int Quantity = cart.getquantity();
                            Quantity++;
                            cart.setquantity(Quantity);
                            break;
                        }
                    }
                } else if (action.equals("dec")) {
                    for (Cart cart : cartList) {
                        if (cart.getId() == id && cart.getquantity() > 1) {
                            int Quantity = cart.getquantity();
                            Quantity--;
                            cart.setquantity(Quantity);
                            break;
                        }
                    }
                }
            }
            response.sendRedirect("Cart.jsp");
        }
    }
}
