package com.employee.controller;

import com.customer.bean.CustomerUserPass;
import com.factory.Factory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddEmployee", urlPatterns = {"/AddEmployee"})
public class AddEmployee extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
       String action = request.getParameter("action");
       
       //
       
       String firstName = request.getParameter("firstname");
       String middleName=request.getParameter("middlename");
       String lastName=request.getParameter("lastname");
       String gender=request.getParameter("gender");
       String mobile=request.getParameter("mobile");
       String email=request.getParameter("email");
       String dateOfBirth=request.getParameter("dateofbirth");
       System.out.println(dateOfBirth);
       
       //
       
       String houseNo=request.getParameter("houseno");
       String addressLine1=request.getParameter("addressline1");
       String village=request.getParameter("village");
       String post=request.getParameter("post");
       String city=request.getParameter("city");
       String state=request.getParameter("state");
       String country=request.getParameter("country");
       String pincode=request.getParameter("pincode");
       
        CustomerUserPass custUserPass=new CustomerUserPass();
       
        
       if("verifyOTP".equals(action))
       {
           System.out.println(request.getParameter("firstname"));
           System.out.println("OTP BUTTON PRESS");
       }
       else if("submit".equals(action))
       {
           System.out.println("SUBMIT BUTTON PRESS");
           custUserPass.setEmail(email);
           custUserPass.setPassword(Factory.getGenerate_Password().getUserPass());
           
           
           System.out.println("SUBMIT BUTTON PRESS"+custUserPass.getPassword());
           try
           {
               Factory.getSend_Password().SendMail(custUserPass);
           String insertEmployeeCredential="insert into employeecredential (first_name,middle_name,last_name,gender,mobile,email,password) value ('"+firstName+"','"+middleName+"','"+lastName+"','"+gender+"','"+mobile+"','"+email+"','"+custUserPass.getPassword()+"')";
           String insertEmployeeInformation="insert into employeeinformation (house_no,address_line,village,post,city,state,country,pincode) value('"+houseNo+"','"+addressLine1+"','"+village+"','"+post+"','"+city+"','"+state+"','"+country+"','"+pincode+"')";
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           int i=st.executeUpdate(insertEmployeeCredential);
           st.executeUpdate(insertEmployeeInformation);
           System.out.println("CREDENTIAL INSERTTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
           
           
       }
       else if("back".equals(action))
       {
           System.out.println(" BACK BUTTON PRESS");
       }
       else
       {
           
       }
    }
}
