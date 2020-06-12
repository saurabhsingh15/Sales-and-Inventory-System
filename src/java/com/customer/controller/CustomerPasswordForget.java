package com.customer.controller;

import com.customer.bean.CustomerPasswordForgetOtp;
import com.factory.Factory;
import com.mail.PasswordForget;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.runtime.Debug.id;

@WebServlet(name = "CustomerPasswordForget", urlPatterns = {"/CustomerPasswordForget"})
public class CustomerPasswordForget extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        int otpFetch=0;
        String email=request.getParameter("email");
        String action=request.getParameter("action");
        
        System.out.println(action);
        
        if("Next".equals(action))
         {
           Connection con=Factory.getJdbcConnection().getConnection();
             try
               {
                 Statement st=con.createStatement();
                 ResultSet rs=st.executeQuery("Select * from customerCredential where email='"+email+"'");
                 rs.next();
           
                 CustomerPasswordForgetOtp otp=new CustomerPasswordForgetOtp();
                 otp.setEmail(email);
                 otp.setOtp(Factory.getGenerate_Password().getUserPass());
           
                 Factory.getPasswordForget().SendMail(otp);
           
                 otpFetch=otp.getOtp();
                 System.out.println(otp.getOtp());
           
               }
             catch(Exception e)
               {
             
               }
        }
        else if("back".equals(action))
        {
            
        }
         HttpSession session=request.getSession();
         session.setAttribute("email",email);
         session.setAttribute("otp",otpFetch);
         response.sendRedirect("CustomerOtp.jsp");
             
    }
}
