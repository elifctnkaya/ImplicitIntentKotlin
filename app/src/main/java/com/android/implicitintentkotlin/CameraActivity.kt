package com.android.implicitintentkotlin

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class CameraActivity : AppCompatActivity() {

    private lateinit var imageView : ImageView
    private lateinit var goToCameraButton: Button
    private var izinKontrol = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        supportActionBar?.hide()

        goToCameraButton = findViewById(R.id.goToCameraButton)
        imageView = findViewById(R.id.imageView)

        izinKontrol = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

        if (izinKontrol != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this@CameraActivity, arrayOf(Manifest.permission.CAMERA),1)
        }
        else{
           //izin verildi
        }
        goToCameraButton.setOnClickListener {
            goToCamera()
        }
    }

    fun goToCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent,1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.size > 0 && grantResults[0] === PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "İZİN VERİLDİ", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "İZİN VERİLMEDİ", Toast.LENGTH_SHORT).show()
            }
        }
    }

}