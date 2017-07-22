package com.example.faustino.rssprueba;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.prof.rssparser.Article;

import java.util.List;

/**
 * Created by pablo384 on 21/07/17.
 */

public class FeedAdapter extends ArrayAdapter<Article> {
    List<Article> datos;

    public FeedAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Article> datos) {
        super(context, resource, datos);
        this.datos=datos;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_titular, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(datos.get(position).getTitle());

        return(item);
    }

}
