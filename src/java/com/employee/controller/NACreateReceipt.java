package com.employee.controller;

import com.employee.bean.PdfMakerBean;
import com.pdfMaker.PdfMaker;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CreateReceipt", urlPatterns = {"/CreateReceipt"})
public class NACreateReceipt extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
          PdfMakerBean pdf=new PdfMakerBean();
          
          HttpSession session=request.getSession();
          
          pdf.setpName((List) session.getAttribute("lname"));
          pdf.setpQuantity((List) session.getAttribute("lquantity"));
          pdf.setpRate((List) session.getAttribute("lrate"));
          pdf.setpAmount((List) session.getAttribute("lamount"));
          pdf.setTotalAmount((int) session.getAttribute("sum"));
          
          PdfMaker maker=new PdfMaker();
          maker.pdfmaker(pdf);
          
    }
}
