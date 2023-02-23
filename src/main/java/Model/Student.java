/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

/**
 *
 * @author nitro 5
 */
public class Student {

   private int id;
   private String Fullname;
   private String Username;
   private String Password;
   
   public int getId(){
       return id;
   }
   public void setId(int id){
       this.id=id;
   }
   
   public String getFullname(){
       return Fullname;
   }
   public void setFullname(String Fullname){
       this.Fullname=Fullname;
   }
   
   public String getUsername(){
       return Username;
   }
   public void setUsername(String Username){
       this.Username=Username;
   }
   
   public String getPassword(){
       return Password;
   }
   public void setPassword(String Password){
       this.Password=Password;
   }
   
    public static void main(String[] args) {
        Student obj = new Student();
        
    }
    
}
