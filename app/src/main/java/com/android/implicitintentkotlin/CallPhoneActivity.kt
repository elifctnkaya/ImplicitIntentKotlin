package com.android.implicitintentkotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CallPhoneActivity : AppCompatActivity() {

    private lateinit var editTextNumber : EditText
    private lateinit var buttonCallNum: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_phone)
        supportActionBar?.hide()

        editTextNumber = findViewById(R.id.editTextNumber)
        buttonCallNum = findViewById(R.id.buttonCallNum)

        buttonCallNum.setOnClickListener {
            dialPhoneNumber(editTextNumber.text.toString())
        }

    }

    fun dialPhoneNumber(phoneNumber: String){
        val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
            finish()
        }
    }
}