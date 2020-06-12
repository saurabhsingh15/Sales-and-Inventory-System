package com.employee.bean;

import java.util.List;



public class PdfMakerBean 
{
   List pName;
   List pQuantity;
   List pRate;
   List pAmount;
   int totalAmount;

    public List getpName() {
        return pName;
    }

    public void setpName(List pName) {
        this.pName = pName;
    }

    public List getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(List pQuantity) {
        this.pQuantity = pQuantity;
    }

    public List getpRate() {
        return pRate;
    }

    public void setpRate(List pRate) {
        this.pRate = pRate;
    }

    public List getpAmount() {
        return pAmount;
    }

    public void setpAmount(List pAmount) {
        this.pAmount = pAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
  
}
