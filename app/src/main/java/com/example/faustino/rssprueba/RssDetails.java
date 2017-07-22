package com.example.faustino.rssprueba;

//import android.content.Context;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;

//import static com.example.faustino.rssprueba.MainActivity.FEED_URL;

public class RssDetails extends AppCompatActivity {
    //ListView feedlistview = (ListView) findViewById(R.id.my_list);
    ListView lstOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssdetails);

        final String[] datos =
                new String[]{"Pablo1","Elem2","Elem3","Elem4","Elem5"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datos);
        lstOpciones = (ListView)findViewById(R.id.LstOpciones);




        String url = "https://www.diariolibre.com/rss/portada.xml"; //(String) getIntent().getExtras().get(FEED_URL);
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
        parser.execute(url);
    }



}
