/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Student;
import Service.Userservice;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nitro 5
 */
@WebServlet(name = "user", urlPatterns = {"/user"})
public class user extends HttpServlet {
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        response.setContentType("html/text");
        PrintWriter out = response.getWriter();
        
        String action = request.getParameter("page");
        
        
//        if(action.equalsIgnoreCase("register")){
//            
//         
//            RequestDispatcher rd = request.getRequestDispatcher("Pages/register.jsp");
//            rd.forward(request, response);
////response.sendRedirect("register.jsp");
//        }
//        else if(action.equalsIgnoreCase("login")){
//            
//              Student student = new Student();
//            
//            
//            student.setUsername(request.getParameter("username"));
//            student.setFullname(request.getParameter("fullName"));
//            student.setPassword(request.getParameter("password"));
//
//            new Userservice().insertUser(student);
//
//            System.out.printf("Data Inserted");
//
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            try {
//                rd.forward(request, response);
//            } catch (ServletException e) {
//                throw new RuntimeException(e);
//            }
//            
            
//               RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
//        }
        
        //To redirect in Register Page
//        if (action.equalsIgnoreCase("newUsers"))
//
//        {
//            RequestDispatcher rd = request.getRequestDispatcher("Pages/register.jsp");
//            rd.forward(request, response);
//        }
//
//        if (action.equalsIgnoreCase("userDetails")) {
//
//            int id = Integer.parseInt(request.getParameter("id"));
////            Student student = new Userservice().getUserRow(id);
//            request.setAttribute("id", id);
//            request.setAttribute("user", user);
//            RequestDispatcher rd = request.getRequestDispatcher("Pages/user_details.jsp");
//            rd.forward(request, response);
//        }

        
        if(action.equalsIgnoreCase("register")){
            Student student = new Student();
            System.out.println(request.getParameter("fullname"));
            student.setFullname(request.getParameter("fullname"));
            student.setUsername(request.getParameter("username"));
            student.setPassword((request.getParameter("password")));
//            student.setRole(request.getParameter("role"));
            new Userservice().insertUser(student);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }

        if (action.equalsIgnoreCase("index"))

        {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }


        if (action.equalsIgnoreCase("login"))

        {
            String username = request.getParameter("username");
            String password = (request.getParameter("password"));
            System.out.println(username + " " + password + " ");

            Student student = new Userservice().getUser(username, password);
//            System.out.println(user.getUsername()+" "+user.getPassword());
            if (student != null) {
                HttpSession session = request.getSession();
                session.setAttribute("uid", student.getId());
                session.setAttribute("full_name", student.getFullname());
                session.setAttribute("user", student);
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


}
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         doPost(request,response);
     }
}