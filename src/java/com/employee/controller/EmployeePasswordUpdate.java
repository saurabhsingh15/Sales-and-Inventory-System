package com.employee.controller;

import com.customer.controller.*;
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

@WebServlet(name = "EmployeePasswordUpdate", urlPatterns = {"/EmployeePasswordUpdate"})
public class EmployeePasswordUpdate extends HttpServlet {

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
           ResultSet rs=st.executeQuery("Select * from employeeCredential where Emp_Id="+id+" and password='"+oldPassword+"'");
           rs.next();
            {
              String passwordUpdate="update employeecredential set password='"+newPassword+"' where Emp_Id="+id;
              Statement st1=con.createStatement();
              int i=st1.executeUpdate(passwordUpdate);
              System.out.println("EMPLOYEE PASSWORD UPDATED");
              return;
            }
         }
         catch(Exception e)
         {
              System.out.println("EMPLOYEE PASSWORD NOT UPDATED");
         }
    }
}
