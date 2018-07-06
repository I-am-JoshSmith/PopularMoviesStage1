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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<DetailActivity.ReviewViewHolder> {

    private List<ReviewResults.ResultsBean> rMovieList;
    private LayoutInflater rInflater;
    private final Context rContext;



    public ReviewAdapter(Context context)
    {
        this.rContext = context;
        this.rInflater = LayoutInflater.from(context);

    }

    @Override
    public DetailActivity.ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = rInflater.inflate(R.layout.review_list_item, parent, false);
        DetailActivity.ReviewViewHolder viewHolder = new DetailActivity.ReviewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DetailActivity.ReviewViewHolder holder, int position) {
        final ReviewResults.ResultsBean review = rMovieList.get(position);

        holder.myAuthor = review.getAuthor();
        holder.myContent = review.getContent();
        holder.myWebsite = review.getUrl();







        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/watch?v="));
                intent.setPackage("com.google.android.youtube");
                intent.putExtra("force_fullscreen",true);
                rContext.startActivity(intent);

                intent.setComponent(new ComponentName("com.google.android.youtube","com.google.android.youtube.PlayerActivity"));
                PackageManager manager = rContext.getPackageManager();
                Toast.makeText(rContext, "Press back button when finished", Toast.LENGTH_LONG).show();
                List<ResolveInfo> infos = manager.queryIntentActivities(intent, 0);
                if (infos.size() > 0) {
                    rContext.startActivity(intent);
                }else{
                    //No Application can handle your intent
                }




            }
        });

    }



    @Override
    public int getItemCount()
    {
        return (rMovieList == null) ? 0 : rMovieList.size();
    }

    public void setReviews(List<ReviewResults.ResultsBean> reviewList){
        rMovieList = reviewList;
    }

}

