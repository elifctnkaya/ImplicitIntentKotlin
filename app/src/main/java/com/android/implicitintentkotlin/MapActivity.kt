package com.android.implicitintentkotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MapActivity : AppCompatActivity() {

    private lateinit var editTextLat: EditText
    private lateinit var editTextLon: EditText
    private lateinit var goToMapButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        supportActionBar?.hide()

        editTextLat = findViewById(R.id.editTextLat)
        editTextLon = findViewById(R.id.editTextLon)
        goToMapButton = findViewById(R.id.gotToMap)


        goToMapButton.setOnClickListener {
            showMap(editTextLat.text.toString().toDouble(), editTextLat.text.toString().toDouble(),12)
        }
    }

    fun showMap(lat:Double, lon:Double, zoom: Int){
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setData(Uri.parse(String.format("geo:%f,%f?z=%d",lat,lon,zoom)))
        }
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
            finish()
        }
    }
}