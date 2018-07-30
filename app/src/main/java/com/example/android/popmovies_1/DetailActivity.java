package com.example.android.popmovies_1;

//test

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
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

import com.example.android.popmovies_1.database.AppExecutors;
import com.example.android.popmovies_1.database.FavoriteViewModel;
import com.example.android.popmovies_1.database.FavoriteViewModelFactory;
import com.example.android.popmovies_1.database.FavoritesDatabase;
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
    Boolean myFavorite;
    TextView mVotes;
    TextView mDate;
    TextView mOverview;
    ImageView mBackdrop;
    ImageView mPoster;
    ImageView mTrailer;
    boolean flag;
    Integer movieId;
    private TrailerAdapter tAdapter;
    private ReviewAdapter rAdapter;

    private FavoritesDatabase mDb;


    public FloatingActionButton mFab;

    private View.OnClickListener mFabListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            mFabClicked(flag = true);


        }
    };

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mFab = new FloatingActionButton(this);
        mFab = findViewById(R.id.myFAB);
        mFab.setOnClickListener(mFabListener);


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
        myFavorite = getIntent().getExtras().getBoolean( "favorite",false);


        Log.d("myFavorite", "myFavorite="+myFavorite);

        //initialize member variable for the database
        mDb = FavoritesDatabase.getInstance(getApplicationContext());


        //calls to retrieve trailers and reviews
        getTrailers();
        getReviews();

        //get just the year from the date string 0=year - 1=month - 2=date
        String input = myDate;
        String[] out = input.split("-");

        mDate.setText(out[0]);

        mVotes.setText(valueOf(myVotes));

        mOverview.setText(myOverview);

        //set Title in action bar to Movie title
        getSupportActionBar().setTitle(myTitle);

        // Use SpannableStringBuilder to make the first letter of the Overview larger than the rest of the text
        final SpannableStringBuilder sb = new SpannableStringBuilder(myOverview);
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        sb.setSpan(new RelativeSizeSpan(1.3f), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mOverview.setText(sb);

        //RecyclerView - Trailers
        RecyclerView tRecyclerView = findViewById(R.id.rv_Trailers);
        tRecyclerView.setHasFixedSize(true);
        tRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        tAdapter = new TrailerAdapter(this);
        tRecyclerView.setAdapter(tAdapter);

        //RecyclerView - reviews
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
        //Check if movie is favorite
        checkIfFavorite();
    }



    // Method used to set buttons state - this
    private void mFabClicked(boolean flag) {
        this.flag = flag;

        final MovieResults.ResultsBean resultsBean = new MovieResults.ResultsBean(movieId, myVotes, myTitle, myPoster, myBackdrop, myOverview, myDate, myFavorite);


        if (flag){
            myFavorite = true;
            this.mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff8800")));
            Toast.makeText(DetailActivity.this, "Added to favorites", Toast.LENGTH_LONG).show();

            //add movie to favorites database

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    mDb.favoritesDao().insertMovie(resultsBean);

                }
            });

        } else {
            myFavorite = false;
            // mFab.setRippleColor(getResources().getColor(R.color.floating_action_button_color));
            this.mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#424242")));
            Toast.makeText(DetailActivity.this, "Removed from favorites", Toast.LENGTH_LONG).show();

            //remove movie from favorites database

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    mDb.favoritesDao().deleteMovie(resultsBean);

                }
            });


        }

    }

// call defaults to adding every movie when detailactivity is opened
    private void checkIfFavorite() {


        //get instances of the factory and viewModel
        if (movieId != null) {
            FavoriteViewModelFactory factory =
                    new FavoriteViewModelFactory(mDb, movieId);

            FavoriteViewModel viewModel = ViewModelProviders.of(this, factory).get(FavoriteViewModel.class);
            // if the query returns and is not null
            Log.d("ViewModel", "ViewModel=" + viewModel.getFavorite(movieId));

            if (viewModel.getFavorite(movieId) != null) {
                // if null set the fab to grey and flag to true
                this.mFab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff8800")));
                mFabClicked(flag = true);
            }
        }
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

                    //results is the name of the inner list in the MovieResults json query
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
        // retrofit call to load reviews

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        //this call creates the retrofit object and passes in the ApiIntrerface into the reviewInterface object
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


