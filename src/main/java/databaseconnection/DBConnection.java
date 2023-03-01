/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author nitro 5
 */
public class DBConnection {
    
    Connection connection = null;
    

    public DBConnection(){
        try{
            
        
      Class.forName("com.mysql.jdbc.Driver");
      String dburl = "jdbc:mysql://localhost:3306/finalproject";
      String dbname="root";
      String dbpassword="";
      
      connection = DriverManager.getConnection(dburl,dbname,dbpassword);
            System.out.println("DB CONNECTED");
        
    }catch(ClassNotFoundException e){
        e.printStackTrace();
    }catch (SQLException e){
        e.printStackTrace();
    }
    }
    public static void main(String[] args) throws SQLException {
       DBConnection OBJ = new DBConnection();
    }
    public PreparedStatement getStatement (String query){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement= connection.prepareStatement(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;
    }

    
}
