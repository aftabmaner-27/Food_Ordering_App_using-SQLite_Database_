package com.aftabmaner.foododerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.aftabmaner.foododerapp.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DB_NAME = "mydatabase.db";
    final static int DB_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME ,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement ," +
                        " name text," +
                        "phone text," +
                        "price int," +
                        "image int," +
                        "quantity int ," +
                        "description text," +
                        "foodname text)"

        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if Exists orders");
        onCreate(db);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String foodname, int quantity) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /* id =0
        name = 1
        phone =2
        price =3
        image =4
        desc =5
        foodname = 6
        Quantity = 7

         */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodname);
        values.put("quantity",quantity);
      long id =  database.insert("orders",null,values);
      if (id <= 0){
          return false;
      }else {
          return true;
      }

    }

    // SELECT GET ORDERS SHOW ON MY ORDERS------------------------------------------------------------------------------
    public ArrayList<OrderModel> getOrders() {
        ArrayList<OrderModel> orders = new ArrayList<>();
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price,quantity from orders", null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OrderModel model = new OrderModel();
                model.setOrdernumber(cursor.getInt(0) + "");
                model.setSold_oder_item_Name(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3) + "");
               // model.setQty(cursor.getInt(4)+"");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;

    }


// SELECT ORDERD ITEM CLICK ON UPDATE ACTIVITY
  public Cursor getOrderById(int id){
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id = "+id , null);

        if (cursor != null)
            cursor.moveToFirst();


        return cursor;


    }


    //UPDATE ORDER ON DATABASE RUNTIME.......
  public boolean updateOrder(String name, String phone, int price, int image, String desc, String foodname, int quantity,int id) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /* id =0
        name = 1
        phone =2
        price =3
        image =4
        desc =5
          Quantity = 7
        foodname =6

         */

        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",desc);
        values.put("foodname",foodname);
        values.put("quantity",quantity);

        long row =  database.update("orders",values,"id="+id,null );
        if (row <= 0){
            return false;
        }else {
            return true;
        }

    }



//DELETE ORDER FROM DATABASE -----------------------------------------------------------------------
public int deleteOrder(String id){
        SQLiteDatabase database =  this.getWritableDatabase();
        return database.delete("orders","id="+id,null);

}


    }


