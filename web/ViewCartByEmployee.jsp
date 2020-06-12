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
    <title> VIEW CART BY EMPLOYEE </title>
    <link rel="stylesheet" type="text/css" href="FetchProduct.css"/>
   

</head>

  <body>

    <form action="PlacedOrderByEmployee" method="post">
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
           int employeeId=(Integer) session.getAttribute("id");     //8;
           int sum=0;
           
           List<String> lName=new ArrayList<>();
           List<Integer> lQuantity=new ArrayList<>();
           List<Integer> lRate=new ArrayList<>();
           List<Integer> lAmount=new ArrayList<>();
          
           
            if(employeeId!=0)
            {
              String firstName,contact,email,jobTitle,gender,department;
//              int orderId;
              
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           System.out.println("Employee Id : "+employeeId);
           ResultSet rs=st.executeQuery("select * from employeecart where emp_Id="+employeeId);
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
           
           
 <button id="backbutton" name="action" value="entry"> CANCEL </button>
        <button id="generatebutton" name="action" value="out"> ORDER </button>	

       </fieldset>

       	
</div> 

<div id="rectanglecyan"> 
    <div id="attendence"> VIEW CART BY EMPLOYEE </div>
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


</form>
  </body>
<script type="text/javascript" src="CustomerHome.js" ></script>


</html>