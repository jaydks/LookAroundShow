package com.example.lookaroundshow.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lookaroundshow.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_LookAroundShow)
        setContentView(R.layout.activity_login)
    }
}