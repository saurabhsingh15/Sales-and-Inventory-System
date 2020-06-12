package com.authority.controller;

import com.factory.Factory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       String action=request.getParameter("action");
        
       String productName=request.getParameter("productname");
       String productBrand=request.getParameter("productbrand");
       String productBarcode=request.getParameter("barcode");
       
       int costPrice=Integer.parseInt(request.getParameter("costprice"));
       int sellingPrice=Integer.parseInt(request.getParameter("sellingprice"));
       int minimumPrice=Integer.parseInt(request.getParameter("minimumprice"));
       int maximumPrice=Integer.parseInt(request.getParameter("maximumprice"));
       
       int productQuantity=Integer.parseInt(request.getParameter("productquantity"));
       int productQuality=Integer.parseInt(request.getParameter("qualityrating"));
       System.out.println(productQuality);
       String manufactureDate=request.getParameter("manufacturingdate");
       String expireDate=request.getParameter("expireDate");
       
      
       if("submit".equals(action))
       {
       try
       {
           String insertEmployeeCredential="insert into product (product_name,product_brand,barcode,selling_price,current_stock) value ('"+productName+"','"+productBrand+"',"+productBarcode+","+sellingPrice+","+productQuantity+")";
           String insertEmployeeInformation="insert into product_supply (cost_price,min_price,max_price,product_quantity,arrival_time,quality_rating,manufacture_date,expired_date) value("+costPrice+","+minimumPrice+","+maximumPrice+","+productQuantity+",0000-00-00,"+productQuality+",0000-00-00,0000-00-00)";
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           int i=st.executeUpdate(insertEmployeeCredential);
           st.executeUpdate(insertEmployeeInformation);
           System.out.println("CREDENTIAL INSERTTED");
           response.sendRedirect("AuthorityAddProduct.html");
           }
           catch(Exception e)
           {
               System.out.println(e.getMessage());
           }
    }
    else
    {
        System.out.println("VALUE NOT INSERTED");
    }
    }
  }

