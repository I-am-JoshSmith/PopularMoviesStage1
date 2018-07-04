package com.example.android.popmovies_1;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.String.valueOf;



public class DetailActivity extends AppCompatActivity {
    String myTitle;
    double myVotes;
    String myDate;
    String myOverview;
    String myBackdrop;
    String myPoster;
    Integer myTrailer;
    TextView mVotes;
    TextView mDate;
    TextView mOverview;
    ImageView mBackdrop;
    ImageView mPoster;
    ImageView mTrailer;
    FloatingActionButton mFab;
    boolean flag = true; // true clicked/added to favorites, false not clicked.
    Integer movieId;
    Integer key;

    private TrailerAdapter tAdapter;

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
        mTrailer = findViewById(R.id.iv_Trailer);

        myTitle = getIntent().getExtras().getString("title", "defaultkey");
        myVotes = getIntent().getDoubleExtra("votes", 0.0);
        myDate = getIntent().getExtras().getString("date", "defaultkey");
        myOverview = getIntent().getExtras().getString("overview", "defaultkey");
        myBackdrop = getIntent().getExtras().getString("backdrop", "defaultkey");
        myPoster = getIntent().getExtras().getString("poster", "defaultkey");
        myTrailer = key;

        //get just the year from the date string 0=year - 1=month - 2=date
        String input = myDate;
        String[] out = input.split("-");


        mVotes.setText(valueOf(myVotes));
        mDate.setText(out[0]);
        mOverview.setText(myOverview);
        getSupportActionBar().setTitle(myTitle);

        //RecyclerView - need to adjust code to fit detailView
        RecyclerView tRecyclerView = findViewById(R.id.rv_Trailers);
        tRecyclerView.setHasFixedSize(true);


        tRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tAdapter = new TrailerAdapter(this);
        tRecyclerView.setAdapter(tAdapter);

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

                if (flag) {
                    // need to figure out how to set the ripple on and off click - future plans for app leaving code here for reference
                    //mFab.setRippleColor(getResources().getColor(R.color.floating_action_button_color));
                    mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff8800")));
                    flag = false;
                    Toast.makeText(DetailActivity.this, "Added to favorites", Toast.LENGTH_LONG).show();

                } else if (!flag) {
                    // mFab.setRippleColor(getResources().getColor(R.color.floating_action_button_color));
                    mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#424242")));
                    flag = true;
                    Toast.makeText(DetailActivity.this, "Removed from favorites", Toast.LENGTH_LONG).show();

                }

            }

        });


        getTrailers();




    }

    public static class TrailerViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public TrailerViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_Trailer);
        }
    }

    private void getTrailers() {
        // retrofit call to load trailers and reviews

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        //this call creates the retrofit object and passes in the ApiIntrerface into the myInterface object
        TrailerInterface trailerInterface = retrofit.create(TrailerInterface.class);



        Call<TrailerResults> call = trailerInterface.getTrailers(valueOf(movieId),
                getString(R.string.api_key),
                getString(R.string.language));

        if (call != null) {
            call.enqueue(new Callback<TrailerResults>() {
                @Override
                public void onResponse(@NonNull Call<TrailerResults> call, @NonNull Response<TrailerResults> response) {

                    //results is the name of the inner list in the MovieResults json querry
                    TrailerResults results = response.body();

                    //This gets the list of Movie Results
                    List<TrailerResults.ResultsBean> listOfTrailers = null;
                    if (results != null) {
                        listOfTrailers = results.getResults();
                    }

                    if (listOfTrailers != null) {
                        tAdapter.setTrailers(listOfTrailers);
                        tAdapter.notifyDataSetChanged();
                    }


                }

                @Override
                public void onFailure(Call<TrailerResults> call, Throwable t) {
                    t.printStackTrace();

                }


            });
        }

    }
}


