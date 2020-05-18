package com.example.usingwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting reference to WebView in Layout
        WebView webView = findViewById(R.id.webView);

        //enabling the javascript
        WebSettings webSet = webView.getSettings();
        webSet.setJavaScriptEnabled(true);

        //adding interface to establish communication between JavaScript code and Android app code
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");

        //getting the string of html tags
        String data = readTextFromResource(R.raw.test_2);

        //loading html data from the string
        webView.loadData(data, "text/html", "utf-8");

        //if your web app is on the internet just provide the link
        //webView.loadUrl("https://www.google.com");
    }

    //REF: http://www.monocube.com/2011/02/08/android-tutorial-html-file-in-webview/
    //read the html file in the raw folder in res folder of app (app/res/raw/....)
    private String readTextFromResource(int resourceID) {
        InputStream raw = getResources().openRawResource(resourceID);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        int i;
        try {
            i = raw.read();
            while (i != -1) {
                stream.write(i);
                i = raw.read();
            }
            raw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream.toString();
    }

}
