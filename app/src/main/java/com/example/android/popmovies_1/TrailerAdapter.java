package com.example.android.popmovies_1;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Grimlock on 7/4/18.
 */

public class TrailerAdapter extends RecyclerView.Adapter<DetailActivity.TrailerViewHolder> {

        private List<TrailerResults.ResultsBean> tMovieList;
        private LayoutInflater tInflater;
        private final Context tContext;

    public TrailerAdapter(Context context)
        {
            this.tContext = context;
            this.tInflater = LayoutInflater.from(context);

        }

        @Override
        public DetailActivity.TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = tInflater.inflate(R.layout.trailer_list_item, parent, false);
            DetailActivity.TrailerViewHolder viewHolder = new DetailActivity.TrailerViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(DetailActivity.TrailerViewHolder holder, int position) {
            final TrailerResults.ResultsBean trailer = tMovieList.get(position);


//on click listener needs to launch youtube video
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.youtube.com/watch?v="+trailer.getKey()));
                    intent.setPackage("com.google.android.youtube");
                    tContext.startActivity(intent);

                    intent.setComponent(new ComponentName("com.google.android.youtube","com.google.android.youtube.PlayerActivity"));
                    PackageManager manager = tContext.getPackageManager();
                    List<ResolveInfo> infos = manager.queryIntentActivities(intent, 0);
                    if (infos.size() > 0) {
                        tContext.startActivity(intent);
                    }else{
                        //No Application can handle your intent
                    }

                    //http://www.youtube.com/watch?v=t7UxjpUaL3Y

                    //CODE HERE TO LAUNCH CORESPONDING YOUTUBE VIDEO IN AP



                }
            });

            Picasso.get()
                    .load("http://img.youtube.com/vi/" + trailer.getKey() + "/0.jpg")
                    .placeholder(R.color.colorPrimaryDark)
                    .into(holder.imageView);
            Log.d("KEY", "KEy-" + trailer.getKey());
        }

        @Override
        public int getItemCount()
        {
            return (tMovieList == null) ? 0 : tMovieList.size();
        }

        public void setTrailers(List<TrailerResults.ResultsBean> trailerList){
            tMovieList = trailerList;
        }

    }

