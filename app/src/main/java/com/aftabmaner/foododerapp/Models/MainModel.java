package com.aftabmaner.foododerapp.Models;

public class MainModel {
    // VARIABLE INITIALIZING ON [activity_sample_main_food.xml]..................................................
    int image;
    String name, price, description;

// THEN CREATE CONSTRUCTOR ON INITIALIZE VARIABLE [PRES Alt + Insert ] SELECT CONSTRUCTOR .........................

    public MainModel(int image, String name, String price, String description) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
    }

  //THEN GENERATE GETTER AND SETTER [PRES Alt + Insert ] SELECT GETTER AND SETTER ..............................

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

