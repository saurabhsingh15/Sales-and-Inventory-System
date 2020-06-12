package com.customer.controller;

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

@WebServlet(name = "CartCalculator", urlPatterns = {"/CartCalculator"})
public class CartCalculator extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        
        HttpSession session=request.getSession();
        
         int productId=Integer.parseInt(request.getParameter("product_Id"));
         System.out.println(productId);
         int quantity=1;                                     //Integer.parseInt(request.getParameter("quantity"));
         int customerId=(int) session.getAttribute("id");
         
         System.out.println("Customer Id is : "+customerId+" , Quantity : "+quantity+" , Product Id : "+productId);
         
        
         //  session.setAttribute("productId",productId);
         String pName="";
         int pQuantity=0;
         int pRate=0;
         int pAmount=0;
         int leftQuantity;
         
        try
          {
           String insertEmployeeCredential="select * from product where product_Id="+productId+"";
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery(insertEmployeeCredential);
            while(rs.next())
             {
               pName=rs.getString(2);
               pQuantity=rs.getInt(6);
               pRate=rs.getInt(5);
             }
            System.out.println("CREDENTIAL SELECTED");
          }
        catch(Exception e)
          {
               System.out.println(e.getMessage());
          }
         
          leftQuantity=pQuantity-quantity;
          
          System.out.println(leftQuantity+" LEFT QUANTITY ");
          
    if(leftQuantity>=0)
     {
       pAmount=quantity*pRate; 
        
       // INSERT INTO THE CART TABLE 
       
        try
         {
           String query2="insert into cart (cust_Id,product_name,product_quantity,product_rate,amount) value("+customerId+",'"+pName+"',"+quantity+","+pRate+","+pAmount+")";
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           int i=st.executeUpdate(query2);
           System.out.println("CREDENTIAL INSERTTED");
         }
        catch(Exception e)
           {
               System.out.println("THESE PRODUCT IS NOT IN THE STOCK");
               System.out.println(e.getMessage());
           }
       
        // UPDATE STOCK OF STOCK TABLE
         try
           {
           String query3="update product set current_stock="+leftQuantity+" where product_Id="+productId;
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           int i=st.executeUpdate(query3);
           System.out.println("CREDENTIAL UPDATED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
         }
         response.sendRedirect("Customer_Menu.jsp");
               
    }

                
        
                
        
        
    
 }
