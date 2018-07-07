package com.example.android.popmovies_1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
/*TODO Need to figure out how to implement this to underline the web adress
        SpannableString content = new SpannableString(holder.mWebsiteTextView.toString());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
       */

        holder.mAuthorTextView.setText(review.getAuthor());
        holder.mContentTextView.setText(review.getContent());
        holder.mWebsiteTextView.setText(review.getUrl());

        holder.mWebsiteTextView.setPaintFlags(holder.mWebsiteTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        holder.mWebsiteTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = review.getUrl();

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                rContext.startActivity(i);
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

