package com.employee.controller;

import com.factory.Factory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DataFetch", urlPatterns = {"/DataFetch"})
public class NADataFetch extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
         int productId=Integer.parseInt(request.getParameter("search"));
         System.out.println("product"+productId);
         
         HttpSession session=request.getSession();
         session.setAttribute("productId",productId);
         
         int customerId=1;
         String pName=(String) session.getAttribute("pname");
         int pQuantity=(Integer) session.getAttribute("pquantity");
         int pRate=(Integer) session.getAttribute("prate");
         int amount=20;
         
         try
           {
           String insertEmployeeCredential="insert into cart (cust_Id,product_name,product_quantity,product_rate,amount) value("+customerId+",'"+pName+"',"+pQuantity+","+pRate+","+amount+")";
          // String insertEmployeeInformation="insert into employeeinformation (house_no,address_line,village,post,city,state,country,pincode) value('"+houseNo+"','"+addressLine1+"','"+village+"','"+post+"','"+city+"','"+state+"','"+country+"','"+pincode+"')";
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           int i=st.executeUpdate(insertEmployeeCredential);
        //   st.executeUpdate(insertEmployeeInformation);
           System.out.println("CREDENTIAL INSERTED");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
         
         response.sendRedirect("ProductFetch.jsp");
        
    }
}

 