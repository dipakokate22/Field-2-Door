/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FramerLoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FramerLoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FramerLoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
             Class.forName("com.mysql.jdbc.Driver");  try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vegetable?useSSL=false","root","root")) {
                String n = request.getParameter("name");
                String p = request.getParameter("password");
                out.println(n);
                out.println(p);
                PreparedStatement ps = con.prepareStatement("select * from FramerRegistration where UserId=? and password=?");
                ps.setString(1, n);
                ps.setString(2, p);
                
                ResultSet rs = ps.executeQuery();
                out.println(rs);
                out.println(ps);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null," Framer Login Successfully");
                    RequestDispatcher rd = request.getRequestDispatcher("AddProduct.jsp");
                    rd.forward(request, response);
                } else {
                    out.println("<font color=red size=5>Login Failed!!<br>");
                    out.println("<a href=FramerLogin.jsp>Try Again!!</a>");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FramerLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FramerLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
