package com.example.fitnessandyoga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class Bhujangasana : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bhujangasana)

        val webView = findViewById<WebView>(R.id.web_view)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/Bhujangasana.html")



    }
}
