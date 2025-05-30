package com.ralproject.pplm.tugas9.gestur2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import com.ralproject.pplm.databinding.ActivityGesturDuaBinding

class GesturDuaActivity : AppCompatActivity(), GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {

    private lateinit var binding: ActivityGesturDuaBinding
    private lateinit var gDetector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGesturDuaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.gDetector = GestureDetectorCompat(this, this)
        gDetector.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        this.gDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onDown(event: MotionEvent): Boolean {
        return true
    }

    override fun onShowPress(event: MotionEvent) {
        // Tidak perlu melakukan apa-apa
    }

    override fun onSingleTapUp(event: MotionEvent): Boolean {
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        binding.txGestureStatus.text = "Efek Scroll"
        binding.clayout1.setBackgroundColor(Color.GREEN)
        return true
    }

    override fun onLongPress(event: MotionEvent) {
        binding.txGestureStatus.text = "Efek Tekan Lama"
        binding.clayout1.setBackgroundColor(Color.BLUE)
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        binding.txGestureStatus.text = "Efek Fling"
        binding.clayout1.setBackgroundColor(Color.MAGENTA)
        return true
    }

    override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
        binding.txGestureStatus.text = "Efek Tekan Sekali"
        binding.clayout1.setBackgroundColor(Color.GRAY)
        return true
    }

    override fun onDoubleTap(event: MotionEvent): Boolean {
        binding.txGestureStatus.text = "Efek Tekan Dua Kali"
        binding.clayout1.setBackgroundColor(Color.RED)
        return true
    }

    override fun onDoubleTapEvent(event: MotionEvent): Boolean {
        return true
    }
}