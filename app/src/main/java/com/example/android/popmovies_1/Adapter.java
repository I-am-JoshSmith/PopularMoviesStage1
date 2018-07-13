package com.example.android.popmovies_1;
// so this is Room
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<MainActivity.MovieViewHolder> {



    private static List<MovieResults.ResultsBean> mMovieList;
    private LayoutInflater mInflater;
    private final Context mContext;

    public Adapter(Context context)
    {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);

    }

    public static List<MovieResults.ResultsBean> getMovieList(List<MovieResults.ResultsBean> favorites) {
        return mMovieList;
    }

    @Override
    public MainActivity.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(R.layout.poster_list_item, parent, false);
        MainActivity.MovieViewHolder viewHolder = new MainActivity.MovieViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MainActivity.MovieViewHolder holder, final int position) {
        final MovieResults.ResultsBean movie = mMovieList.get(position);

            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("title",movie.getTitle());
                    intent.putExtra("votes",movie.getVote_average());
                    intent.putExtra("date",movie.getRelease_date());
                    intent.putExtra("overview",movie.getOverview());
                    intent.putExtra("backdrop",movie.getBackdrop_path());
                    intent.putExtra("poster",movie.getPoster_path());
                    intent.putExtra("movieId",movie.getId());
                    mContext.startActivity(intent);


                }
            });


        Picasso.get()
                .load("http://image.tmdb.org/t/p/w185/" + movie.getPoster_path())
                .placeholder(R.color.colorPrimaryDark)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount()
    {
        return (mMovieList == null) ? 0 : mMovieList.size();
    }

    public void setMovies(List<MovieResults.ResultsBean> movieList){
        mMovieList = movieList;
    }


}
