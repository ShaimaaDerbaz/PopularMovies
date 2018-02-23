package com.example.shaimaaderbaz.popularmovies.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.shaimaaderbaz.popularmovies.R;
import com.example.shaimaaderbaz.popularmovies.adapters.PopularMoviesAdapter;
import com.example.shaimaaderbaz.popularmovies.models.BaseResponseResult;
import com.example.shaimaaderbaz.popularmovies.models.PopularResults;
import com.example.shaimaaderbaz.popularmovies.utils.SOService;
import com.example.shaimaaderbaz.popularmovies.utils.Utils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    PopularMoviesAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SOService mService;
    public void loadAnswers() {
        mService.getMovies().enqueue(new Callback<BaseResponseResult>() {
            @Override
            public void onResponse(Call<BaseResponseResult> call, Response<BaseResponseResult> response) {

                if(response.isSuccessful()) {
                    mAdapter.updateMovies(response.body().getResults());
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    Log.d("MainActivity", statusCode+"");

                }
            }

            @Override
            public void onFailure(Call<BaseResponseResult> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService = Utils.getSOService();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mAdapter = new PopularMoviesAdapter(this,new ArrayList<PopularResults>(), new PopularMoviesAdapter.PostItemListener() {
            @Override
            public void onPostClick(PopularResults item) {
                Intent i =new Intent(MainActivity.this,DetailsActivity.class);
                i.putExtra("overview",item.getOverview());
                startActivity(i);
             //   Toast.makeText(MainActivity.this, "Post id is" + PositoionId, Toast.LENGTH_SHORT).show();
            }

        });

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        loadAnswers();



    }



}
