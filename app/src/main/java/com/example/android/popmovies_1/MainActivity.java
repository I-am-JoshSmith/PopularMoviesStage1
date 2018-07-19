package com.example.android.popmovies_1;

//test1

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.android.popmovies_1.database.FavoritesDatabase;
import com.example.android.popmovies_1.database.MainViewModel;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    public String category;


    private static final String MOVIE_TYPE_TOP_RATED = "Top Rated";
    private static final String MOVIE_TYPE_POPULAR = "Most Popular";
    private static final String MOVIE_TYPE_FAVORITES = "Favorites";


    private FavoritesDatabase mDb;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_Posters);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mAdapter = new Adapter(this);
        mRecyclerView.setAdapter(mAdapter);

        mDb = FavoritesDatabase.getInstance((getApplicationContext()));




    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_Poster);
        }
    }

    // Spinner to select display category (Top Rated, Most Popular, Favorites)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        final Spinner spinner = (Spinner) item.getActionView();

        List<String> catagories = new ArrayList<String>();
        catagories.add(MOVIE_TYPE_POPULAR);
        catagories.add(MOVIE_TYPE_TOP_RATED);
        catagories.add(MOVIE_TYPE_FAVORITES);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, catagories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        //trying to get the spinners value
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {


                updateCategory(spinner);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                updateCategory(spinner);

            }
        });
        return true;

    }


    //method to update category with selected item from spinner

    private String updateCategory(AdapterView spinner) {
        category = spinner.getSelectedItem().toString();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface myInterface = retrofit.create(ApiInterface.class);


        Call<MovieResults> call = null;

        switch (spinner.getSelectedItem().toString()){
            case (MOVIE_TYPE_POPULAR):
                call = myInterface.getMovies(getString(R.string.spinner_popular_value),
                        getString(R.string.api_key),
                        getString(R.string.language),
                        1);
                Log.d("Category", "cat:" + MOVIE_TYPE_POPULAR);
                break;
            case (MOVIE_TYPE_TOP_RATED):
                call = myInterface.getMovies(getString(R.string.spinner_top_rated_value),
                        getString(R.string.api_key),
                        getString(R.string.language),
                        1);
                break;
            case (MOVIE_TYPE_FAVORITES):

                returnViewModel();


                Log.d("Category", "cat:" + MOVIE_TYPE_TOP_RATED);

                break;

        }
        if (call != null){
        call.enqueue(new Callback<MovieResults>() {
                         @Override
                         public void onResponse(@NonNull Call<MovieResults> call, @NonNull Response<MovieResults> response) {

                             //results is the name of the inner list in the MovieResults json querry
                             MovieResults results = response.body();

                             //This gets the list of Movie Results
                             List<MovieResults.ResultsBean> listOfMovies = null;
                             if (results != null) {
                                 listOfMovies = results.getResults();
                             }

                             if (listOfMovies != null) {
                                 mRecyclerView.removeAllViews();
                                 mAdapter.setMovies(listOfMovies);
                                 mAdapter.notifyDataSetChanged();

                             }


                         }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                t.printStackTrace();

            }

    });


    }


        return null;
    }
// Attempt at getting ViewModel/LiveData to populate the recyclerView when the Favorites Spinner is selected
    private void returnViewModel() {


            final MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
            viewModel.getFavorites().observe(MainActivity.this, new Observer<List<MovieResults.ResultsBean>>() {

                @Override
                public void onChanged(@Nullable List<MovieResults.ResultsBean> resultsBeans) {
                    Log.d("LiveData", "Recieving databasr update from LiveData in ViewModel");


                    mRecyclerView.removeAllViews();
                    mAdapter.setMovies(resultsBeans);
                    mAdapter.notifyDataSetChanged();

                }


            });

    }


    }



