package com.example.kotlin_news

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class web_View : AppCompatActivity() {

    lateinit var webView: WebView
        @SuppressLint("SetJavaScriptEnabled")
        @RequiresApi(Build.VERSION_CODES.O)
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

            webView=findViewById(R.id.webView)

            val intent:Intent= getIntent();
            val url = intent.getStringExtra("url")
            webView.webViewClient = WebViewClient()
            if (url != null) {
                webView.loadUrl(url)
            }
            webView.settings.javaScriptEnabled = true
           // webView.settings.setSupportZoom(true)
        }
}


