package com.ralproject.pplm.tugas8.asynctask

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ralproject.pplm.databinding.ActivityAsyncTaskBinding
import java.lang.ref.WeakReference

class AsyncTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAsyncTaskBinding
    var myVariable = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsyncTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDoksync.setOnClickListener {
            val task = MyAsyncTask(this)
            task.execute(10)
        }
    }

    companion object {
        class MyAsyncTask internal constructor(context: AsyncTaskActivity) : AsyncTask<Int, String, String>() {
            private var resB: String? = null
            private val activityReference: WeakReference<AsyncTaskActivity> = WeakReference(context)

            override fun onPreExecute() {
                val activity = activityReference.get()
                if (activity == null || activity.isFinishing) return
                activity.binding.progressBar.visibility = View.VISIBLE
            }

            override fun doInBackground(vararg params: Int?): String? {
                publishProgress("Thread mulai berhenti")
                try {
                    val time = params[0]?.times(1000)
                    time?.toLong()?.let { Thread.sleep(it / 2) }
                    publishProgress("Setengah jalan...")
                    time?.toLong()?.let { Thread.sleep(it / 2) }
                    publishProgress("Thread aktif lagi")
                    resB = "Android beristirahat selama " + params[0] + " detik"
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                    resB = e.message
                } catch (e: Exception) {
                    e.printStackTrace()
                    resB = e.message
                }
                return resB
            }

            override fun onPostExecute(result: String?) {
                val activity = activityReference.get()
                if (activity == null || activity.isFinishing) return
                activity.binding.progressBar.visibility = View.GONE
                activity.binding.textview.text = result
                activity.myVariable = 100
            }

            override fun onProgressUpdate(vararg text: String?) {
                val activity = activityReference.get()
                if (activity == null || activity.isFinishing) return
                Toast.makeText(activity, text.firstOrNull(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}