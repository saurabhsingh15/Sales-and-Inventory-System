
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.factory.Factory"%>
<html>
<head>
    <title> Product Processing || PLACED ORDER </title>
    <link rel="stylesheet" type="text/css" href="ProductProcessing1.css"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    
    <script src="ProductProcessing1.js"></script>

</head>

  <body>

    <form action="ProductProcessing1" method="post">
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
<!--      
        <button id="submitbutton" type="submit" name="action" value="Send"></button>
        <button id="backbutton" type="submit" name="action" value="Back"></button>
         -->

     <div id="rectanglecyan"> 
    <div id="attendence"> PRODUCT PROCESSING || PRODUCT ORDER </div>
</div> 

        <div id="entry">

            
      
        
       
       <%
           String str;
           int i=0;
           ArrayList orderId=new ArrayList();
           ArrayList status=new ArrayList();
           
           Connection con=Factory.getJdbcConnection().getConnection();
           
           Statement st1=con.createStatement();
           ResultSet rs1=st1.executeQuery("select * from placedorder where status='pending' or status='RECEIVE' order by order_Id asc");
           while(rs1.next())
           {
          /*
               sum=sum+rs.getInt(5);
              
              lName.add(rs.getString(2));
              lQuantity.add(rs.getInt(3));
              lRate.add(rs.getInt(4));
              lAmount.add(rs.getInt(5));
              
            */  
              
               
               
             System.out.println("ORDER ID : "+rs1.getInt(1));
             
             orderId.add(rs1.getInt(1));
             status.add(rs1.getString(3));
              
             
             session.setAttribute("orderId",orderId); 
           }
           
           
           
           for(i=0;i<orderId.size();i++)
           {
               str=(String)status.get(i);
            %>
            
              <jsp:declaration>
               String STATUS;
           </jsp:declaration>

           <jsp:scriptlet>
                STATUS=str;
           </jsp:scriptlet>


           <label id="str">
               <jsp:expression>
                STATUS
               </jsp:expression>
         
           </label> 
            
             <fieldset id="placedorder">
               </br>
               <table id="placedordertable" border="1">
        <tr>
            <th>ORDER ID</th>
            <th>PRODUCT NAME</th>
            <th>QUANTITY</th>
            <th>RATE</th>
            <th>AMOUNT</th>
            
        </tr>
        
            
            
            
            <%
          
           
          
              // System.out.println(i1.next());
         
                  
           
           
    /*       
           List<String> lName=new ArrayList<>();
           List<Integer> lQuantity=new ArrayList<>();
           List<Integer> lRate=new ArrayList<>();
           List<Integer> lAmount=new ArrayList<>();
    */       
           
                  
           String firstName,contact,email,jobTitle,gender,department;
           
           Statement st2=con.createStatement();
           ResultSet rs2=st2.executeQuery("select * from orders where order_Id="+orderId.get(i));
           while(rs2.next())
           {
                
             System.out.println(rs2.getString(2));
               
           %>
               <tr>
          
                  <td><%=rs2.getInt(1)%></td>
                  <td><%=rs2.getString(2)%></td>
                  <td><%=rs2.getInt(3)%></td>
                  <td><%=rs2.getInt(4)%></td>
                  <td><%=rs2.getInt(5)%></td>
                                  
               </tr>
               <%
                             

}
  
%>           
            </table>
             
           </fieldset> 
<%
    }
    %>
            
        </div>
          
        <div id="orderbutton">
            <div id="textfield">
            <label for="orderid">ORDER ID : </label>
            <input id="orderid" type="int" name="orderid" >
        </div>
            <br>
            <button type="submit" name="action" value="receive" >RECEIVE</button>
            <button type="submit" name="action" value="packed" >PACKED</button>
 
         </div>
            
        	
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