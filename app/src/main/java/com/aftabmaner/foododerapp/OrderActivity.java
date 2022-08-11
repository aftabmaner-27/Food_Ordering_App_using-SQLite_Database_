package com.aftabmaner.foododerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;


import com.aftabmaner.foododerapp.Adapters.OrdersAdapter;
import com.aftabmaner.foododerapp.Models.OrderModel;

import com.aftabmaner.foododerapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


      DBHelper helper =new DBHelper(this);
        ArrayList<OrderModel> list = helper.getOrders();

        OrdersAdapter adapter = new OrdersAdapter(list,this);
        binding.orderRecyleerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.orderRecyleerView.setLayoutManager(linearLayoutManager);

    }
}