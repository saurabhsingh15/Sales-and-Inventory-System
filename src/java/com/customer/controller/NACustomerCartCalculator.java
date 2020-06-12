package com.customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CustomerCartCalculator", urlPatterns = {"/CustomerCartCalculator"})
public class NACustomerCartCalculator extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
       String productId=request.getParameter("product_Id");
       
       System.out.println("PRODUCT ID IS : "+productId);
       
    }
}
