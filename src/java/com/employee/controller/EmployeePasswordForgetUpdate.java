package com.employee.controller;

import com.customer.controller.*;
import com.factory.Factory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EmployeePasswordForgetUpdate", urlPatterns = {"/EmployeePasswordForgetUpdate"})
public class EmployeePasswordForgetUpdate extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
          HttpSession session=request.getSession();  
          System.out.println("ID IS : "+session.getAttribute("id")+" , EMAIL IS : "+session.getAttribute("email"));
          
          String newPassword=request.getParameter("newPassword");
          String confirmPassword=request.getParameter("confirmPassword");
          String action=request.getParameter("action");
          
          System.out.println(newPassword+" "+confirmPassword+" "+action);
          
       if("SUBMIT".equals(action))
       {
          if(newPassword.equals(confirmPassword))
          {
              try
              {
              String query="update Employeecredential set password='"+newPassword+"' where email='"+session.getAttribute("email")+"'";
              Connection con=Factory.getJdbcConnection().getConnection();
              Statement st=con.createStatement();
              int i=st.executeUpdate(query);
              System.out.println(i+" Row Affected");
              
              //
               
               response.sendRedirect("AdminLoginPage.html");
              }
              catch(Exception e)
              {
                  System.out.println("QUERY NOT RUN");
              }
          }
          else
          {
              System.out.println("PASSWORD AND CONFIRM PASSWORD IS NOT MATCHED");
          }
       }  
    }    
}
