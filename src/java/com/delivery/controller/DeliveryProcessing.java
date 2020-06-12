package com.delivery.controller;

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

@WebServlet(name = "DeliveryProcessing", urlPatterns = {"/DeliveryProcessing"})
public class DeliveryProcessing extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        
        HttpSession session=request.getSession();
       
        ArrayList id=(ArrayList)session.getAttribute("orderid");
        
        int deliveryId=(Integer)session.getAttribute("id");
        int orderId=(Integer)id.get(0);
        
        String action=request.getParameter("action");
        
        System.out.println("DELIVERY ID : "+deliveryId+" ORDER ID : "+orderId+" ACTION IS : "+action);
        
        Connection con=Factory.getJdbcConnection().getConnection();
        
        try
        {
            Statement st=con.createStatement();
            
        if("accept".equals(action))
        {
            int i1=st.executeUpdate("insert into productprocessing value("+orderId+",'DELIVERY ACCEPTED',now())");
            System.out.println(i1+"rows affected ");
            System.out.println("PRODUCT PROCESSING IS INSERTED");
                       
            int i2=st.executeUpdate("update placedorder set status='DELIVERY ACCEPTED' where order_Id="+orderId);
            st.executeUpdate("update placedorder set delivery_Id="+deliveryId+" where order_Id="+orderId);
            System.out.println(i2+"rows affected ");
            System.out.println("PLACEDORDER TABLE IS UPDATED");  
            
            //  AGAIN REDIRECT TO SAME WITH REFRESH DATA
            response.sendRedirect("DeliveryProcessing.jsp");
        }
        else if(action.equals("picked"))
         {
            int i1=st.executeUpdate("insert into productprocessing value("+orderId+",' DELIVERY PICKED',now())");
            System.out.println(i1+"rows affected ");
            System.out.println("PRODUCT PROCESSING IS INSERTED");
           
            
            
            int i2=st.executeUpdate("update placedorder set status='DELIVERY PICKED' where order_Id="+orderId);
            System.out.println(i2+"rows affected ");
            System.out.println("PLACEDORDER TABLE IS UPDATED");  
            
            //  AGAIN REDIRECT TO SAME WITH REFRESH DATA
            response.sendRedirect("DeliveryProcessing.jsp");
         }
        else if(action.equals("ontheway"))
         {
            int i1=st.executeUpdate("insert into productprocessing value("+orderId+",'ON THE WAY',now())");
            System.out.println(i1+"rows affected ");
            System.out.println("PRODUCT PROCESSING IS INSERTED");
       
            int i2=st.executeUpdate("update placedorder set status='ON THE WAY' where order_Id="+orderId);
            System.out.println(i2+"rows affected ");
            System.out.println("PLACEDORDER TABLE IS UPDATED");
            
            //  AGAIN REDIRECT TO SAME WITH REFRESH DATA
            response.sendRedirect("DeliveryProcessing.jsp");
         }
        else if(action.equals("delivered"))    
          {
            int i1=st.executeUpdate("insert into productprocessing value("+orderId+",'DELIVERED',now())");
            System.out.println(i1+"rows affected ");
            System.out.println("PRODUCT PROCESSING IS INSERTED");
           
            int i2=st.executeUpdate("update placedorder set status='DELIVERED' where order_Id="+orderId);
            System.out.println(i2+"rows affected ");
            System.out.println("PLACEDORDER TABLE IS UPDATED"); 
            
            //  AGAIN REDIRECT TO SAME WITH REFRESH DATA
            response.sendRedirect("DeliveryProcessing.jsp");
          }
        else
          {
             System.out.println("DELIVERY PORTAL IS NOT WORKING !!!");
          }
        }
        catch(Exception e)
        {
            System.out.println("BUTTON IS NOT WORKING !!!");
            System.out.println(e.getMessage());
        }
    }
}