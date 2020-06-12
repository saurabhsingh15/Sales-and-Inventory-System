package com.authority.controller;

import com.factory.Factory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AUpdatePrice", urlPatterns = {"/AUpdatePrice"})
public class AUpdatePrice extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
       {
           String action = request.getParameter("action");
           
           String productId = request.getParameter("productId");
           String newPrice = request.getParameter("price");
           
           System.out.println("ACTION : "+action+" , PRODUCT ID : "+productId+" , NEW PRICE : "+newPrice);
           
           // 
           
           Connection con=Factory.getJdbcConnection().getConnection();
           try
             {
               String query="update product set selling_price="+newPrice+" where product_Id="+productId;  
               Statement st=con.createStatement();
               int i=st.executeUpdate(query);
               System.out.println(i+" ROW UPDATED ");
               System.out.println("PRICE UPDATED OF PRODUCT ID : "+productId);
               response.sendRedirect("AuthorityPriceUpdate.jsp");
             } 
           catch(Exception e)
             {
                System.out.println("ERROR !!!");
                System.out.println(e.getMessage());
             }
       }
}

