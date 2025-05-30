package com.ralproject.pplm.tugas9.gestur3

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.ralproject.pplm.databinding.ActivityGesturKetigaBinding

class GesturKetigaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGesturKetigaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGesturKetigaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llAtas.setOnDragListener(dragListener)
        binding.llBawah.setOnDragListener(dragListener)

        binding.vGeser.setOnLongClickListener { v: View ->
            val clipTeks = "Kotak berpindah"
            val item = ClipData.Item(clipTeks)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipTeks, mimeTypes, item)
            val dragShadowBuilder = View.DragShadowBuilder(v)
            v.startDragAndDrop(data, dragShadowBuilder, v, 0)
            v.visibility = View.INVISIBLE
            true
        }
    }

    val dragListener = View.OnDragListener { view, event ->
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                val item = event.clipData.getItemAt(0)
                val dragData = item.text
                Toast.makeText(this, dragData, Toast.LENGTH_SHORT).show()

                view.invalidate()

                val v = event.localState as View
                val owner = v.parent as ViewGroup
                owner.removeView(v)

                val dest = view as LinearLayout
                dest.addView(v)
                v.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                true
            }
            else -> false
        }
    }
}