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
import java.sql.SQLException;
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
public class RegistrationServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            Class.forName("com.mysql.jdbc.Driver");  try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vegetable?useSSL=false","root","root")) {
                 String n = request.getParameter("Name");
        String e = request.getParameter("Email");
        String m = request.getParameter("mobile_no");
        String c = request.getParameter("Country");
        String a = request.getParameter("address");
        String u = request.getParameter("name");
        String p = request.getParameter("password");
         out.println("Name " + n);
        out.println("Email " + e);
        out.println("mobile_no " + m);
        out.println("Country " + c);
        out.println("address " + a);
        out.println("name " + u);
        out.println("password " + p);
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO registration(name,Email,mobile_no,country,address,UserId,password) VALUES(?,?,?,?,?,?,?)")) {
    ps.setString(1, n);
    ps.setString(2, e);
    ps.setString(3, m);
    ps.setString(4, c);
    ps.setString(5, a);
    ps.setString(6, u);
    ps.setString(7, p);

    int rowsAffected = ps.executeUpdate(); // Use executeUpdate for INSERT queries

    if (rowsAffected > 0) {
        // Registration successful
         JOptionPane.showMessageDialog(null," User Registration  Successfully");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    } else {
        // Registration failed
        out.println("<font color=red size=5>Registration Failed!!<br>");
        out.println("<a href=registration.jsp>Try Again!!</a>");
    }
} catch (Exception d) {
    // Properly handle or log the exception
    out.println("<font color=red size=5>Error occurred during registration!<br>");
    out.println("<a href=newregistration.jsp>Try Again!!</a>");
    d.printStackTrace(); // Log the exception
}

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
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
