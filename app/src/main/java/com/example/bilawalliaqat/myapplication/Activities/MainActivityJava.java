package com.example.bilawalliaqat.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SeekBar;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bilawalliaqat.myapplication.R;

/**
 * Created by bilawalliaqat on 06/12/2017.
 */

public class MainActivityJava extends AppCompatActivity {
    WebView webview;
    String local_url = "file:///android_asset/top_books.htm";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  webview = (WebView) findViewById(R.id.webView);
      //  webview.loadUrl(local_url);
     //   webview.getSettings().setJavaScriptEnabled(true);
     //   webview.setWebViewClient(new WebViewClient());


    }


    @Override
    public void onBackPressed(){

        if (webview.canGoBack()){

            webview.goBack();
        }
        else {
            finish();
        }
    }





}
