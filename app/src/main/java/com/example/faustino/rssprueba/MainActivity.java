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
        btnDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RssDetails.class);
                intent.putExtra(FEED_URL, R.string.Rss1);
                startActivity(intent);
            }
        });

        btnLD = (Button) findViewById(R.id.buttonRSSLD);
        btnLD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RssDetails.class);
                intent.putExtra(FEED_URL, R.string.Rss2);
                startActivity(intent);
            }
        });

        BtnNac = (Button) findViewById(R.id.rssEN);
        BtnNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RssDetails.class);
                intent.putExtra(FEED_URL, R.string.Rss3);
                startActivity(intent);
            }
        });

    }
}
