package com.guided.gd8_camera_d_0929

import android.content.Context
import android.graphics.Camera
import android.graphics.SurfaceTexture
import android.renderscript.Int2
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.IOException

class CameraView(context: Context?, private val mCamera: android.hardware.Camera) : SurfaceView(context), SurfaceHolder.Callback {
    private val mHolder: SurfaceHolder

    init {
        mCamera.setDisplayOrientation(90)
        mHolder = holder
        mHolder.addCallback(this)
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }

    override fun surfaceCreated(surfaceHolder : SurfaceHolder) {
        try {
            mCamera.setPreviewDisplay(mHolder)
            mCamera.startPreview()
        }catch (e:IOException){ 
            Log.d("error", "Camera error on surfaceChanged"+ e.message)

        }
    }

    override fun surfaceChanged(SurfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {
        if (mHolder.surface == null) return
        try {
            mCamera.setPreviewDisplay(holder)
            mCamera.startPreview()
        } catch (e: IOException){
            Log.d("error", "Camera error on surfaceChanged"+ e.message)
        }
    }

    override fun surfaceDestroyed(SurfaceHolder: SurfaceHolder) {
        mCamera.stopPreview()
        mCamera.release()
    }
}