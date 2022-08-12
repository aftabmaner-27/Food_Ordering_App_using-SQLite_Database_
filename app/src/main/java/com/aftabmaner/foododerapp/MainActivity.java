package com.aftabmaner.foododerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.aftabmaner.foododerapp.Adapters.MainAdapter;
import com.aftabmaner.foododerapp.Models.MainModel;
import com.aftabmaner.foododerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burgger , "Burger","50","Chicken Burger "));
        list.add(new MainModel(R.drawable.pizza, "Pizza","150","Cheese Pizza"));
        list.add(new MainModel(R.drawable.masalafries , "Fries","50","Creamy fries "));
        list.add(new MainModel(R.drawable.heart_coffee , "Coffee","70","Hot Coffee"));
        list.add(new MainModel(R.drawable.samosa , "Samossa","80","Veg"));
        list.add(new MainModel(R.drawable.dhokla , "Dhokla","70","Dhokla "));
        list.add(new MainModel(R.drawable.vadapav , "Vada Pav","20","Vada Pav"));
        list.add(new MainModel(R.drawable.pnipuri , "Pani Puri","30","Pani Puri"));
        list.add(new MainModel(R.drawable.fried_momos , "Fried Momos","90","Fried Momos"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recycleview.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recycleview.setLayoutManager(linearLayoutManager);
    }

    // CREATE OPTION MENU AND SET TOOLBAR....................................................
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
// CLICK ON MY ORDER MENU THEN OPEN ORDERS ACTIVITY ................................................
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.oders:
                startActivity( new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}