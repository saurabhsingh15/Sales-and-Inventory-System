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
    <title> STOCK DETAILS </title>
    <link rel="stylesheet" type="text/css" href="FetchProduct.css"/>
   

</head>

  <body>

    <form action="#####################" method="post">
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
         <legend id="heading"> STOCK DETAILS  </legend>
       
               </br>
               <div id="printtable">
               <table id="printid" border="1">
        <tr>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Product Brand</th>
            <th>Quantity</th>
            <th>Rate</th>
            <th>Current Stock</th>
           
        </tr>
       
       <%         
            {
           
              
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from product");
           while(rs.next())
           {
                  %>
               <tr>
                   <td><%=rs.getInt(1)%></td>
                  <td><%=rs.getString(2)%></td>
                  <td><%=rs.getString(3)%></td>
                  <td><%=rs.getInt(4)%></td>
                  <td><%=rs.getInt(5)%></td>
                  <td><%=rs.getInt(6)%></td>
                 
               </tr>
               <%
                             
}
}           
                %>          
            </table>
          </div>
       
       </fieldset>

       	
</div> 

<div id="rectanglecyan"> 
    <div id="attendence"> STOCK DETAILS </div>
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