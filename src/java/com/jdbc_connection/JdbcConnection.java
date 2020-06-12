package com.jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection
{
 public Connection getConnection()
 {
     Connection con = null;
     try
     {
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmarch2020","root","root");
     }
     catch(Exception e)
     {
         
     }
     return con;
 }
}
