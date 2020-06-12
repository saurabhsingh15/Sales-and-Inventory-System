 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
 
<!DOCTYPE html>
<html>
<head>
  <title>Customer | Menu </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <link rel="stylesheet" href="Customer_Menu.css">
  <style>

  /* Note: Try to remove the following lines to see the effect of CSS positioning */
  .affix 
  {
   top:0px; 
    width: 100%;
    z-index: 6;
  }

  #image
  {
     text-align: center;
     width: 100%;
     height: 300px;
  }

  body
   {
    position: relative;

  }
  ul.nav-pills {
    top: 60%;
    margin-left: -20px;
    position: fixed;
  }
  div.col-sm-9 div 
  {
    height: 250px;
    font-size: 28px;
    left: 50px;
  }
  #section1
   {
    padding-top:10px;
    height:1200px;
    color: #fff;
    background-color: #1E88E5;
    padding-bottom: 0px;
   }
  #section2 {padding-top:50px;height:1200px;color: #fff; background-color: #673ab7;}
  #section3 {padding-top:50px;height:500px;color: #fff; background-color: #ff9800;}
  #section41 {padding-top:50px;height:500px;color: #fff; background-color: #00bcd4;}
  #section42 {padding-top:50px;height:500px;color: #fff; background-color: #009688;}
  
  @media screen and (max-width: 900px)
   {
    #section1, #section2, #section3, #section41, #section42 
    {
      margin-left: 50px;
    }
  }

.container
{
  margin-left:10px; 
}

  #addtocart
  {
      background: green;
      color:white;
  }

</style>

</head>

<body   data-spy="scroll" data-target=".navbar" data-offset="50">   
          <!--  // START OF THE FIRST UPPER PART -->
<div class="container-fluid" Style="height:300px;">
  <img id="image" src="image/beadcrumb.jpg">
  
</div>
<!-- 
             // END OF THE FIRST UPPER PART
               START OF THE NAVIGATION PART SECOND PART -->
<!-- <nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="100">
  <ul class="nav navbar-nav">
    <li class="active"><a href="#">Basic Topnav</a></li>
    <li><a href="#">Page 1</a></li>
    <li><a href="#">Page 2</a></li>
    <li><a href="#">Page 3</a></li>
  </ul>
</nav> -->


<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="200">
  <div class="container-fluid">
    <div class="navbar-header">
        <!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
      </button> -->
      
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
  
  <div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li><a href="#section1">Section 1</a></li>
          <li><a href="#section2">Section 2</a></li>
          <li><a href="#section3">Section 3</a></li>
          <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Section 4 <span class="caret"></span></a>

            <ul class="dropdown-menu">
              <li><a href="#section41">Section 4-1</a></li>
              <li><a href="#section42">Section 4-2</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>

  </div>
</nav>  
<div class="container">
  <div class="row">

    

<div class="col-sm-10">
    <div id="section1">  
        <div class="row">    

         
            
 <!--CONNECTION WITH DATABASE-->
    <%
        /*
        HttpSession sess=request.getSession();
        int id=(int)sess.getAttribute("restaurantid");
        System.out.println("Edit Inner : "+id);
       */ int i=0;
       String query="select * from product";
       Class.forName("com.mysql.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmarch2020","root","root");
      
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery(query);
       while(rs.next())
       {
           i++;
           
    %>    



             <!-- // END OF THE NAVIGATION BAR  -->



    
    <div class="col-md-3"> 
      <form action="CartCalculator" method="post">
       <div class="card">
        <img src="image/food2.jpg" alt="John" style="width:100%">
        <div>
        <label for="productid">Product Id : </label>
        <input type="text" value="<%=rs.getInt("product_Id")%>" name="product_Id">
        </div>
        <p><b>Name : </b><%=rs.getString(2)%></p>
        <p><b>Brand : </b><%=rs.getString(3)%></p>
        <p><b>Price : </b><%=rs.getInt(5)%></p>
        <p><button>ADD TO CART</button></p>
       </div>
      </div>   
     </form> 
  <% } %>  
 
   
          
  </div>


</div>
</div>

<div class="viewcart">
  <div class="container1">
    <h4>Cart
      <span class="price" style="color:black">
        <i class="fa fa-shopping-cart"></i>
        <b>4</b>
      </span>
    </h4>
    <p><a href="#">Product 1</a> <span class="price">$15</span></p>
    <p><a href="#">Product 2</a> <span class="price">$5</span></p>
    <p><a href="#">Product 3</a> <span class="price">$8</span></p>
    <p><a href="#">Product 4</a> <span class="price">$2</span></p>
    <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
  </div>
</div>


  
</div>



      <div id="section2"> 
       <div class="row">
    <div class="col-md-5">
    <div class="thumbnail">
     
        </div>

       
    </div>
  </div>
</div>
      </div> 

      <div id="section3">         
        <h1>Section 3</h1>
        <p>Try to scroll this section and look at the navigation list while scrolling!</p>
      </div>
      <div id="section41">         
        <h1>Section 4-1</h1>
        <p>Try to scroll this section and look at the navigation list while scrolling!</p>
      </div>      
      <div id="section42">         
        <h1>Section 4-2</h1>
        <p>Try to scroll this section and look at the navigation list while scrolling!</p>
      </div>

    </div>
  </div>
</div>






</body>
</html>
