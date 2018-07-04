package com.example.android.popmovies_1;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static java.lang.String.valueOf;



public class DetailActivity extends AppCompatActivity {
    String myTitle;
    double myVotes;
    String myDate;
    String myOverview;
    String myBackdrop;
    String myPoster;
    TextView mVotes;
    TextView mDate;
    TextView mOverview;
    ImageView mBackdrop;
    ImageView mPoster;
    FloatingActionButton mFab;
    boolean flag = true; // true if first icon is visible, false if second one is visible.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mVotes = findViewById(R.id.user_rating);
        mDate = findViewById(R.id.release_date);
        mOverview = findViewById(R.id.overview);
        mBackdrop = findViewById(R.id.backdrop);
        mPoster = findViewById(R.id.detail_poster);

        myTitle = getIntent().getExtras().getString("title", "defaultkey");
        myVotes = getIntent().getDoubleExtra("votes", 0.0);
        myDate = getIntent().getExtras().getString("date", "defaultkey");
        myOverview = getIntent().getExtras().getString("overview", "defaultkey");
        myBackdrop = getIntent().getExtras().getString("backdrop", "defaultkey");
        myPoster = getIntent().getExtras().getString("poster", "defaultkey");

        //get just the year from the date string 0=year - 1=month - 2=date
        String input = myDate;
        String[] out = input.split("-");


        mVotes.setText(valueOf(myVotes));
        mDate.setText(out[0]);
        mOverview.setText(myOverview);
        getSupportActionBar().setTitle(myTitle);

        Picasso.get()
                .load("http://image.tmdb.org/t/p/w300/" + myBackdrop)
                .placeholder(R.color.colorPrimaryDark)
                .into(mBackdrop);

        Picasso.get()
                .load("http://image.tmdb.org/t/p/w185/" + myPoster)
                .placeholder(R.color.colorPrimaryDark)
                .into(mPoster);

        // Floating Action Button -add/delete from favorites
        mFab = findViewById(R.id.myFAB);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag){
                    // need to figure out how to set the ripple on and off click - future plans for app leaving code here for reference
                    //mFab.setRippleColor(getResources().getColor(R.color.floating_action_button_color));
                    mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff8800")));
                    flag = false;
                    Toast.makeText(DetailActivity.this, "Added to favorites", Toast.LENGTH_LONG).show();

                }else if(!flag){
                   // mFab.setRippleColor(getResources().getColor(R.color.floating_action_button_color));
                    mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#424242")));
                    flag = true;
                    Toast.makeText(DetailActivity.this, "Removed from favorites", Toast.LENGTH_LONG).show();

                }

            }
        });


    }



}

