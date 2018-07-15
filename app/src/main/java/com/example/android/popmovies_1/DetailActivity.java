package com.example.android.popmovies_1;
//Test

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Database;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
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

    private Adapter aAdaptor;
    private TrailerAdapter tAdapter;
    private ReviewAdapter rAdapter;

    private FavoritesDatabase mDb;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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
        movieId = getIntent().getExtras().getInt("movieId", 0);


        // initialize member variable for the database
        mDb = FavoritesDatabase.getInstance(getApplicationContext());

        //get just the year from the date string 0=year - 1=month - 2=date
        String input = myDate;
        String[] out = input.split("-");


        mVotes.setText(valueOf(myVotes));
        mDate.setText(out[0]);
        mOverview.setText(myOverview);
        getSupportActionBar().setTitle(myTitle);

        final SpannableStringBuilder sb = new SpannableStringBuilder(myOverview);
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        sb.setSpan(new RelativeSizeSpan(1.3f), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //sb.setSpan(bss, 0, 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mOverview.setText(sb);

        //RecyclerView - Trailers
        //
        RecyclerView tRecyclerView = findViewById(R.id.rv_Trailers);
        tRecyclerView.setHasFixedSize(true);


        tRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        tAdapter = new TrailerAdapter(this);
        tRecyclerView.setAdapter(tAdapter);

        //RecyclerView - reviews
        //
        RecyclerView rRecyclerView = findViewById(R.id.rv_Reviews);
        rRecyclerView.setHasFixedSize(true);
        rRecyclerView.setNestedScrollingEnabled(false);

        rRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        rAdapter = new ReviewAdapter(this);
        rRecyclerView.setAdapter(rAdapter);

        // Picasso load backdrop and movie poster
        Picasso.get()
                .load("http://image.tmdb.org/t/p/w300/" + myBackdrop)
                .placeholder(R.color.colorPrimaryDark)
                .into(mBackdrop);

        Picasso.get()
                .load("http://image.tmdb.org/t/p/w185/" + myPoster)
                .placeholder(R.color.colorPrimaryDark)
                .into(mPoster);


        mFab = findViewById(R.id.myFAB);

        mFab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                final MovieResults.ResultsBean resultsBean = new MovieResults.ResultsBean(movieId, myVotes, myTitle, myPoster, myBackdrop, myOverview, myDate);

                /*
                 // NEED TO FIGURE OUT HOW TO CHECK IF MOVIE IS PART OF THE FAVORITES LIST AND IF SO SET THE FLAG TO TRUE
                MainViewModel viewModel = ViewModelProviders.of(DetailActivity.this).get(MainViewModel.class);
                viewModel.getFavorites().observe(DetailActivity.this, new Observer<List<MovieResults.ResultsBean>>() {

                    @Override
                    public void onChanged(@Nullable List<MovieResults.ResultsBean> resultsBeans) {
                        if (resultsBean.getId() == movieId) {
                            mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff8800")));
                            flag = false;
                        }
                    }
                });

*/

                if (flag) {

                    mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff8800")));
                    flag = false;
                    Toast.makeText(DetailActivity.this, "Added to favorites", Toast.LENGTH_LONG).show();

                    //add movie to favorites database

                    AppExecutors.getInstance().diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            mDb.favoritesDao().insertMovie(resultsBean);

                        }
                    });



                } else if (!flag) {
                    // mFab.setRippleColor(getResources().getColor(R.color.floating_action_button_color));
                    mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#424242")));
                    flag = true;
                    Toast.makeText(DetailActivity.this, "Removed from favorites", Toast.LENGTH_LONG).show();

                    //remove movie from favorites
                    AppExecutors.getInstance().diskIO().execute(new Runnable() {
                        @Override
                        public void run() {

                            //int mId = DetailActivity.this.movieId;
                            //final List<MovieResults.ResultsBean> resultsBean = Adapter.getMovieList();
                            mDb.favoritesDao().deleteMovie(resultsBean);
                        }
                    });

                }

            }

        });



        getTrailers();
        getReviews();



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


    public static class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView mAuthorTextView;
        TextView mContentTextView;
        TextView mWebsiteTextView;


        public ReviewViewHolder(View itemView) {
            super(itemView);
            mAuthorTextView = itemView.findViewById(R.id.tv_author);
            mContentTextView = itemView.findViewById(R.id.tv_content);
            mWebsiteTextView = itemView.findViewById(R.id.tv_website);


        }
    }

    private void getReviews() {
        // retrofit call to load trailers and reviews

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        //this call creates the retrofit object and passes in the ApiIntrerface into the myInterface object
        ReviewInterface reviewInterface = retrofit.create(ReviewInterface.class);



        Call<ReviewResults> call = reviewInterface.getReviews(valueOf(movieId),
                getString(R.string.api_key),
                getString(R.string.language));

        if (call != null) {
            call.enqueue(new Callback<ReviewResults>() {
                @Override
                public void onResponse(@NonNull Call<ReviewResults> call, @NonNull Response<ReviewResults> response) {

                    //results is the name of the inner list in the MovieResults json querry
                    ReviewResults results = response.body();

                    //This gets the list of Movie Results
                    List<ReviewResults.ResultsBean> listOfReviews = null;
                    if (results != null) {
                        listOfReviews = results.getResults();
                    }

                    if (listOfReviews != null) {
                        rAdapter.setReviews(listOfReviews);
                        rAdapter.notifyDataSetChanged();

                    }


                }

                @Override
                public void onFailure(Call<ReviewResults> call, Throwable t) {
                    t.printStackTrace();

                }


            });
        }

    }

}


