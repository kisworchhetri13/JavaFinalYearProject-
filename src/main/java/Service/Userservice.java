/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Student;
import databaseconnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Userservice {
    
    public void insertUser(Student obj){
        String query = "insert into user(username, fullname, password)"+ "values(?,?,?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        
        try{
            preparedStatement.setString(1,obj.getUsername());
            preparedStatement.setString(2, obj.getFullname());
            preparedStatement.setString(3,obj.getPassword());
            
        }catch(SQLException e){
            e.printStackTrace();
            
        }
    }
    
  
    // delete user
    public void deleteUser(int id){
        String query = "delete from user where id=?";
        PreparedStatement preparedstatement = new DBConnection().getStatement(query);
        
        try{
            preparedstatement.setInt(1, id);
            preparedstatement.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    //Edit user
    public void editUser(int id, Student obj){
        String query = "update userinfo set username=?, fullname=?"+"where id=?";
        PreparedStatement preparedstatement = new DBConnection().getStatement(query);
        try{
        preparedstatement.setString(1, obj.getUsername());
        preparedstatement.setString(2, obj.getFullname());
        preparedstatement.setString(3,obj.getPassword());
        
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
      public Student getUser(String username, String password){
        Student obj = null;
        
        String query = "select * from user where username=? and password=?";
        PreparedStatement preparedstatement = new DBConnection().getStatement(query);
        
        
        try{
            preparedstatement.setString(1, username);
            preparedstatement.setString(2, password);
            
            ResultSet resultset = preparedstatement.executeQuery();
            
            while(resultset.next()){
                obj = new Student();
                obj.setId(resultset.getInt("id"));
                obj.setUsername(resultset.getString("username"));
                obj.setFullname(resultset.getString("fullname"));
                obj.setPassword(resultset.getString("password"));
                
            } 
            }catch(SQLException e){
                    e.printStackTrace();
                    }
            return obj;
        }
}
    

