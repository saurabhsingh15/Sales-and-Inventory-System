package com.factory;


import com.generator.*;
import com.jdbc_connection.JdbcConnection;
import com.mail.PasswordForget;
import com.mail.SendOtp;
import com.mail.Send_Password;

public class Factory 
{
 public static JdbcConnection getJdbcConnection()
 {
     return new JdbcConnection();
 }
 
public static Generate_Password getGenerate_Password()
{
    return new Generate_Password();
}

public static Send_Password getSend_Password()
{
    return new Send_Password();
}

public static SendOtp getSendOtp()
{
    return new SendOtp();
}

public static PasswordForget getPasswordForget()
{
    return new PasswordForget();
}
}
