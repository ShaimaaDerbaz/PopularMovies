package com.example.shaimaaderbaz.popularmovies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shaimaaderbaz.popularmovies.R;
import com.example.shaimaaderbaz.popularmovies.models.PopularResults;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 2/3/2018.
 */

public class PopularMoviesAdapter extends  RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder> {
    private List<PopularResults> mItems;
    private Context mContext;
    private PostItemListener mItemListener;
    final String IMAGE_SOURCE="http://image.tmdb.org/t/p/w185";

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public ImageView poster;
        public TextView title;
        public TextView rating;

        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener)
        {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.item_poster_image_view);
            title = (TextView) itemView.findViewById(R.id.item_title_text_view);
            rating = (TextView) itemView.findViewById(R.id.item_rating_text_view);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            PopularResults item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item);

            notifyDataSetChanged();
        }
    }

    public PopularMoviesAdapter(Context context,List<PopularResults> posts, PostItemListener itemListener) {
        mItems = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public PopularMoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.list_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PopularMoviesAdapter.ViewHolder holder, int position)
    {

        PopularResults item = mItems.get(position);
        ImageView imageViewPoster = holder.poster;
        String imagePoster=IMAGE_SOURCE+item.getPoster_path();
        Picasso.with(mContext).load(imagePoster).resize(600,900).into(imageViewPoster);
        TextView textViewTitle = holder.title;
        textViewTitle.setText(item.getTitle()+"");
        TextView textViewRate = holder.rating;
        textViewRate.setText(item.getVote_average()+"");



    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateMovies(List<PopularResults> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private PopularResults getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(PopularResults item);
    }

///////////////////////////////////////////////



}
