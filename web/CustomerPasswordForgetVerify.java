package com.customer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CustomerPasswordForgetVerify", urlPatterns = {"/CustomerPasswordForgetVerify"})
public class CustomerPasswordForgetVerify extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        HttpSession session=request.getSession();
        String otp=(String.valueOf(session.getAttribute("otp")));
        
        
       System.out.println("OTP IS PASSED BY MAIL : "+otp+" , OTP PASSED BY USER : "+request.getParameter("otptext"));
         
        if(otp.equals(request.getParameter("otptext")))
        {
            response.sendRedirect("CustomerPasswordForget2.html");
        }
        
    }
}
