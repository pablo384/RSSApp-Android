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

import static com.example.faustino.rssprueba.MainActivity.FEED_URL;

public class RssDetails extends AppCompatActivity {
    ListView feedlistview = (ListView) findViewById(R.id.my_list);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssdetails);


        String url = (String) getIntent().getExtras().get(FEED_URL);
        Parser parser = new Parser();
        parser.onFinish(new Parser.OnTaskCompleted() {
            @Override
            public void onTaskCompleted(ArrayList<Article> list) {
                feedlistview.setAdapter(new FeedAdapter(list));
            }

            @Override
            public void onError() {

            }
        });
        parser.execute(url);
    }

    public class FeedAdapter extends ArrayAdapter<Article> {

        public FeedAdapter(@NonNull List<Article> Objects) {
            this(RssDetails.this, 0, Objects);
        }

        public FeedAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Article> object) {
            super(context, resource, object);
        }

//        public View getView() {
//            View view =
//            return view;
//        }

    }

}
