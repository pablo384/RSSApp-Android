package com.example.faustino.rssprueba;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.w3c.dom.Document;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
//import android.support.v4.content.AsyncTaskLoader;

/**
 * Created by faustino on 20/07/17.
 */

public class ReedRss extends AsyncTask<Void, Void, Void> {

    Context context;
    String addRess = R.string.Rss1;
    ProgressDialog progressDialog;
    URL url;

    public ReedRss(Context context) {
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("loading...");
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressDialog.show();
        super.onPostExecute(aVoid);
    }

    @Override
    protected Void doInBackground(Void... params) {
        processXml(GetData());
        return null;
    }

    private void processXml(Document data) {
        if (data != null) {
            Log.d("root", data.getDocumentElement().getNodeName());
        }
    }

    public Document GetData() {
        try {

            url = new URL(addRess);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document xmlDoc = builder.parse(inputStream);
            return xmlDoc;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
