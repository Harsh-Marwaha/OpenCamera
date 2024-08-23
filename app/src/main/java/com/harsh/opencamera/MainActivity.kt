package com.harsh.opencamera

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var btnCam : ImageButton? = null
    var imgView : ImageView? = null
    val CAMERA_REQ_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnCam=findViewById(R.id.btnCam)
        imgView=findViewById(R.id.imgView)

        btnCam?.setOnClickListener()
        {
            var iCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(iCamera,CAMERA_REQ_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK ){
            if (requestCode==CAMERA_REQ_CODE){
                var imgBitmap : Bitmap = data?.extras?.get("data") as Bitmap
                imgView?.setImageBitmap(imgBitmap)
            }
        }
    }

}