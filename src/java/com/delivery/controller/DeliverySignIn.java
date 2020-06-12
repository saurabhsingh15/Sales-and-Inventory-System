package com.delivery.controller;

import com.customer.controller.*;
import com.authority.controller.*;
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

@WebServlet(name = "DeliverySignIn", urlPatterns = {"/DeliverySignIn"})
public class DeliverySignIn extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
       int flag=0;
       String email=request.getParameter("username");
       String password=request.getParameter("password");
       
       //System.out.println(email+" "+password);
      
       HttpSession session=request.getSession();
       
       // JDBC WORKING
         Connection con=Factory.getJdbcConnection().getConnection();
         try
         {
         Statement st=con.createStatement();
         ResultSet rs=st.executeQuery("Select * from deliveryCredential");
         while(rs.next())
         {
             
            // System.out.println(rs.getString(7)+" "+rs.getString(8));
             
             if(email.equals(rs.getString(7)) && password.equals(rs.getString(8)))
             {
                 flag=1;
                 response.sendRedirect("DeliveryHome.html");
                 session.setAttribute("email",email);
                 session.setAttribute("id",rs.getInt(1));
                 return;
             }
         }
         }
         catch(Exception e)
         {
             
         }
         if(flag==0)
         {
             response.sendRedirect("DeliveryLoginPage.html");
         }
         
    }
}