package com.example.lookaroundshow.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lookaroundshow.R
import com.example.lookaroundshow.databinding.ActivityBookBinding
import com.example.lookaroundshow.databinding.ActivityMyBinding

class BookActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startWebView()
    }
    private fun startWebView() {
        //binding.webview.loadUrl()
    }
}