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
    <title> ORDERS VIEW BY AUTHORITY </title>
    <link rel="stylesheet" type="text/css" href="OrderHistoryByEmployee.css"/>
   

</head>

  <body>

      <!--
         <form action="PlacedOrder" method="post">
      -->
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
<!--        
        <fieldset name="pquestion" id="pquestion">
         <legend id="heading"> SEARCH PRODUCT  </legend>

       

           
               </br>
-->      
       
       <%
           int authorityId=1;
           int sum=0;
           
           List<String> lName=new ArrayList<>();
           List<Integer> lQuantity=new ArrayList<>();
           List<Integer> lRate=new ArrayList<>();
           List<Integer> lAmount=new ArrayList<>();
           List<Integer> orderId=new ArrayList<>();
           
            if(authorityId!=0)
            {
              String firstName,contact,email,jobTitle,gender,department;
         
              
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           System.out.println("Authority Id : "+authorityId);
           ResultSet rs1=st.executeQuery("select order_Id from placedorder order By order_Id desc");
           while(rs1.next())
           {
             orderId.add(rs1.getInt("order_Id"));
           }
           System.out.println("ORDER ID IS : "+orderId);
           
           Iterator i=orderId.iterator();
           while(i.hasNext())
           {
               %>
               
                
               <table id="printid" border="1">
        <tr>
            <th>Order Id</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Rate</th>
            <th>Amount</th>
           
        </tr>
               
               <%
           ResultSet rs=st.executeQuery("select * from orders where order_Id="+i.next());
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
                  <td><%=rs.getInt(1)%></td> 
                  <td><%=rs.getString(2)%></td>
                  <td><%=rs.getInt(3)%></td>
                  <td><%=rs.getInt(4)%></td>
                  <td><%=rs.getInt(5)%></td>
                 
               </tr>
               <%
                             
}
%>
             </table>
             <br>             
            
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

             <br>
             <br>
             <br>

<%
}
}
else
{

}

//            session.setAttribute("lname",lName);
//            session.setAttribute("lquantity",lQuantity);
//            session.setAttribute("lrate",lRate);
//            session.setAttribute("lamount",lAmount);
//            session.setAttribute("sum",sum);
                %>     
<!--                
           </fieldset>
          
           
 <button id="backbutton" name="action" value="entry"> Back </button>
        <button id="generatebutton" name="action" value="out"> Placed Order </button>	

-->       

       	
</div> 

<div id="rectanglecyan"> 
    <div id="attendence"> ORDERS BY AUTHORITY </div>
</div>


<div class="link" >
       <div id="open">
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">close &times;</a>
  <a href="EmployeeInformati.html">Add  Employee</a>
  <a href="CustomerInformation.html">Add Customer</a>
  <a href="ProductProcessing1.jsp">Product Packing</a>
  <a href="ProductProcessing2.jsp">Product Outing</a>
  <a href="AuthorityPriceUpdate.jsp">Update Price</a>
  <a href="AuthorityStockUpdate.jsp">Update Stock</a>
  <a href="AuthorityAddProduct.html">Add Product</a>
  <a href="UpdateProduct.jsp">Update Product Detail</a>
  <a href="OrderViewByAuthority.jsp">Order History</a>
  <a href="AuthorityStockDetail.jsp">Stock Details</a>
  <a href="AuthorityPasswordUpdate.html">Password Update</a>
  
</div>

<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
</div>
</div>
          
		  <a class="home" href="">HOME</a></li>   
</div>
<script type="text/javascript" src="CustomerHome.js" ></script>




<!--
 </form>
 -->
 
</body>
</html>