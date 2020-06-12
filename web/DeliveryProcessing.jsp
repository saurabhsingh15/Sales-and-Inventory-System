
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.factory.Factory"%>
<html>
<head>
    <title> Product Processing || PLACED ORDER </title>
    <link rel="stylesheet" type="text/css" href="DeliveryProcessing.css"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    
    <script src="DeliveryProcessing.js"></script>
    
    <link rel="stylesheet" type="text/css" href="travel.css">
  
    <script src="travel.js">
	
     

  
	
	
	</script>

</head>

  <body>

    <form action="DeliveryProcessing" method="post">
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

       <div id="orderbutton">

            <br>
            
            <button type="submit" name="action"  value="accept">ACCEPT</button>
            <button type="submit" name="action" value="picked" >PICKED</button>
            <button type="submit" name="action" value="ontheway">ON THE WAY</button>
            <button type="submit" name="action" value="delivered">DELIVERED</button>
 
         </div>

        

            
       <div>
            
             <fieldset id="placedorder">
               </br>
               <table id="placedordertable" border="1">
        <tr>
            <th>ORDER ID</th>
            <th>CUSTOMER ID</th>
            <th>STATUS</th>
            
        </tr>
        
        
       
       <%
           int flag=0;
           int deliveryId=(Integer)session.getAttribute("id");
           System.out.println("DELIVERY ID : "+deliveryId);
           ArrayList orderId=new ArrayList();
    /*       
           List<String> lName=new ArrayList<>();
           List<Integer> lQuantity=new ArrayList<>();
           List<Integer> lRate=new ArrayList<>();
           List<Integer> lAmount=new ArrayList<>();
    */       
          
                  
           String firstName,contact,email,jobTitle,gender,department;
           
           Connection con=Factory.getJdbcConnection().getConnection();
           Statement st1=con.createStatement();
                    
           ResultSet rs1=st1.executeQuery("select * from placedorder where (status='READY FOR DROP TO DELIVERY CLIENT' or status='DELIVERY ACCEPTED' or status='DELIVERY PICKED' or status='ON THE WAY' and status!='DELIVERED') and delivery_Id="+deliveryId+" limit 1 ");
           
          //ResultSet rs1=st1.executeQuery("select * from placedorder where  status!='DELIVERED' and delivery_Id="+deliveryId+" limit 1;  ");          
          while(rs1.next())
           {
               System.out.println("FIRST QUERY IS WORKING");
               flag=1;
               orderId.add(rs1.getInt(1));
         
           %>
               <tr>
                  <td><%=rs1.getInt(1)%></td>
                  <td><%=rs1.getInt(2)%></td>
                  <td><%=rs1.getString(3)%></td>
                  
               </tr>
               <%
                             
           }
           
       if(flag==0)
         {
           ResultSet rs2=st1.executeQuery("select * from placedorder where (status='READY FOR DROP TO DELIVERY CLIENT' or status='DELIVERY ACCEPTED' or status='DELIVERY PICKED' or status='ON THE WAY' and status!='DELIVERED') and delivery_Id=0 limit 1 ");
           while(rs2.next())
           {
               System.out.println("SECOND QUERY IS WORKING");
               orderId.add(rs2.getInt(1));
         
           %>
               <tr>
                  <td><%=rs2.getInt(1)%></td>
                  <td><%=rs2.getInt(2)%></td>
                  <td><%=rs2.getString(3)%></td>
                  
               </tr>
               <%
                             
}
}
        session.setAttribute("orderid",orderId);

%>           
            </table>
             
            

  
           </fieldset> 
          
            
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
            
        	
</div> 

<div id="rectanglecyan"> 
    <div id="attendence"> PRODUCT PROCESSING || PLACED ORDER </div>
</div>

<div class="link" >
       <div id="open">
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">close &times;</a>
  <a href="#">About</a>
  <a href="#">Services</a>
  <a href="#">Clients</a>
  <a href="#">Contact</a>
</div>

<div id="main">
  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>
</div>
</div>
         
		  <a class="home" href="">HOME</a></li>        
</div>	 





 </form>
</body>

<script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDh19fzJ3_qBOi2ueqI5N4EVOh0BGFAgvk&callback=initMap">
    </script>
    
</html>