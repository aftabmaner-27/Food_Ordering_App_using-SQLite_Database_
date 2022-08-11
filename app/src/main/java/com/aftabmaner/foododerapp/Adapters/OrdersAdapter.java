package com.aftabmaner.foododerapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aftabmaner.foododerapp.DBHelper;
import com.aftabmaner.foododerapp.DetailActivity;
import com.aftabmaner.foododerapp.Models.OrderModel;
import com.aftabmaner.foododerapp.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder> {

    public OrdersAdapter(ArrayList<OrderModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    ArrayList<OrderModel> list;
    Context context;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

// MENU ITEM SELECT AND GO TO DETAIL ACTIVITY  ...............................................................

        final OrderModel model = list.get(position);
        holder.orderimage.setImageResource(model.getOrderimage());
        holder.soldoderitem.setText((CharSequence) model.getSold_oder_item_Name());
        holder.ordernumber.setText((CharSequence) model.getOrdernumber());
        holder.price.setText((CharSequence) model.getPrice());

// CLICK ON MY ORDER ITEM  SELECT AND GO TO UPDATE ORDER ACTIVITY ................................................................

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("id",Integer.parseInt(model.getOrdernumber()));
                intent.putExtra("type",2);
                context.startActivity(intent);
            }
        });


//DELETE ORDER ON LONG PRESS----------------------------------------------------------

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete Order")
                        .setIcon(R.drawable.ic_baseline_delete_sweep_24)
                        .setMessage("Are You Want To Delete This Order")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper helper = new DBHelper(context);
                                if( helper.deleteOrder(model.getOrdernumber()) > 0){
                                    Toast.makeText(context, "DELETED", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(context, "ERRORS", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();


                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView orderimage;
        TextView soldoderitem, price,ordernumber ;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderimage = itemView.findViewById(R.id.orderimage);
            soldoderitem = itemView.findViewById(R.id.OrderItemName);
            price = itemView.findViewById(R.id.orderprice);
            ordernumber = itemView.findViewById(R.id.ordernumbers);
        }
    }
}
