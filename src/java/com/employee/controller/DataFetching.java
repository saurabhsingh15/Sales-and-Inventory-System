package com.employee.controller;

import com.factory.Factory;
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

@WebServlet(name = "DataFetching", urlPatterns = {"/DataFetching"})
public class DataFetching extends HttpServlet {

   //  CORRECT FOR PRODUCT ADDITION
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        HttpSession session=request.getSession();
        
         int productId=Integer.parseInt(request.getParameter("search"));
         int quantity=Integer.parseInt(request.getParameter("quantity"));
         int employeeId=(Integer)session.getAttribute("id");
         String action=request.getParameter("action");
         
         System.out.println("product"+productId+" "+quantity+" EMPLOYEE ID : "+employeeId);
         
        //  session.setAttribute("productId",productId);
         String pName="";
         int pQuantity=0;
         int pRate=0;
         int pAmount=0;
         int leftQuantity;
         
        // WORKING OF THE ADDTOCART BUTTON 
        if(action.equals("addtocart"))
         {
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
           System.out.println("CREDENTIAL INSERTTED");
          }
        catch(Exception e)
          {
               System.out.println(e.getMessage());
          }
         
          leftQuantity=pQuantity-quantity;
          
           if(leftQuantity>=0)
            {
               pAmount=quantity*pRate; 
           
        
        //  PRODUCT DETAILS INSERT INTO EMPLOYEE CART
         
         try
           {
           String query2="insert into employeecart (emp_Id,product_name,product_quantity,product_rate,amount,product_id) value("+employeeId+",'"+pName+"',"+quantity+","+pRate+","+pAmount+","+productId+")";
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           int i=st.executeUpdate(query2);
           System.out.println("CREDENTIAL INSERTTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
         
         // UPDATE PRODUCT DETAILS SUCH AS CURRENT STOCK
         
         try
           {
           String query3="update product set current_stock="+leftQuantity+" where product_Id="+productId;
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           int i=st.executeUpdate(query3);
           System.out.println("CREDENTIAL INSERTTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
         }
         
        }
      
         //     WORKING OF MODIFY BUTTON
      
       else if(action.equals("modify"))
        {
          int item=0,price=0;
          Connection con=Factory.getJdbcConnection().getConnection();
          
         try
          {
           String insertEmployeeCredential="select * from employeecart where product_Id="+productId+"";
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery(insertEmployeeCredential);
           rs.next();
           item=rs.getInt(3);
           price=rs.getInt(4);
           System.out.println("CREDENTIAL INSERTTED");
          }
         catch(Exception e)
          {
               System.out.println(e.getMessage());
          }
          
          int newAmount=0;
          leftQuantity=quantity-item;
          System.out.println("QUANTITY LEFT IS : "+leftQuantity+" PRICE : "+price);
          
       if(leftQuantity>0)
         {
             newAmount=quantity*price;
             System.out.println(" NEW AMOUNT : "+newAmount);
         try
           {
           String query3="update employeecart set product_quantity="+quantity+" where product_Id="+productId;
           String query4="update employeecart set amount="+newAmount+" where product_Id="+productId;
           Statement st=con.createStatement();
           st.executeUpdate(query3);
           st.executeUpdate(query4);
           System.out.println("CREDENTIAL INSERTTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }    
             
         try
           {
           String query3="update product set current_stock=current_stock-"+leftQuantity+" where product_Id="+productId;
           Statement st=con.createStatement();
           int i=st.executeUpdate(query3);
           System.out.println("CREDENTIAL INSERTTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
         }
       //   IF MODIFIED QUANTITY IS LESS PREVIOUS SELECT QUANTITY
       else if(leftQuantity<0)
         {
             newAmount=quantity*price;
         try
           {
           String query3="update employeecart set product_quantity="+quantity+" where product_Id="+productId;
           String query4="update employeecart set amount="+newAmount+" where product_Id="+productId;
           Statement st=con.createStatement();
           st.executeUpdate(query3);
           st.executeUpdate(query4);
           System.out.println("CREDENTIAL INSERTTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }    
             
         try
           {
           String query3="update product set current_stock=current_stock-"+leftQuantity+" where product_Id="+productId;
           Statement st=con.createStatement();
           int i=st.executeUpdate(query3);
           System.out.println("CREDENTIAL INSERTTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
         } 
       }
      
        //   WORKING OF DELETE BUTTON
        
       else if(action.equals("delete"))
        {
        int item=0;
            
        Connection con=Factory.getJdbcConnection().getConnection();
        try
          {
           String insertEmployeeCredential="select * from employeecart where product_Id="+productId+"";
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery(insertEmployeeCredential);
           rs.next();
           item=rs.getInt(3);
           
           System.out.println("CREDENTIAL INSERTTED");
          }
        catch(Exception e)
          {
               System.out.println(e.getMessage());
          }
           
          try
          {
           String insertEmployeeCredential="delete from employeecart where product_Id="+productId+"";
           Statement st=con.createStatement();       
           int i=st.executeUpdate(insertEmployeeCredential);
           
           System.out.println(i+" : ROW AFFECTED ");
          }
        catch(Exception e)
          {
               System.out.println(e.getMessage());
          }
     
          //
         
         try
           {
           String query3="update product set current_stock=current_stock+"+item+" where product_Id="+productId;
           Statement st=con.createStatement();
           int i=st.executeUpdate(query3);
        
           System.out.println(i+" ROW AFFECTED !");
           System.out.println("CREDENTIAL INSERTTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
       }
       response.sendRedirect("EmployeeAddBilling.jsp");        
    }
}

