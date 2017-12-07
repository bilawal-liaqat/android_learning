package com.example.bilawalliaqat.myapplication;

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

/**
 * Created by bilawalliaqat on 06/12/2017.
 */

public class MainActivityJava extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webview = (WebView) findViewById(R.id.webView);
        webview.loadUrl("http://www.google.com");
        webview.getSettings().getJavaScriptEnabled();
        webview.setWebViewClient(new WebViewClient());


    }






}
