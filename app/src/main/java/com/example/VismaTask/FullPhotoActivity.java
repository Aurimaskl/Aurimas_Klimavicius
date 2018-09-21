package com.example.VismaTask;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class FullPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_photo);
        //back button implementation
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Closer look at puppy");
        //with intent data is extracted that is in MainActivity
        Intent intent = getIntent();
        //the image goes to imageview
        ImageView img = (ImageView) findViewById(R.id.fullIV);
        //load (from download link) to (corresponding imageview)
        if (intent.getStringExtra("Link") != null) {
            Picasso.with(this).load(intent.getStringExtra("Link")).into(img);
        }
    }
}
