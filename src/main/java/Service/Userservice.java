
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
import java.util.ArrayList;
import java.util.List;

public class Userservice {
    
    public void insertUser(Student student){
        String query = "insert into user(username, fullname, password)"+ "values(?,?,?)";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        
        try{
            preparedStatement.setString(1,student.getUsername());
            preparedStatement.setString(2,student.getFullname());
            preparedStatement.setString(3,student.getPassword());
            preparedStatement.execute();
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
//    public void editUser(int id, Student obj){
//        String query = "update userinfo set username=?, fullname=?"+"where id=?";
//        PreparedStatement preparedstatement = new DBConnection().getStatement(query);
//        try{
//        preparedstatement.setString(1, obj.getUsername());
//        preparedstatement.setString(2, obj.getFullname());
//        preparedstatement.setString(3,obj.getPassword());
//        preparedstatement.execute();
//        
//        
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
    
      public Student getUser(String username, String password){
        Student student = null;
        
        String query = "select * from user where username=? and password=?";
        PreparedStatement preparedstatement = new DBConnection().getStatement(query);
        
        
        try{
            preparedstatement.setString(1, username);
            preparedstatement.setString(2, password);
            
            ResultSet resultset = preparedstatement.executeQuery();
            
            while(resultset.next()){
                student = new Student();
                student.setId(resultset.getInt("id"));
                student.setUsername(resultset.getString("username"));
                student.setFullname(resultset.getString("fullname"));
                student.setPassword(resultset.getString("password"));
                
                
            } 
            }catch(SQLException e){
                    e.printStackTrace();
                    }
            return student;
        }
      
      public List<Student> getUserList() {
        List<Student> userList = new ArrayList<>();
        String query = "select * from user";
        System.out.println(query);
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setFullname(rs.getString("fullname"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));


                userList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
      
      public Student getUserRow(int id){
        Student student = new Student();
        String query = "select * from user where id=?";
        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                student.setId(rs.getInt("id"));
                student.setFullname(rs.getString("fullname"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
//                user.setRole(rs.getString("role"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return student;
    }
   public void editUser(int id, Student student) throws SQLException {

        String query = "update user set fullname=?,userName=?,password=?," +
                "role=? where id=?";
        
        PreparedStatement pstm = new DBConnection().getStatement(query);
        pstm.setString(1, student.getFullname());
        pstm.setString(2, student.getUsername());
        pstm.setString(3, student.getPassword());
//        pstm.setString(4, student.getRole());
        pstm.setInt(4, id);

        pstm.execute();
    
   
}
}
    

