package com.aftabmaner.foododerapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aftabmaner.foododerapp.DetailActivity;
import com.aftabmaner.foododerapp.Models.MainModel;
import com.aftabmaner.foododerapp.R;

import java.util.ArrayList;

// SECOND   CLASS ON  EXTEND KEYWORD USE AND IMPLEMENT RecyclerView.Adapter<MainAdapter.viewHolder> THEN PRESS [ Alt + ENTER ] IMPLEMENT METHOD

public class  MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> {

    ArrayList<MainModel> list ;
    Context context ;

//THEN PRESS [ Alt + ENTER ] IMPLEMENT CONSTRUCTOR ....................................

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.sample_main_food,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
// MENU ITEM SELECT AND GO TO DETAIL ACTIVITY ..................................................
        //SET DATA ON SELECTED MENU .............................................
        final MainModel model = list.get(position);
        holder.Food_image.setImageResource(model.getImage());
        holder.Main_name.setText(model.getName());
        holder.Price.setText(model.getPrice());
        holder.Descrition.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image",model.getImage());
                intent.putExtra("Price",model.getPrice());
                intent.putExtra("Description",model.getDescription());
                intent.putExtra("Food_Name",model.getName());
                intent.putExtra("type",1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

// FRIST CREATE CLASS ON VIEWHOLDER  THEN EXTEND KEYWORD USE AND IMPLEMENT RecyclerView.ViewHolder THEN PRESS
    public class  viewHolder extends RecyclerView.ViewHolder{

        ImageView Food_image;
        TextView Main_name, Price, Descrition;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            Food_image = itemView.findViewById(R.id.imageView);
            Main_name = itemView.findViewById(R.id.name);
            Price = itemView.findViewById(R.id.order_price);
            Descrition = itemView.findViewById(R.id.discription);
        }
    }
}
