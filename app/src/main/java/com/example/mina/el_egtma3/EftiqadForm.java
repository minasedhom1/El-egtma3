package com.example.mina.el_egtma3;

import android.graphics.Bitmap;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class EftiqadForm extends AppCompatActivity {
  ProgressBar progressBar;
    Button refresh_form_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eftiqad_form);
        refresh_form_btn= (Button) findViewById(R.id.refresh_form_btn);
        progressBar= (ProgressBar) findViewById(R.id.progress_bar);
        final WebView myWebView = (WebView) findViewById(R.id.form_wv);

        refresh_form_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdvyxDACjKSr15XuK8gyidQjWkrzkb2p1oRil5cPW5p4o8v9A/viewform");

            }
        });


        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient()
        {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);

            }
        }
    );
      myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdvyxDACjKSr15XuK8gyidQjWkrzkb2p1oRil5cPW5p4o8v9A/viewform");

    }

}
