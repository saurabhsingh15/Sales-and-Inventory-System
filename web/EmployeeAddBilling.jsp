<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.factory.Factory"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%> 
<html>
<head>
    <title> EMPLOYEE | ADD BILLING </title>
    <link rel="stylesheet" type="text/css" href="EmployeeAddBilling.css"/>
   

</head>

  <body>

    
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
         <legend id="heading"> PRODUCT PROCESSING  </legend>

       <fieldset name="searchid" id="searchid">
           <legend id="search"> SEARCH  </legend>
       </br>
       <form action="DataFetching" method="post">
         <label for="search"> Product ID :  </label>
         <input type="text" id="search" name="search" placeholder="Enter Product ID" > </br> </br>
         <label for="search"> Quantity :  </label>
         <input type="number" id="quantity" name="quantity" placeholder="Quantity" value="1"> </br> </br>
         <button id="addtocartbutton" name="action" value="addtocart"> ADD TO CART </button>	
       </form>


       </fieldset>

      <fieldset name="modifyid" id="modifyid">
        <legend id="search"> MODIFY / DELETE PRODUCT </legend>
        </br>
        <form action="DataFetching" method="post">
        <label for="search"> Product ID :  </label>
        <input type="text" id="search" name="search" placeholder="Enter Product ID" > </br> </br>
        <label for="search"> Quantity :  </label>
        <input type="number" id="quantity" name="quantity" placeholder="Quantity" value="1"> </br> </br>
        <button id="modifybutton" name="action" value="modify">MODIFY</button>	</br></br></br>
        <button id="deletebutton" name="action" value="delete">DELETE</button>	
        </form>
      </fieldset>


           </fieldset>

           <fieldset name="product" id="product">
            <legend id="showtable">CART</legend> 
               </br> 
              <div id="tablesetter">
               <table id="printid" border="1">
        <tr>
            <th>Product Id</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Rate</th>
            <th>Amount</th>
           
        </tr>
       
        <%  
        int employeeId=(Integer)session.getAttribute("id");
        int sum=0;
        
        System.out.println(employeeId);
        
        if(employeeId!=0)
        {

       
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from employeecart where emp_Id="+employeeId+"");
           while(rs.next())
             {    

               sum=sum+rs.getInt(5);
               
               System.out.println(sum);

    %> 
              <tr>
                <td><%=rs.getInt(6)%></td>  
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getInt(3)%></td>
                <td><%=rs.getInt(4)%></td>
                <td><%=rs.getInt(5)%></td>
              </tr>
         
    <%
    }}
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
           
           </fieldset>
          
            	
</div> 

<div id="rectanglecyan"> 
    <div id="attendence"> EMPLOYEE | ADD BILLING </div>
</div>

<div class="link" >
       <div id="open">
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">close &times;</a>
  <a href="CustomerInformation.html">Add Customer</a>
  <a href="EmployeeAddBilling.jsp">Add Billing</a>
  <a href="ViewCartByEmployee.jsp">View Cart</a>
  <a href="OrderHistoryByEmployee.jsp">Order History</a>
  <a href="EmployeePasswordUpdate.html">Password Update</a>
</div>

<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
</div>
</div>
          </div>
         
		  <a class="home" href="">HOME</a></li>        
</div>	 

<script type="text/javascript" src="CustomerHome.js" ></script>

</body>
</html>