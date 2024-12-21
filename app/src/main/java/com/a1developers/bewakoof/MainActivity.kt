package com.a1developers.bewakoof

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.a1developers.bewakoof.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        lateinit var webView: WebView

//        webView = findViewById(R.id.webview)
//        webView.webViewClient = WebViewClient()
//        webView.settings.javaScriptEnabled = true
//
//
//
//        val url = "https://www.bewakoof.com/" // Replace with your URL
//        webView.loadUrl(url)




                webView = findViewById(R.id.webview)
                webView.webViewClient = MyWebViewClient()
                webView.settings.javaScriptEnabled = true

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    WebView.setWebContentsDebuggingEnabled(true)
                }

                val url = "https://www.instagram.com/bewakoofofficial/?hl=en" // Replace with your URL
                webView.loadUrl(url)
            }

            private class MyWebViewClient : WebViewClient() {
                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?,
                ) {
                    super.onReceivedError(view, request, error)
                    Log.e("WebViewError", "Error: ${error?.description}, URL: ${request?.url}")
                    // Handle the error (e.g., show an error message)
                }
            }
        }





