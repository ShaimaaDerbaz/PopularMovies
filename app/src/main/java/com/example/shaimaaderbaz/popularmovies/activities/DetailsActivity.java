package com.example.shaimaaderbaz.popularmovies.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shaimaaderbaz.popularmovies.R;

public class DetailsActivity extends AppCompatActivity {
   String overview ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            overview = extras.getString("overview");
        }
        TextView over=(TextView)findViewById(R.id.over);
        over.setText(overview);
    }
}
