package com.aftabmaner.foododerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aftabmaner.foododerapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

//TextView value;
//int count = 0;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type",0) == 1 ) {

            final int image = getIntent().getIntExtra("Image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("Price"));
            final String foodname = getIntent().getStringExtra("Food_Name");
            final String description = getIntent().getStringExtra("Description");
         // final int quantity = Integer.parseInt(getIntent().getStringExtra("quantity"));

            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d",price));
            binding.FoodNameLbl.setText(foodname);
            binding.Detaildescription.setText(description);
          //  binding.quantityValue.setText(quantity);

// SELECTED MENU ITEM  TO ORDER NOW CLICK ON INSERTED DATA ON DATABASE ........................................

            binding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            foodname,
                            description,
                            Integer.parseInt(binding.quantityValue.getText().toString())

                    );
                    if (isInserted)
                        Toast.makeText(DetailActivity.this, foodname + " Order Success", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });
        }else {

            //GET DATA ON MY ORDER TO UPDATE ORDER ACTIVITY ........................................................

            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            int image = cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d",cursor.getInt(3)));
            binding.FoodNameLbl.setText(cursor.getString(6));
            binding.Detaildescription.setText(cursor.getString(5));
            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
         //   binding.quantityValue.setText(cursor.getString(7));

       binding.insertButton.setText("Update Now");

       binding.insertButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             boolean IsUpdated =  helper.updateOrder(
                       binding.nameBox.getText().toString(),
                       binding.phoneBox.getText().toString(),
                       Integer.parseInt(binding.priceLbl.getText().toString()),
                       image,
                       binding.FoodNameLbl.getText().toString(),
                       binding.Detaildescription.getText().toString(),
                       Integer.parseInt(binding.quantityValue.getText().toString()),
                       id
                       );
             if (IsUpdated)
                 Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
             else
                 Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
           }
       });

        }
    }
    //  QUANTITY INCREMENT AND DECREMENT METHOD----------------------------------------------
//    public void increment (View view){
//        count++;
//        value.setText(""+count);
//    }
//    public void decrement (View view){
//        if (count <= 1) count = 1;
//        else count--;
//        value.setText(""+count);
//    }


}