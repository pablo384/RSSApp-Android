package com.example.faustino.rssprueba;

//import android.content.Context;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;

import static com.example.faustino.rssprueba.MainActivity.FEED_URL;

public class RssDetails extends AppCompatActivity {
    //ListView feedlistview = (ListView) findViewById(R.id.my_list);
    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssdetails);

        lstOpciones = (ListView)findViewById(R.id.LstOpciones);




        String url = getIntent().getStringExtra(FEED_URL);
        Parser parser = new Parser();
        parser.onFinish(new Parser.OnTaskCompleted() {
            @Override
            public void onTaskCompleted(ArrayList<Article> list) {
                lstOpciones.setAdapter(new FeedAdapter(RssDetails.this,R.layout.listitem_titular,list));
            }

            @Override
            public void onError() {

            }
        });
        try{
            parser.execute(url);
        }catch (Exception e){
            Log.d(FEED_URL, "Error en Asing task");
            e.printStackTrace();
        }

    }



}
