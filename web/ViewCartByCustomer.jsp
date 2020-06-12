<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.factory.Factory"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
    <title> VIEW CART BY CUSTOMER </title>
    <link rel="stylesheet" type="text/css" href="FetchProduct.css"/>
    <script src="CustomerHome.js">
 
  </script>
   

</head>

  <body>

    <form action="PlacedOrder" method="post">
     <div id="rectangle">
  
      <div id="circle">
        <div id="ims"> IMS </div>
        <span>CU</span>
      </div>
  
     </div>

     <p id="hey"> CHANDIGARH UNIVERSITY </p>

     <p id="imst"> INFORMATION MANAGEMENT SYSTEM </p>

     <div id="rectangleleft"> </div>
       
     <div id="rectangleright"> </div>

     <div id="rectanglebottom">
       <div id="footer">
                    <p>
                        Chandigarh University, Gharuan, Mohali (Punjab)<br />
                        General Helpline No:+91-160-3051003, +91-160-3014444<br />
                        24*7*365 Security  Helpline Number:+91-8288094308<br />
                        Wifi Hostels Helpline No. 7347017909 (Mr. Simranjeet Singh)
                    </p>
       </div>
     </div>

    <div id="rectanglemiddle" >
       <fieldset name="pquestion" id="pquestion">
         <legend id="heading"> VIEW CART  </legend>
        
               </br>
               <div id="printtable">
               <table id="printid" border="1">
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Rate</th>
            <th>Amount</th>
           
        </tr>
        
          
        
       <%
           int customerId=(Integer)session.getAttribute("id");
           int sum=0;
           
           List<String> lName=new ArrayList<>();
           List<Integer> lQuantity=new ArrayList<>();
           List<Integer> lRate=new ArrayList<>();
           List<Integer> lAmount=new ArrayList<>();
          
           
            if(customerId!=0)
            {
              String firstName,contact,email,jobTitle,gender,department;
//              int orderId;
              
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           System.out.println("Customer Id : "+customerId);
//           ResultSet rs1=st.executeQuery("select order_Id from placedorder where customer_Id="+customerId+" and status='pending' order By order_Id desc");
//           rs1.next();
//           orderId=rs1.getInt("order_Id");
//           System.out.println("ORDER ID IS : "+orderId);
           
           ResultSet rs=st.executeQuery("select * from cart where cust_Id="+customerId);
           while(rs.next())
           {
              sum=sum+rs.getInt(5);
              
              lName.add(rs.getString(2));
              lQuantity.add(rs.getInt(3));
              lRate.add(rs.getInt(4));
              lAmount.add(rs.getInt(5));
              
              
              
               
               
             System.out.println(rs.getString(2));
               
               
           
           
          
           
          
              // System.out.println(i1.next());
         
                  %>
               <tr>
                   <td><%=rs.getString(2)%></td>
                  <td><%=rs.getInt(3)%></td>
                  <td><%=rs.getInt(4)%></td>
                  <td><%=rs.getInt(5)%></td>
                 
               </tr>
               
               
               
               <%
                             
}
}
else
{

}

            session.setAttribute("lname",lName);
            session.setAttribute("lquantity",lQuantity);
            session.setAttribute("lrate",lRate);
            session.setAttribute("lamount",lAmount);
            session.setAttribute("sum",sum);
                %>          
            </table>
               </div>
            
           
            
            <jsp:declaration>
               int amount=0;
           </jsp:declaration>

           <jsp:scriptlet>
               amount=sum;
           </jsp:scriptlet>


           <label id="str">
               <jsp:expression>
                   amount
               </jsp:expression>
         
           </label>

         <label id="totalamount" >Total Amount : </label>  
           
           
 <button id="backbutton" name="action" value="back"> Back </button>
        <button id="generatebutton" name="action" value="placedorder"> Placed Order </button>	

       </fieldset>

       	
</div> 

<div id="rectanglecyan"> 
    <div id="attendence"> VIEW CART BY CUSTOMER </div>
</div>

<div class="link" >
       <div id="open">
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">close &times;</a>
  <a href="Customer_Menu.jsp">Market</a>
  <a href="ViewCartByCustomer.jsp">View Cart</a>
  <a href="OrderByCustomer.jsp">Order</a>
  <a href="CustomerStatus.jsp">Status</a>
  <a href="OrderHistoryByCustomer.jsp">Order History</a>
  <a href="CustomerPasswordUpdate.html">Password Update</a>
  <a href="#"></a>
</div>

<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
</div>
</div>
           
         <a id="log" href="Logout" onmouseover="logover()" onmouseleave="leaveover()">LOGOUT</a></li>
</div> 





 </form>
</body>
</html>