<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.factory.Factory"%>
<html>
<head>
    <title> Product Processing || PLACED ORDER </title>
    <link rel="stylesheet" type="text/css" href="ProductProcessing2.css"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    
    <script src="ProductProcessing2.js"></script>

</head>

  <body>

    <form action="ProductProcessing2" method="post">
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
       <div name="pquestion" id="pquestion">


</div>
        
       <div  id="entry">
            
             <fieldset id="placedorder">
               </br>
               <table id="placedordertable" border="1">
        <tr>
            <th>ORDER ID</th>
            <th>ORDER ID</th>
            <th>CUSTOMER ID</th>
            <th>STATUS</th>
            <th>DELIVER ID</th>
            
        </tr>
        
        
       
       <%
           
           
          
           
          
    /*       
           List<String> lName=new ArrayList<>();
           List<Integer> lQuantity=new ArrayList<>();
           List<Integer> lRate=new ArrayList<>();
           List<Integer> lAmount=new ArrayList<>();
    */      
    
        ArrayList orderIdOfPacked=new ArrayList();  
        ArrayList orderIdOfReadyToDrop=new ArrayList();
    
        int orderId=1;
        
        Connection con=Factory.getJdbcConnection().getConnection();
        
            if(orderId!=0)
            {
                  
           String firstName,contact,email,jobTitle,gender,department;
           
           Statement st1=con.createStatement();
           ResultSet rs1=st1.executeQuery("select * from placedorder where status='PACKED'");
           while(rs1.next())
           {
           
              orderIdOfPacked.add(rs1.getInt(1));
               
               
             System.out.println(rs1.getString(1));
               
           %>
               <tr>
                  <td></td>
                  <td><%=rs1.getInt(1)%></td>
                  <td><%=rs1.getInt(2)%></td>
                  <td><%=rs1.getString(3)%></td>
                  <td></td>
                  
                  
               </tr>
               <%
                             
}

System.out.println(orderIdOfPacked);

ResultSet rs2=st1.executeQuery("select * from placedorder where status='READY FOR DROP TO DELIVERY CLIENT'");
           while(rs2.next())
           {
          
             orderIdOfReadyToDrop.add(rs2.getInt(1));
                     
             System.out.println(rs2.getString(1));
          
           %>
               <tr>
                  <td></td>
                  <td><%=rs2.getInt(1)%></td>
                  <td><%=rs2.getInt(2)%></td>
                  <td><%=rs2.getString(3)%></td>
                  <td></td>
                  
                  
               </tr>
               <%
                             
}

System.out.println(orderIdOfReadyToDrop);


}
else
{

}  

           session.setAttribute("orderIdOfPacked",orderIdOfPacked);
           session.setAttribute("orderIdOfReadyToDrop",orderIdOfReadyToDrop);
%>           
            </table>
             
           
  
           </fieldset> 
          
            
        </div>
          
        <div id="orderbutton">

            <br>
            <button type="submit" name="action" value="readytodrop" >READY</button>
            <button type="submit" name="action" value="drop" >DROP</button>
 
         </div>
            
        	
</div> 

<div id="rectanglecyan"> 
    <div id="attendence"> PRODUCT PROCESSING || PLACED ORDER </div>
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
</form>
  </body>
<script type="text/javascript" src="CustomerHome.js" ></script>

</html>