/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;
//import javax.servlet.http.Part;

/**
 *
 * @author HP
 */
@MultipartConfig
public class AddProductServlet1 extends HttpServlet {

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
            out.println("<title>Servlet AddProductServlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProductServlet1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vegetable?useSSL=false","root","root")) {
                 
        String n = request.getParameter("Name");
        String d = request.getParameter("detail");
        String c = request.getParameter("category");
        String p = request.getParameter("price");
        String q = request.getParameter("Quantity");
        String dis = request.getParameter("discount");
        Part filePart = request.getPart("image");
            InputStream imageInputStream = filePart.getInputStream();
        
        // String i = request.getParameter("image");
        // Part filePart = request.getPart("image");
   // InputStream imageStream = filePart.getInputStream();
      //  String i = request.getParameter("image");
        // Part part = request.getPart("image");
        
        out.println("Name"+n);
        out.println("detail"+d);
        out.println("category"+c);
        out.println("price"+p);
        out.println("Quantity"+q);
        out.println("discount "+dis );
       //out.println("image"+i);
       //out.println("image"+i);
       
        try(PreparedStatement ps = con.prepareStatement("INSERT into Products(Name,detail,category,price, Quantity,discount,image) values(?,?,?,?,?,?,?)")){
             ps.setString(1, n);
             ps.setString(2, d);
             ps.setString(3, c);
             ps.setString(4, p);
             ps.setString(5, q);
             ps.setString(6, dis);
            //  ps.setString(7, i);
             ps.setBlob(7, imageInputStream);
              // ps.setBlob(7, imageStream);
             //ps.setString(7, i);
              
                    int rowsAffected = ps.executeUpdate(); 

    if (rowsAffected > 0) {
      //  JOptionPane.showMessageDialog(null,"Medicine Updated Successfully");
       // out.printf("Successfully Add product");
        RequestDispatcher rd = request.getRequestDispatcher("/FramerLogin.jsp");
        rd.forward(request, response);
    } else {
       JOptionPane.showMessageDialog(null," Product Add Successfully");
        out.println("<font color=red size=5>AddProduct Failed!!<br>");
        out.println("<a href=AddProduct.jsp>Try Again!!</a>");
    }
            
        }
        catch(Exception f){
                             System.out.println(f);
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
            Logger.getLogger(AddProductServlet1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddProductServlet1.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddProductServlet1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddProductServlet1.class.getName()).log(Level.SEVERE, null, ex);
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
