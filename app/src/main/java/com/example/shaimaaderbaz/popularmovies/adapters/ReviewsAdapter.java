package com.example.shaimaaderbaz.popularmovies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shaimaaderbaz.popularmovies.R;
import com.example.shaimaaderbaz.popularmovies.models.ReviewsResults;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 2/23/2018.
 */

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder>{

    private List<ReviewsResults> mItems;

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView author;
        public TextView content;


        public ViewHolder(View itemView)
        {
            super(itemView);
            author = (TextView) itemView.findViewById(R.id.review_author_text_view);
            content = (TextView) itemView.findViewById(R.id.review_content_text_view);

        }

    }

    public ReviewsAdapter(List<ReviewsResults> reviews)
    {
        mItems = reviews;

    }

    @Override
    public ReviewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.review_list_item, parent, false);

        ReviewsAdapter.ViewHolder viewHolder = new ReviewsAdapter.ViewHolder(postView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReviewsAdapter.ViewHolder holder, int position)
    {

        ReviewsResults item = mItems.get(position);
        TextView textViewAuthor = holder.author;
        textViewAuthor.setText(item.getAuthor()+"");
        TextView textViewContent = holder.content;
        textViewContent.setText(item.getContent()+"");

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateReviews(List<ReviewsResults> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private ReviewsResults getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }



}
