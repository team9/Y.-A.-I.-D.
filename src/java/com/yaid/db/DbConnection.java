/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yaid.db;

import com.yaid.user.UserDetailsBean;
import java.sql.*;

/**
 *
 * @author TTT
 */
public class DbConnection {

    private static Connection connection = null;
    private static final String PASS="root";
    private static final String USER="root";
    private static final String DBNAME="yaid";
    

    public static Connection getDbConnection() throws ClassNotFoundException,SQLException {

            if (connection == null) {
                //Connecting to local MySQL data source using MySQL Type-4 Driver
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + DBNAME,
                        USER,PASS );

                System.out.println("Connected to MySQL database successfully.");

            }


        return connection;
    }
    
   public void endDbConnection() throws ClassNotFoundException,SQLException {
       connection.close();
   }
    
   
}
