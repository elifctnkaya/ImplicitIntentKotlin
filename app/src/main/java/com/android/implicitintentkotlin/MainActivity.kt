package com.android.implicitintentkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }

    fun cameraActivityGecis(view: View){
        val cameraIntent = Intent(this, CameraActivity::class.java)
        startActivity(cameraIntent)
    }

    fun callPhoneActivityGecis(view: View){
        val cameraIntent = Intent(this, CallPhoneActivity::class.java)
        startActivity(cameraIntent)
    }

    fun mapActivityGecis(view: View){
        val cameraIntent = Intent(this, MapActivity::class.java)
        startActivity(cameraIntent)
    }

    fun mailActivityGecis(view: View){
        val cameraIntent = Intent(this, MailActivity::class.java)
        startActivity(cameraIntent)
    }

    fun webActivityGecis(view: View){
        val cameraIntent = Intent(this, WebActivity::class.java)
        startActivity(cameraIntent)
    }

}