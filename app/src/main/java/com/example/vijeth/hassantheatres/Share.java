package com.example.vijeth.hassantheatres;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by Vijeth on 4/10/2017.
 */

public class Share extends AppCompatActivity {
    View b;
    ImageView imgClick;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);
        final FancyButton b=(FancyButton) findViewById(R.id.share_btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(changeAnim(i%8))
                                .duration(1500)
                                .playOn(b);

                        i++;

                        Intent myIntent = new Intent(Intent.ACTION_SEND);
                        myIntent.setType("text/plain");
                        String shareBody = "This App is so cool. You should try it out. Download Hassan Theatres app made by Vijeth Kashyap from Google Play Store #Hassan #Love\n" +
                                "\n" +
                                "ಹಾಸನದ ಚಿತ್ರಮಂದಿರಗಳು app ಬಳಸಿದ್ದಕ್ಕಾಗಿ ಧನ್ಯವಾದಗಳು.\n" +
                                "\n" +
                                "ಈ app ನಿಮ್ಮ ಸ್ನೇಹಿತರೊಂದಿಗೆ share ಮಾಡುವುದಕ್ಕಾಗಿ Google Play store ನಿಂದ download ಮಾಡಿ #ಹಾಸನ :)";
                        String shareSub = "Hassan Theatres";
                        myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                        myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                        startActivity(Intent.createChooser(myIntent,"Share with these apps :)"));
                    }
                });

            }

        });

        imgClick = (ImageView)findViewById(R.id.imageView5);

        imgClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://www.facebook.com/hassannews");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        String shareBody = "This App is so cool. You should try it out. Download Hassan Theatres app made by Vijeth Kashyap from Google Play Store #Hassan #Love\n" +
                "\n" +
                "ಹಾಸನದ ಚಿತ್ರಮಂದಿರಗಳು app ಬಳಸಿದ್ದಕ್ಕಾಗಿ ಧನ್ಯವಾದಗಳು.\n" +
                "\n" +
                "ಈ app ನಿಮ್ಮ ಸ್ನೇಹಿತರೊಂದಿಗೆ share ಮಾಡುವುದಕ್ಕಾಗಿ Google Play store ನಿಂದ ಡೌನ್ಲೋಡ್ ಮಾಡಲು ಸೂಚಿಸಿ #ಹಾಸನ :)";
        String shareSub = "Hassan Theatres";
        myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
        myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
        startActivity(Intent.createChooser(myIntent,"Share with these apps :)"));
    }

    public Techniques changeAnim(int change)
    {
        switch(change)
        {
            case 0:return Techniques.ZoomInDown;
            case 1:return Techniques.Tada;
            case 2:return Techniques.Swing;
            case 3:return Techniques.Bounce;
            case 4:return Techniques.FadeInDown;
            case 5:return Techniques.RotateIn;
            case 6:return Techniques.FlipInX;
            case 7:return Techniques.Flash;
            case 8:return Techniques.RubberBand;
            default:return Techniques.Tada;
        }
    }
}
