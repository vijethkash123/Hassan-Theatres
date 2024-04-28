package com.example.vijeth.hassantheatres;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Hp on 5/1/2017.
 */

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {

    private List<ListItem1> listItems1;
    private Context context1;
    Typeface tt_light,tt_bold,fawesome;


    public MyAdapter1(List<ListItem1> listItems1, Context context1) {
        this.listItems1 = listItems1;
        this.context1 = context1;
        tt_light = Typeface.createFromAsset(context1.getAssets(),  "fonts/tt_light.ttf");
        tt_bold = Typeface.createFromAsset(context1.getAssets(),  "fonts/tt_bold.ttf");
        fawesome = Typeface.createFromAsset(context1.getAssets(),  "fonts/fontawesome.ttf");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item1, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ListItem1 ListItem = listItems1.get(position);
        holder.textViewhead1.setTypeface(fawesome);
        holder.textViewDesc1.setTypeface(fawesome);
        holder.textViewhead1.setText(context1.getResources().getString(R.string.marker_icon)+" "+ListItem.getHead());
        holder.textViewDesc1.setText(context1.getResources().getString(R.string.event)+" "+ListItem.getDesc());

        Picasso.with(context1)
                .load(ListItem.getImageUrl())
                .into(holder.imageView1);

        holder.linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context1 , "Cultural Event in  " + ListItem.getHead(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems1.size();
    }

    public Context getContext() {
        return context1;
    }

    public void setContext(Context context) {
        this.context1 = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewhead1;
        public TextView textViewDesc1;
        public ImageView imageView1;
        public LinearLayout linearLayout1;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewhead1 = (TextView) itemView.findViewById(R.id.textViewHead1);
            textViewDesc1 = (TextView) itemView.findViewById(R.id.textViewDesc1);
            imageView1= (ImageView) itemView.findViewById(R.id.imageView1);
            linearLayout1 = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }

}
