/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */

public class Dbcom {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connection == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/vegetable?useSSL=false","root","root");
            System.out.print("connected");
        }
        return connection;
    }
}

