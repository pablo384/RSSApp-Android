package com.example.faustino.rssprueba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDL, btnLD, BtnNac;

   public static final String FEED_URL = "feed_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDL = (Button) findViewById(R.id.buttonRSSDL);
        btnLD = (Button) findViewById(R.id.buttonRSSLD);
        BtnNac = (Button) findViewById(R.id.rssEN);

        btnDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RssDetails.class);
                intent.putExtra(FEED_URL, getResources().getString(R.string.URLRss1));
                startActivity(intent);
            }
        });


        btnLD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RssDetails.class);
                intent.putExtra(FEED_URL, getResources().getString(R.string.URLRss2));
                startActivity(intent);
            }
        });


        BtnNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RssDetails.class);
                //intent.putExtra(FEED_URL, R.string.Rss3);
                intent.putExtra(FEED_URL, getResources().getString(R.string.URLRss3));
                startActivity(intent);
            }
        });

    }
}
