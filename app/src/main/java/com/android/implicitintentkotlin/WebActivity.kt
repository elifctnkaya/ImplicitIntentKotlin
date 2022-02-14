package com.android.implicitintentkotlin

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class WebActivity : AppCompatActivity() {

    private lateinit var editTextAddress: EditText
    private lateinit var searchAddressButton: Button
    private lateinit var sendAddressButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        supportActionBar?.hide()

        editTextAddress = findViewById(R.id.editTextAddress)
        searchAddressButton = findViewById(R.id.searchAddressButton)
        sendAddressButton = findViewById(R.id.sendAddressButton)

        searchAddressButton.setOnClickListener {
            searchWeb(editTextAddress.text.toString())
        }

        sendAddressButton.setOnClickListener {
            sendWeb(editTextAddress.text.toString())
        }

    }

    fun searchWeb(query: String){
        val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, query)
        }
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    fun sendWeb(address: String){
        val intent = Intent(Intent.ACTION_SEND).apply {
            setType("text/plain")
            val message: String = "WebSite: " + "\n" + address
            putExtra(Intent.EXTRA_TEXT, message)

        }
        if(intent.resolveActivity(packageManager) != null){
            startActivity(Intent.createChooser(intent,"Choose: "))
            finish()
        }
    }
}