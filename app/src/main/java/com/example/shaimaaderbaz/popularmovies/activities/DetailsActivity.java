package com.example.shaimaaderbaz.popularmovies.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shaimaaderbaz.popularmovies.R;
import com.example.shaimaaderbaz.popularmovies.adapters.ReviewsAdapter;
import com.example.shaimaaderbaz.popularmovies.models.BaseReviewsResult;
import com.example.shaimaaderbaz.popularmovies.models.PopularResults;
import com.example.shaimaaderbaz.popularmovies.models.ReviewsResults;
import com.example.shaimaaderbaz.popularmovies.utils.SOService;
import com.example.shaimaaderbaz.popularmovies.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {
    ReviewsAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SOService mService;
    PopularResults item ;
    final String IMAGE_SOURCE="http://image.tmdb.org/t/p/w185";
    public void loadReviews(long movie_id) {
        mService.getReviews(movie_id).enqueue(new Callback<BaseReviewsResult>() {
            @Override
            public void onResponse(Call<BaseReviewsResult> call, Response<BaseReviewsResult> response) {

                if(response.isSuccessful()) {
                    mAdapter.updateReviews(response.body().getResults());
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    Log.d("MainActivity", statusCode+"");

                }
            }

            @Override
            public void onFailure(Call<BaseReviewsResult> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            item = extras.getParcelable("item");
        }
        ImageView imageViewPoster = (ImageView)findViewById(R.id.poster_details_text_view);
        String imagePoster=IMAGE_SOURCE+item.getPoster_path();
        Picasso.with(this).load(imagePoster).resize(900,900).into(imageViewPoster);
        TextView textViewTitle =(TextView)findViewById(R.id.title_details_text_view) ;
        textViewTitle.setText(item.getTitle()+"");
        TextView textViewRate =(TextView)findViewById(R.id.rate_details_text_view);
        textViewRate.setText(item.getVote_average()+" /10 ");
        TextView textViewDate =(TextView)findViewById(R.id.date_text_view);
        textViewDate.setText(item.getRelease_date()+"");
        TextView textViewLang =(TextView)findViewById(R.id.lang_text_view);
        textViewLang.setText(item.getOriginal_language()+"");
        TextView over=(TextView)findViewById(R.id.overview_text_view);
        over.setText(item.getOverview());

        mService = Utils.getSOService();
        mRecyclerView = (RecyclerView) findViewById(R.id.rev_recycler_view);
        mAdapter = new ReviewsAdapter(new ArrayList<ReviewsResults>());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        loadReviews(item.getMovie_id());

    }
}
