package com.authority.controller;

import com.factory.Factory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ProductProcessing2", urlPatterns = {"/ProductProcessing2"})
public class ProductProcessing2 extends HttpServlet 
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        HttpSession session=request.getSession();
        
     //   ArrayList orderIdOfPacked=new ArrayList();
      //  ArrayList orderIdOfReadyToDrop=new ArrayList();
        
        ArrayList OrderIdOfPacked =(ArrayList) session.getAttribute("orderIdOfPacked");
        ArrayList OrderIdOfReadyToDrop = (ArrayList)session.getAttribute("orderIdOfReadyToDrop");
        
//        System.out.println("ORDER ID OF PACKED : "+OrderIdOfPacked.get(0));
//        System.out.println("ORDER ID OF READY TO DROP : "+OrderIdOfReadyToDrop);
//        
        String action=request.getParameter("action");
        
        Connection con=Factory.getJdbcConnection().getConnection();
        
        if(action.equals("readytodrop") && OrderIdOfPacked.size()>=1)
        {
            try
            {
            Statement st=con.createStatement();
            int i1=st.executeUpdate("insert into productprocessing value("+OrderIdOfPacked.get(0)+",'READY FOR DROP TO DELIVERY CLIENT',now())");
            System.out.println(i1+"rows affected ");
            System.out.println("PRODUCT PROCESSING IS UPDATED");
            }
            catch(Exception e)
            {
                System.out.println("PRODUCT PROCESSING IS NOT UPDATED");
            }
            
             try
            {
            Statement st2=con.createStatement();
            int i2=st2.executeUpdate("update placedorder set status='READY FOR DROP TO DELIVERY CLIENT' where order_Id="+OrderIdOfPacked.get(0));
            System.out.println(i2+"rows affected ");
            System.out.println("PLACEDORDER TABLE IS UPDATED");
            
            //   AGAIN REDIRECT TO SAME PAGE WITH REFRESH DATA
            response.sendRedirect("ProductProcessing2.jsp");
            }
            catch(Exception e)
            {
                System.out.println("PLACEDORDER TABLE IS NOT UPDATED");
            }
        }
        
        //
        
        else if(action.equals("drop") && OrderIdOfReadyToDrop.size()>=1)
        {
        try
            {
            Statement st3=con.createStatement();
            int i3=st3.executeUpdate("insert into productprocessing value("+OrderIdOfReadyToDrop.get(0)+",'DROPED TO DELIVERY CLIENT',now())");
            System.out.println(i3+"rows affected ");
            System.out.println("PRODUCT PROCESSING IS UPDATED");
            }
            catch(Exception e)
            {
                System.out.println("PRODUCT PROCESSING IS NOT UPDATED");
            }
            
             try
            {
            Statement st4=con.createStatement();
            int i4=st4.executeUpdate("update placedorder set status='DROPED TO DELIVERY CLIENT' where order_Id="+OrderIdOfReadyToDrop.get(0));
            System.out.println(i4+"rows affected ");
            System.out.println("PLACEDORDER TABLE IS UPDATED");
            
            //   AGAIN REDIRECT TO SAME PAGE WITH REFRESH DATA
            response.sendRedirect("ProductProcessing2.jsp");
            }
            catch(Exception e)
            {
                System.out.println("PLACEDORDER TABLE IS NOT UPDATED");
            }
        }
    }
}
