package com.customer.controller;

import com.customer.bean.CustomerUserPass;
import com.factory.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddCustomer", urlPatterns = {"/AddCustomer"})
public class AddCustomer extends HttpServlet {

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
       
       String houseNo=request.getParameter("house_no");
       String addressLine1=request.getParameter("address_line1");
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
           custUserPass.setEmail(email);
           custUserPass.setPassword(Factory.getGenerate_Password().getUserPass());
           
           
           System.out.println("SUBMIT BUTTON PRESS"+custUserPass.getPassword());
           try
           {
               Factory.getSend_Password().SendMail(custUserPass);
           String insertCustomerCredential="insert into customercredential (first_name,middle_name,last_name,gender,mobile,email,password,date_of_birth) value ('"+firstName+"','"+middleName+"','"+lastName+"','"+gender+"','"+mobile+"','"+email+"','"+custUserPass.getPassword()+"','"+dateOfBirth+"')";
           String insertCustomerInformation="insert into customerinformation (house_no,address_line,village,post,city,state,country,pincode) value('"+houseNo+"','"+addressLine1+"','"+village+"','"+post+"','"+city+"','"+state+"','"+country+"','"+pincode+"')";
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           int i=st.executeUpdate(insertCustomerCredential);
           st.executeUpdate(insertCustomerInformation);
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
