package com.ralproject.pplm.tugas9.gestur1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import com.ralproject.pplm.databinding.ActivityGesturSatuBinding

class GesturSatuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGesturSatuBinding
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGesturSatuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
    }

    override fun onTouchEvent(motionEvent: MotionEvent): Boolean {
        scaleGestureDetector.onTouchEvent(motionEvent)
        return true
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener(),
        ScaleGestureDetector.OnScaleGestureListener {
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            scaleFactor *= scaleGestureDetector.scaleFactor
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 10.0f))
            binding.imgPinch.scaleX = scaleFactor
            binding.imgPinch.scaleY = scaleFactor
            return true
        }
    }
}