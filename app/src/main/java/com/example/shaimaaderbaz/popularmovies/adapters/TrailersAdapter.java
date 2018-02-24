package com.example.shaimaaderbaz.popularmovies.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shaimaaderbaz.popularmovies.R;
import com.example.shaimaaderbaz.popularmovies.models.PopularResults;
import com.example.shaimaaderbaz.popularmovies.models.TrailerResults;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 2/23/2018.
 */

public class TrailersAdapter extends  RecyclerView.Adapter<TrailersAdapter.ViewHolder> {
    private List<TrailerResults> mItems;
    private Context mContext;
    private TrailersAdapter.PostItemListener mItemListener;
    final String VIDEO_SOURCE="http://image.tmdb.org/t/p/w185";

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView trailer;

        TrailersAdapter.PostItemListener mItemListener;

        public ViewHolder(View itemView, TrailersAdapter.PostItemListener postItemListener) {
            super(itemView);
            trailer = (TextView) itemView.findViewById(R.id.trailer_text_view);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            TrailerResults item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item);

            notifyDataSetChanged();
        }
    }

    public TrailersAdapter(Context context,List<TrailerResults> posts, TrailersAdapter.PostItemListener itemListener) {
        mItems = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public TrailersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.trailer_list_item, parent, false);

        TrailersAdapter.ViewHolder viewHolder = new TrailersAdapter.ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TrailersAdapter.ViewHolder holder, int position)
    {

        TrailerResults item = mItems.get(position);
        TextView textViewRate = holder.trailer;
        textViewRate.setText(VIDEO_SOURCE+item.getTrailer_key());



    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateTrailers(List<TrailerResults> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private TrailerResults getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(TrailerResults item);
    }

}
