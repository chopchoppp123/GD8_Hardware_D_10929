package com.guided.gd8_camera_d_0929

import android.annotation.SuppressLint
import android.hardware.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var mCamera: Camera? = null
    private var mCameraView: CameraView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            mCamera= Camera.open()
        }catch (e:Exception){
            Log.d("error", "Failed to get camera" + e.message)
        }
        if (mCamera != null){
            mCameraView = CameraView(this, mCamera!!)
            val Camera_View = findViewById<View>(R.id.FLCamera)as FrameLayout
            Camera_View.addView(mCameraView)
        }
        @SuppressLint("Missinginflated","Localsupperss") val imageClose =
            findViewById<View>(R.id.imgClose)as ImageButton
            imageClose.setOnClickListener{view:View?-> System.exit(0)}
    }
}