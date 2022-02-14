package com.android.implicitintentkotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MailActivity : AppCompatActivity() {

    private lateinit var editTextMail : EditText
    private lateinit var editTextSubject : EditText
    private lateinit var sendMailButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mail)
        supportActionBar?.hide()

        editTextMail = findViewById(R.id.editTextMail)
        editTextSubject = findViewById(R.id.editTextSubject)
        sendMailButton = findViewById(R.id.sendMailButton)

        sendMailButton.setOnClickListener {
            sendMail(arrayOf((editTextMail.text).toString()),editTextSubject.text.toString())
        }
    }

    fun sendMail(address: Array<String>, subject: String){
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, address)
            putExtra(Intent.EXTRA_SUBJECT,subject)
        }
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
            finish()
        }
    }
}