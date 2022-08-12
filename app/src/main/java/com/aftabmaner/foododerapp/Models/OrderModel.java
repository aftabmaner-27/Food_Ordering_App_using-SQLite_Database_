package com.aftabmaner.foododerapp.Models;

public class OrderModel {
    // VARIABLE INITIALIZING ON [activity_order_sample.xml]..................................................
    int orderimage;
    String sold_oder_item_Name;
    String price;
    String ordernumber ;
   // String qty;

    // THEN CRATE CONSTRUCTOR ON INITIALIZE VARIABLE [PRES Alt + Insert ] SELECT CONSTRUCTOR .........................

    public OrderModel() {
        this.orderimage = orderimage;
        this.sold_oder_item_Name = sold_oder_item_Name;
        this.price = price;
        this.ordernumber = ordernumber;
       // this.qty =qty;
    }

    //THEN GENERATE GETTER AND SETTER [PRES Alt + Insert ] SELECT GETTER AND SETTER ..............................

    public int getOrderimage() {
        return orderimage;
    }

    public void setOrderimage(int orderimage) {
        this.orderimage = orderimage;
    }

    public String getSold_oder_item_Name() {
        return sold_oder_item_Name;
    }

    public void setSold_oder_item_Name(String sold_oder_item_Name) {
        this.sold_oder_item_Name = sold_oder_item_Name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

//    public String getQty() {
//        return qty;
//    }
//
//    public void setQty(String qty) {
//        this.qty = qty;
//    }

  }


