/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author HP
 */
public class ProductDao {
    
   private Connection con;
   
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    public ProductDao(Connection con){
        super();
    this.con = con;
    }
    
   public List<Product> getAllProducts(){
    ArrayList<Product> Products= new ArrayList<Product>();
    try{
        query = "select * from Products";
    pst = this.con.prepareStatement(query);
    rs = pst.executeQuery();
    while(rs.next()){
    Product row = new Product();
    row.setId(rs.getInt("id"));
    row.setName(rs.getString("Name"));
    row.setDetail(rs.getString("detail"));
    row.setCategory(rs.getString("category"));
    row.setPrice(rs.getDouble("price"));
    row.setQuantity(rs.getString("Quantity"));
    row.setDiscount(rs.getString("discount"));
    row.setImage(rs.getString("image"));
    
    
    Products.add(row);
    }
    
    }
    catch(Exception e){
        e.printStackTrace();
    }
       return Products;
    
       
    }
    public Product getSingleProduct(int id) {
		 Product row = null;
	        try {
	            query = "select * from products where id=? ";

	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new Product();
	                row.setId(rs.getInt("id"));
	                row.setName(rs.getString("name"));
	                row.setCategory(rs.getString("category"));
	                row.setPrice(rs.getDouble("price"));
	                row.setImage(rs.getString("image"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
    
    
    
   public List<Cart> getCartProducts(ArrayList<Cart> cartList)
   {
        List<Cart> products = new ArrayList<Cart>();   
        try{
        if(cartList.size()>0){
            for(Cart item : cartList){
            
            query ="select * from products where id=?";
            pst = this.con.prepareStatement(query);
      pst.setInt(1, item.getId());
      rs = pst.executeQuery();
      while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setName(rs.getString("name"));
                        row.setCategory(rs.getString("category"));
                        row.setPrice(rs.getDouble("price")*item.getquantity());
                        row.setquantity(item.getquantity());
                        products.add(row);
                       
                    }
            }
        
        
        }
        }
        catch(Exception e){
        System.out.println(e.getMessage());
        e.printStackTrace();
        }
       return products;
    
    }
   
   
   public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    query = "select price from products where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("price")*item.getquantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
}

    
}
