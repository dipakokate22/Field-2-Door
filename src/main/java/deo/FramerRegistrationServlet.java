/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deo;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
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
public class FramerRegistrationServlet extends HttpServlet {

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
            out.println("<title>Servlet FramerRegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FramerRegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
             Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vegetable?useSSL=false","root","root")) {
                 String n = request.getParameter("Full_name");
        String e = request.getParameter("Email");
        String m = request.getParameter("mobile_no");
        String c = request.getParameter("Country");
        String a = request.getParameter("address");
        String pc = request.getParameter("pin_code");
        String u = request.getParameter("UserId");
        String p = request.getParameter("password");
        String cp = request.getParameter("conform_password");
        
        out.println("Full_name"+n);
        out.println("Email"+e);
        out.println("mobile_no"+m);
        out.println("Country"+c);
        out.println("address"+a);
        out.println("pin_code"+pc);
        out.println("UserId"+u);
        out.println("password"+p);
        out.println("conform_password"+cp);
        try(PreparedStatement ps = con.prepareStatement("INSERT into FramerRegistration values(?,?,?,?,?,?,?,?,?)")){
            ps.setString(1, n);
             ps.setString(2, e);
              ps.setString(3, m);
               ps.setString(4, c);
                ps.setString(5, a);
                 ps.setString(6, pc);
                  ps.setString(7, u);
                   ps.setString(8, p);
                    ps.setString(9, cp);
                    int rowsAffected = ps.executeUpdate(); 

    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(null," Framer Registration Successfully");
        RequestDispatcher rd = request.getRequestDispatcher("FramerLogin.jsp");
        rd.forward(request, response);
    } else {
       
        out.println("<font color=red size=5>Registration Failed!!<br>");
        out.println("<a href=FramerRegistration.jsp>Try Again!!</a>");
    }
            
        }
        catch(Exception d){
                             System.out.println(d);
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
            Logger.getLogger(FramerRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FramerRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FramerRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FramerRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
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
