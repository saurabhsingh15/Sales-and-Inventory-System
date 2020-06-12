package com.customer.controller;

import com.factory.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CustomerPasswordUpdate", urlPatterns = {"/CustomerPasswordUpdate"})
public class CustomerPasswordUpdate extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        HttpSession session=request.getSession();
        
        int id=(Integer)session.getAttribute("id");
        String oldPassword=request.getParameter("currentPassword");
        String newPassword=request.getParameter("newPassword");
        
        Connection con=Factory.getJdbcConnection().getConnection();
        
        try
         {
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("Select * from customerCredential where Cus_Id="+id+" and password='"+oldPassword+"'");
           rs.next();
            {
              String passwordUpdate="update customercredential set password='"+newPassword+"' where Cus_Id="+id;
              Statement st1=con.createStatement();
              int i=st1.executeUpdate(passwordUpdate);
              System.out.println("CUSTOMER PASSWORD UPDATED");
              response.sendRedirect("CustomerHome.html");
              return;
            }
         }
         catch(Exception e)
         {
             System.out.println("QUERY DOES NOT RUN");
             System.out.println(e.getMessage());
         }
    }
}
