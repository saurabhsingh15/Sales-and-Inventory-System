package com.pdfMaker;

import com.employee.bean.PdfMakerBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.awt.Font;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class PdfMaker
{
    int i;          
public void pdfmaker(PdfMakerBean bean)
{
    System.out.println("==========================================");
   
   System.out.println(bean.getTotalAmount()+" "+bean.getpQuantity()+" "+bean.getpRate()+" "+bean.getpAmount() );
        
        
        try {
            
          com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
          com.itextpdf.text.pdf.PdfWriter myWriter = com.itextpdf.text.pdf.PdfWriter.getInstance(myDocument, new FileOutputStream("C:\\Users\\HP\\Downloads/Receipt.pdf"));
         
          myDocument.open();
                            
         com.itextpdf.text.pdf.PdfPTable table = new com.itextpdf.text.pdf.PdfPTable(2);
        
         myDocument.add(new Paragraph("                                                                                                                                    STAMP:-------------------------",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD,BaseColor.DARK_GRAY)));
         myDocument.add(new Paragraph("                              S.R EMPIRE,CHANDIGARH",FontFactory.getFont(FontFactory.TIMES_ROMAN,16,Font.BOLD,BaseColor.DARK_GRAY)));
//         myDocument.add(new Paragraph("                                         "+bean.getNameofexam(),FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.DARK_GRAY)));
//         myDocument.add(new Paragraph("Course:"+bean.getCourse()+"                                                                                  "+bean.getSemester(),FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.DARK_GRAY)));
//         myDocument.add(new Paragraph("Sub.:"+bean.getSubject()+"                                                                         "+"Sub.Code:"+bean.getPapercode(),FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.DARK_GRAY)));
//         myDocument.add(new Paragraph("Time Allowed:"+bean.getExamtime()+"                                                                "+"Maximum Marks:"+bean.getMaxmark(),FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.DARK_GRAY)));
//         myDocument.add(new Paragraph("Note:"+bean.getNote(),FontFactory.getFont(FontFactory.TIMES_ROMAN,13,Font.BOLD,BaseColor.DARK_GRAY)));
   
            int size=bean.getpName().size();

    
//           List name1= bean.getpName();
//           List rate1=bean.getpRate();
//           List quantity1=bean.getpQuantity();
//           List amount1=bean.getpAmount();
           
           Iterator name1=bean.getpName().iterator();        
           Iterator quantity= bean.getpQuantity().iterator();
           Iterator rate= bean.getpRate().iterator();
           Iterator amount=bean.getpAmount().iterator();
           int sum=bean.getTotalAmount();
         
while(name1.hasNext())
{
       // System.out.println("hello"+name1.next());
                  myDocument.add(new Paragraph(""+name1.next()+"      "+quantity.next()+"      "+rate.next()+"      "+amount.next()+"",FontFactory.getFont(FontFactory.TIMES_ROMAN,13,Font.PLAIN,BaseColor.DARK_GRAY)));
                

//    
}        
   myDocument.add(new Paragraph("================================================="+"",FontFactory.getFont(FontFactory.TIMES_ROMAN,13,Font.PLAIN,BaseColor.DARK_GRAY)));               

   myDocument.add(new Paragraph("Total Amount : "+sum+""+"",FontFactory.getFont(FontFactory.TIMES_ROMAN,13,Font.PLAIN,BaseColor.DARK_GRAY)));               

   myDocument.add(new Paragraph("================================================="+"",FontFactory.getFont(FontFactory.TIMES_ROMAN,13,Font.PLAIN,BaseColor.DARK_GRAY)));               

//          for(i=1;i<=size;i++)
//         {
//             myDocument.add(new Paragraph("Q."+name1.indexOf(i)+""+"",FontFactory.getFont(FontFactory.TIMES_ROMAN,13,Font.PLAIN,BaseColor.DARK_GRAY)));
//         }
//       
       /* while(name.hasNext() && quantity.hasNext() && rate.hasNext())
         {
  //       String counts1=(String) name.next();
       //  int counts=Integer.parseInt(counts1);
        // String quess=(String) ques.next();   
      
      //   myDocument.add(new Paragraph("                                        MARKS "+mark.next(),FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.DARK_GRAY)));
         
         for(i=1;i<=size;i++)
         {
             myDocument.add(new Paragraph("Q."+name.next()+""+"",FontFactory.getFont(FontFactory.TIMES_ROMAN,13,Font.PLAIN,BaseColor.DARK_GRAY)));
         }
       //  }

*/
          myDocument.close();  
          JOptionPane.showMessageDialog(null,"QUESTION PAPER IS SUCCESSFULLY GENERATED");





}



        catch(Exception e)
           {
               System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,e);
            System.out.println("Not run");
           }
    
}
}
