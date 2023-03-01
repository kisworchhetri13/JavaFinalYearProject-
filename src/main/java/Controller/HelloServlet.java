/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import java.io.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import databaseconnection.DBConnection;
import Model.Student;
import Service.Userservice;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/user")
public class HelloServlet extends HttpServlet {
    private String message;

//    public void init() {
//        message = "Hello World!";
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();


        String action = request.getParameter("page");
        if (action.equalsIgnoreCase("login") ){

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            System.out.println(username + " " + password + " ");

            Student student = new Userservice().getUser(username, password);
//            System.out.println(user.getUsername()+" "+user.getPassword());
            if (student != null) {
                HttpSession session = request.getSession();
                session.setAttribute("id", student.getId());
                session.setAttribute("fullname", student.getFullname());
                session.setAttribute("username", username);
                //                    System.out.println(session.getAttribute("user"));
                request.setAttribute("msg", "Login Successful!");
                System.out.println(request.getAttribute("msg"));

                RequestDispatcher rd = request.getRequestDispatcher("Pages/dashboard.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }

        }

        //To redirect in Register Page
        if (action.equalsIgnoreCase("newUsers"))

        {
            RequestDispatcher rd = request.getRequestDispatcher("Pages/register.jsp");
            rd.forward(request, response);
        }

//        To register a new acount
        if (action.equalsIgnoreCase("register"))

        {
            Student student = new Student();
//            out.println(request.getParameter("username"));
            student.setUsername(request.getParameter("username"));
            student.setFullname(request.getParameter("fullname"));
            student.setPassword(request.getParameter("password"));

            new Userservice().insertUser(student);

            System.out.println("Data Inserted");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            try {

            
                rd.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        }

        // send to index page
        if (action.equalsIgnoreCase("index"))

        {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        if (action.equalsIgnoreCase("listuser") ){

            Student student = new Student();
            List<Student> studentList = new Userservice().getUserList();

            request.setAttribute("student", student);
            request.setAttribute("studentlist", studentList);
            RequestDispatcher rd = request.getRequestDispatcher("Pages/list_user.jsp");
            rd.forward(request, response);


            }
        
         if (action.equalsIgnoreCase("userDetails"))
        {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = new Userservice().getUserRow(id);
            request.setAttribute("id", id);
            request.setAttribute("student", student);  //Why this

            RequestDispatcher rd = request.getRequestDispatcher("Pages/user_details.jsp");
            rd.forward(request, response);
        }

        
        if (action.equalsIgnoreCase("deleteUser"))

        {
            int id = Integer.parseInt(request.getParameter("id"));
            Userservice userService = new Userservice();
            userService.deleteUser(id);
            List<Student> userList = new Userservice().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("Pages/list_user.jsp");
            rd.forward(request, response);
        }

        if (action.equalsIgnoreCase("userEdit"))

        {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            Student student = new Userservice().getUserRow(id);
            request.setAttribute("id", id);
            request.setAttribute("user", student);
            RequestDispatcher rd = request.getRequestDispatcher("Pages/update_user.jsp");
            rd.forward(request, response);
        }
//
        if (action.equalsIgnoreCase("editUser"))

        {
            Student student= new Student();
            int id = Integer.parseInt(request.getParameter("id"));
            student.setFullname(request.getParameter("fullname"));
            student.setUsername(request.getParameter("username"));
            student.setPassword(request.getParameter("password"));
//            student.setRole(request.getParameter("role"));
          try{
           new Userservice().editUser(id, student);
          }catch(SQLException e){
              e.printStackTrace();
          }
            List<Student> userList = new Userservice().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("Pages/list_user.jsp");
            rd.forward(request, response);
        }
        
    


    }

    public void destroy() {
    }
}