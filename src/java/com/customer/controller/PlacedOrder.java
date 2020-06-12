package com.customer.controller;

import com.factory.Factory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PlacedOrder", urlPatterns = {"/PlacedOrder"})
public class PlacedOrder extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String action=request.getParameter("action");
        
     if(action.equals("placedorder"))
      {
        
        HttpSession session=request.getSession();
        int orderId=0;
        
        ArrayList<String> productName=new ArrayList();
        ArrayList<Integer> quantity=new ArrayList();
        ArrayList<Integer> rate=new ArrayList();
        ArrayList<Integer> amount=new ArrayList();
        
        int customerId=(Integer)(session.getAttribute("id"));  // session.getAttribute("customerId");
         
        //
        
         try
           {
           String query1="insert into placedorder(customer_Id,status,delivery_Id) value("+customerId+",'pending',0)";
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           int i=st.executeUpdate(query1);
           System.out.println("PLACED ORDER CREDENTIAL INSERTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
         
        
         
         //
          try
           {
           String query2="select order_Id from placedorder where status='pending' and customer_Id="+customerId+" order By order_Id desc limit 1";
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery(query2);
           rs.next();
           orderId=rs.getInt(1);
           System.out.println(orderId+"ORDERID CREDENTIAL FETCHED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
          
           //
         
          try
           {
           String query1="insert into productprocessing value("+orderId+",'pending',now())";
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           int i=st.executeUpdate(query1);
           System.out.println("PLACED ORDER CREDENTIAL INSERTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
         
          
          //
          try
           {
           String query3="select * from cart where cust_Id="+customerId;
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery(query3);
           while(rs.next())
           {
               productName.add(rs.getString(2));
               quantity.add(rs.getInt(3));
               rate.add(rs.getInt(4));
               amount.add(rs.getInt(5));
           }
           System.out.println("DATA FETCHED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
         
         
         try
           {
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           Iterator i1=productName.iterator();
           Iterator i2=quantity.iterator();
           Iterator i3=rate.iterator();
           Iterator i4=amount.iterator();
           while(i1.hasNext())
           {
           st.executeUpdate("insert into orders(order_Id,product_name,product_quantity,product_rate,amount) value("+orderId+",'"+i1.next()+"',"+i2.next()+","+i3.next()+","+i4.next()+")");
           }
           System.out.println("PLACED ORDER CREDENTIAL INSERTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
         
           //
           try
           {
           String query4="delete from cart where cust_Id="+customerId;
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           st.executeUpdate(query4);
           System.out.println("DELETE ORDER FROM THE CART TABLE");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
      }
     else
     {
         System.out.println("BACK BUTTON IS PRESSED");
     }
    }
}

