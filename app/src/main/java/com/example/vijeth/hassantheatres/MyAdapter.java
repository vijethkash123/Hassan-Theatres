package com.example.vijeth.hassantheatres;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.squareup.picasso.Picasso;

import java.util.List;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by Hp on 5/1/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List <ListItem> listItems;
    private Context context;
    Typeface tt_light,tt_bold,fawesome;
    int i=0;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
        tt_light = Typeface.createFromAsset(context.getAssets(),  "fonts/tt_light.ttf");
        tt_bold = Typeface.createFromAsset(context.getAssets(),  "fonts/tt_bold.ttf");
        fawesome = Typeface.createFromAsset(context.getAssets(),  "fonts/fontawesome.ttf");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ListItem ListItem = listItems.get(position);
        holder.textViewhead.setTypeface(fawesome);
        holder.textViewDesc.setTypeface(fawesome);
        holder.textViewShare.setTypeface(fawesome);
        holder.textViewhead.setText(context.getResources().getString(R.string.movie_icon)+" "+ListItem.getHead());
        holder.textViewDesc.setText(context.getResources().getString(R.string.marker_icon)+" "+ListItem.getDesc());
        holder.textViewShare.setText(context.getResources().getString(R.string.share)+" Share");

        Picasso.with(context)
                .load(ListItem.getImageUrl())
                .into(holder.imageView);

        holder.textViewhead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context , "Running in  " + ListItem.getDesc(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.textViewDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context , "Running in  " + ListItem.getDesc(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(ListItem.getTrailer());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });
        holder.textViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(changeAnim(i%8)).duration(1000).playOn(v);
                i++;
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                myIntent.setType("text/plain");
                String shareBody = ListItem.getHead() + " is currently running in " + "_"+  ListItem.getDesc()+ "_"+  " theatre"+  ". To get updates of movies and Cultural Events in Hassan city, download *Hassan Theatres* app from Google Play Store";
                String shareSub = "Hassan Theatres";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                context.startActivity(myIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewhead;
        public TextView textViewDesc;
        public TextView textViewShare;
        public ImageView imageView;
        public LinearLayout linearLayout;
        public FancyButton you;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewhead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            textViewShare = (TextView) itemView.findViewById(R.id.textViewShare);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            you = (FancyButton) itemView.findViewById(R.id.you);
        }
    }

    public Techniques changeAnim(int change)
    {
        switch(change)
        {
            case 1:return Techniques.ZoomInRight;
            case 0:return Techniques.Tada;
            case 2:return Techniques.ZoomInDown;
            case 3:return Techniques.Bounce;
            case 4:return Techniques.RotateInDownLeft;
            case 5:return Techniques.RotateIn;
            case 6:return Techniques.FlipInX;
            case 7:return Techniques.ZoomIn;
            case 8:return Techniques.RubberBand;
            default:return Techniques.RotateOutUpLeft;
        }
    }

}
