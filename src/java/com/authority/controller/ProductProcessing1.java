package com.authority.controller;

import com.factory.Factory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProductProcessing1", urlPatterns = {"/ProductProcessing1"})
public class ProductProcessing1 extends HttpServlet 
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  
    {
        HttpSession session=request.getSession();
        ArrayList OrderIdlist=(ArrayList)session.getAttribute("orderId");
        int OrderId=(Integer)OrderIdlist.get(0);
        System.out.println("ORDER ID FROM JSP FILE : "+OrderId);
        
        String action=request.getParameter("action");
        
        Connection con=Factory.getJdbcConnection().getConnection();
        
        if(action.equals("packed"))
        {        
            try
            {
            Statement st=con.createStatement();   
            int i1=st.executeUpdate("insert into productprocessing value("+OrderId+",'PACKED',now())");
            System.out.println(i1+"rows affected ");
            System.out.println("PRODUCT PROCESSING IS UPDATED");
            }
            catch(Exception e)
            {
                System.out.println("PRODUCT PROCESSING IS NOT UPDATED");
            }
            
             try
            {
            Statement st=con.createStatement();   
            int i2=st.executeUpdate("update placedorder set status='PACKED' where order_Id="+OrderId);
            System.out.println(i2+"rows affected ");
            System.out.println("PLACEDORDER TABLE IS UPDATED");
            response.sendRedirect("ProductProcessing1.jsp");
            }
            catch(Exception e)
            {
                System.out.println("PLACEDORDER TABLE IS NOT UPDATED");
            }
        }
        else if(action.equals("receive"))
         {
           try
            {
            Statement st=con.createStatement();   
            int i1=st.executeUpdate("insert into productprocessing value("+OrderId+",'RECEIVE',now())");
            System.out.println(i1+"rows affected ");
            System.out.println("PRODUCT PROCESSING IS UPDATED");
            }
            catch(Exception e)
            {
                System.out.println("PRODUCT PROCESSING IS NOT UPDATED");
            }
            
           try
            {
            Statement st=con.createStatement();   
            int i2=st.executeUpdate("update placedorder set status='RECEIVE' where order_Id="+OrderId);
            System.out.println(i2+"rows affected ");
            System.out.println("PLACEDORDER TABLE IS UPDATED");
            response.sendRedirect("ProductProcessing1.jsp");
            }
            catch(Exception e)
            {
                System.out.println("PLACEDORDER TABLE IS NOT UPDATED");
            }     
         }
    }
}
