package com.mail;

import com.customer.bean.CustomerPasswordForgetOtp;
import static com.mail.EmailAttachmentSender.sendEmailWithAttachments;



public class PasswordForget
{
    String mailTo;

   public boolean SendMail(CustomerPasswordForgetOtp data)
   {
       mailTo=data.getEmail();
       System.out.println("Mail is :"+mailTo);
        // SMTP info
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "##############";
        String password = "##############";
 
        // message info
 
        String subject = "attachments";
        String message = "YOUR OTP FOR YOUR ID IS "+data.getOtp()+" !!!.  ";
 
        // attachments
        String[] attachFiles = new String[1];
       // attachFiles[0] = "C:\\Users\\HP\\Downloads/employee.xls";
        //attachFiles[1] = "e:/Test/Music.mp3";
        //attachFiles[2] = "e:/Test/Video.mp4";
 
        try {
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo,
               subject, message);
            System.out.println("Email sent.");
        }
        catch (Exception ex) 
        {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        } 
        return true;
   }      
}
  

