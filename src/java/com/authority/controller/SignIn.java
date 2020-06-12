package com.authority.controller;

import com.factory.Factory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SignIn", urlPatterns = {"/SignIn"})
public class SignIn extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
       int flag=0;
       String email=request.getParameter("username");
       String password=request.getParameter("password");
       
       
       HttpSession session=request.getSession();
       
       // JDBC WORKING
         Connection con=Factory.getJdbcConnection().getConnection();
//         try
//         {
//         Statement st=con.createStatement();
//         ResultSet rs=st.executeQuery("Select * from authorityCredential");
//         while(rs.next())
//         {
//             if(email.equals(rs.getString(2)) && password.equals(rs.getString(4)))
//             {
//                 flag=1;
//                 response.sendRedirect("AuthorityHome.html");
//                 session.setAttribute(email,"email");
//                 return;
//             }
//         }
//         }
//         catch(Exception e)
//         {
//             
//         }
//         if(flag==0)
//         {
//             response.sendRedirect("FrontPage.html");
//         }
         
 try
         {
         Statement st=con.createStatement();
         ResultSet rs=st.executeQuery("Select * from authorityCredential where name='"+email+"' and password='"+password+"'");
        // System.out.println(rs.next());
         if(rs.next())
         {
             System.out.println("AUTHORITY BLOCK");
                 response.sendRedirect("AuthorityHome.html");
                 session.setAttribute(email,"email");
                 session.setAttribute("id",rs.getInt(1));
                 return;
         }
         else
         {
             System.out.println("EMPLOYEE BLOCK");
         ResultSet rs1=st.executeQuery("Select * from employeeCredential where email='"+email+"' and password='"+password+"'");
         rs1.next();
       
                 response.sendRedirect("EmployeeHome.html");
                 session.setAttribute("email",email);
                 session.setAttribute("id",rs1.getInt(1));
                 System.out.println(rs1.getInt(1));
                 return;
         }
         }
         catch(Exception e)
         {
             response.sendRedirect("AdminLoginPage.html");
         }


    }
}

