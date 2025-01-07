/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Registration;

/**
 *
 * @author HP
 */
public class UserDao {
    private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public Registration userLogin(String name, String password) {
		Registration user = null;
        try {
            query = "select * from registration where UserId=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new Registration();
            user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
}
