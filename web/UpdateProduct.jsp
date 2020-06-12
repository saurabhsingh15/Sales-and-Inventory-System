<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.factory.Factory"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="UpdateProduct.css">

</head>
<body>

<h2 style="text-align:center">PRODUCT UPDATION</h2>


<%

   String query="select * from product join product_supply";
   Connection con=Factory.getJdbcConnection().getConnection();
   Statement st=con.createStatement();
   ResultSet rs=st.executeQuery(query);
   while(rs.next())
   {
     System.out.println(rs.getString("product_name")+" "+rs.getString("product_brand")+" "+rs.getInt("barcode")+" "+rs.getInt("selling_price")+" "+rs.getString("current_stock")+"");     
   
      
  %> 
   <div class="card">  
  <img src="image/item.jpg" alt="food" style="width:100%">
 
 
  <div class="staticname">
  <p class="static">Product Name : <input class="dynamic" type="text" value="<%=rs.getString("product_name")%>"></p>
  
  <p class="static">Product Brand : <input class="dynamic" type="text" value="<%=rs.getString("product_name")%>"></p>
  
  <p class="static">Minimum Price : <input class="dynamic" type="text" value="<%=rs.getString("min_price")%>"></p>
  
  <p class="static">Maximum Price : <input class="dynamic" type="text" value="<%=rs.getString("max_price")%>"></p>
  
  <p class="static">Cost Price : <input class="dynamic" type="text" value="<%=rs.getString("cost_price")%>"></p>
  
  <p class="static">Selling Price : <input class="dynamic" type="text" value="<%=rs.getString("selling_price")%>"></p>
  
  <p class="static">Current Stock : <input class="dynamic" type="text" value="<%=rs.getString("current_stock")%>"></p>
  
  </div>
 
  
  
  <p><button>UPDATE</button></p>
  </div>
    
  <%
  }
  
%>

</body>
</html>
