
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.factory.Factory"%>
<html>
<head>
    <title> Product Processing || CUSTOMER STATUS </title>
    <link rel="stylesheet" type="text/css" href="CustomerStatus.css"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    
    <script src="DeliveryProcessing.js"></script>
    
    <link rel="stylesheet" type="text/css" href="travel.css">
  
    <script src="travel.js">
	
     

  
	
	
	</script>

</head>

  <body>

    <form action="###########################" method="post">
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
        <button id="submitbutton" type="submit" name="action" value="Send"></button>
        <button id="backbutton" type="submit" name="action" value="Back"></button>
         -->

      

          <div id="FirstContainer">
            
           <div id="firsttable">     
             <fieldset id="placedorder">
               </br>
               <table id="placedordertable" border="1">
        <tr>
            <th>ORDER ID</th>
            <th>STATUS</th>
            <th>DELIVERY ID</th>
            
        </tr>
        
        
       
       <%
           int customerId=(Integer)session.getAttribute("id");
           ArrayList order_Id=new ArrayList();
    /*       
           List<String> lName=new ArrayList<>();
           List<Integer> lQuantity=new ArrayList<>();
           List<Integer> lRate=new ArrayList<>();
           List<Integer> lAmount=new ArrayList<>();
    */       
            if(customerId!=0)
            {
                  
           String firstName,contact,email,jobTitle,gender,department;
           
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from placedorder where status!='delivered' and customer_Id="+customerId);
           while(rs.next())
           {
          /*
               sum=sum+rs.getInt(5);
              
              lName.add(rs.getString(2));
              lQuantity.add(rs.getInt(3));
              lRate.add(rs.getInt(4));
              lAmount.add(rs.getInt(5));
              
            */  
              
            order_Id.add(rs.getInt(1)); 
               
             System.out.println("ORDER ID : "+order_Id);
               
               
           
           
          
           
          
              // System.out.println(i1.next());
         
                  %>
               <tr>
                  <td><%=rs.getInt(1)%></td>
                  <td><%=rs.getString(3)%></td>
                  <td><%=rs.getInt(5)%></td>
                 
                  
               </tr>
               <%
                             
}
}
else
{

}
    /*
            session.setAttribute("lname",lName);
            session.setAttribute("lquantity",lQuantity);
            session.setAttribute("lrate",lRate);
            session.setAttribute("lamount",lAmount);
            session.setAttribute("sum",sum);
    */     
%>           
            </table>
           </fieldset>    
           </div>
        </div>

            
      
          
    <div id="routemap">
       
         <div id="floating-panel">
    <b>Mode of Travel: </b>
    <select id="mode">
      <option value="DRIVING">Driving</option>
      <option value="WALKING">Walking</option>
      <option value="BICYCLING">Bicycling</option>
      <option value="TRANSIT">Transit</option>
    </select>
    </div>
    <div id="map"></div>
    
    </div>
         
          <div id="container">
            
            <div id="secondtable">
             <fieldset id="placedorder">
               </br>
               <table id="placedordertable" border="1">
        <tr>
            <th>ORDER ID</th>
            <th>STATUS</th>
            <th>DATE</th>
            <th>TIME</th>
            
        </tr>
        
        
       
       <%
           
    /*       
           List<String> lName=new ArrayList<>();
           List<Integer> lQuantity=new ArrayList<>();
           List<Integer> lRate=new ArrayList<>();
           List<Integer> lAmount=new ArrayList<>();
    */       
            if(order_Id.size()!=0)
            {
                  
           String firstName,contact,email,jobTitle,gender,department;
           
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st1=con.createStatement();
           
           Iterator order=order_Id.iterator();
           
           while(order.hasNext())
           {
           
           ResultSet rs1=st1.executeQuery("select * from productprocessing where order_Id="+order.next()+" order by date_and_time desc");
           while(rs1.next())
           {
          /*
               sum=sum+rs.getInt(5);
              
              lName.add(rs.getString(2));
              lQuantity.add(rs.getInt(3));
              lRate.add(rs.getInt(4));
              lAmount.add(rs.getInt(5));
              
            */  
              
               
               
             System.out.println(rs1.getString(2));
               
               
           
           
          
           
          
              // System.out.println(i1.next());
         
                  %>
               <tr>
                  <td><%=rs1.getInt(1)%></td>
                  <td><%=rs1.getString(2)%></td>
                  <td><%=rs1.getDate(3)%></td>
                  <td><%=rs1.getTime(3)%></td>
                  
               </tr>
               <%
                             
              }
           }
}
else
{

}
    /*
            session.setAttribute("lname",lName);
            session.setAttribute("lquantity",lQuantity);
            session.setAttribute("lrate",lRate);
            session.setAttribute("lamount",lAmount);
            session.setAttribute("sum",sum);
    */     
%>           
              </table>  
            </fieldset>        
        </div>
      </div>
            
        	
</div> 

<div id="rectanglecyan"> 
    <div id="attendence"> PRODUCT PROCESSING || CUSTOMER STATUS </div>
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

<script src="CustomerHome.js">
 
  </script>

<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDh19fzJ3_qBOi2ueqI5N4EVOh0BGFAgvk&callback=initMap">
    </script>
    
</html>