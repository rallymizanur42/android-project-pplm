package com.ralproject.pplm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ralproject.pplm.databinding.ActivityMainBinding
import com.ralproject.pplm.tugas10.datastore.DataStoreActivity
import com.ralproject.pplm.tugas10.roomdatabase.SqlActivity
import com.ralproject.pplm.tugas3.ConstraintLayout
import com.ralproject.pplm.tugas3.FrameLayout
import com.ralproject.pplm.tugas3.LinearLayout
import com.ralproject.pplm.tugas3.RelativeLayout
import com.ralproject.pplm.tugas3.TableLayout
import com.ralproject.pplm.tugas4.ActivityPertama
import com.ralproject.pplm.tugas4.CustomTable
import com.ralproject.pplm.tugas4.KalkulatorBalok
import com.ralproject.pplm.tugas5.MainFragmentActivity
import com.ralproject.pplm.tugas5.MainNavDrawerActivity
import com.ralproject.pplm.tugas5.MainvPagerActivity
import com.ralproject.pplm.tugas5.horizontalSview.MainHViewActivity
import com.ralproject.pplm.tugas6.MainListViewActivity
import com.ralproject.pplm.tugas6.recycleviewlist.MainRecyclerViewActivity
import com.ralproject.pplm.tugas7.AlarmActivity
import com.ralproject.pplm.tugas7.NotificationActivity
import com.ralproject.pplm.tugas8.asynctask.AsyncTaskActivity
import com.ralproject.pplm.tugas8.coroutine.CoroutineActivity
import com.ralproject.pplm.tugas8.services.ServicesActivity
import com.ralproject.pplm.tugas9.gestur1.GesturSatuActivity
import com.ralproject.pplm.tugas9.gestur2.GesturDuaActivity
import com.ralproject.pplm.tugas9.gestur3.GesturKetigaActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFrame.setOnClickListener {
            val intent =Intent(this, FrameLayout::class.java)
            startActivity(intent)
        }
        binding.btnlinear.setOnClickListener {
            val intent =Intent(this, LinearLayout::class.java)
            startActivity(intent)
        }
        binding.btnrelative.setOnClickListener {
            val intent =Intent(this, RelativeLayout::class.java)
            startActivity(intent)
        }
        binding.btntable.setOnClickListener {
            val intent =Intent(this, TableLayout::class.java)
            startActivity(intent)
        }
        binding.btnconstraint.setOnClickListener {
            val intent =Intent(this, ConstraintLayout::class.java)
            startActivity(intent)
        }
        binding.btncustomtable.setOnClickListener {
            val intent =Intent(this, CustomTable::class.java)
            startActivity(intent)
        }

        binding.btncal.setOnClickListener {
            val intent =Intent(this, KalkulatorBalok::class.java)
            startActivity(intent)
        }
        binding.btnintent.setOnClickListener {
            val intent =Intent(this, ActivityPertama::class.java)
            startActivity(intent)
        }

        binding.btnfragment.setOnClickListener {
            val intent =Intent(this, MainFragmentActivity::class.java)
            startActivity(intent)
        }

        binding.btnfragmentsplash.setOnClickListener {
            val intent =Intent(this, MainvPagerActivity::class.java)
            startActivity(intent)
        }

        binding.btnhview.setOnClickListener {
            val intent =Intent(this, MainHViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnnavdraw.setOnClickListener {
            val intent =Intent(this, MainNavDrawerActivity::class.java)
            startActivity(intent)
        }

        binding.btnlistview.setOnClickListener {
            val intent =Intent(this, MainListViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnrecycleview.setOnClickListener {
            val intent =Intent(this, MainRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnnotifikasi.setOnClickListener {
            val intent =Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

        binding.btnAlarm.setOnClickListener {
            val intent =Intent(this, AlarmActivity::class.java)
            startActivity(intent)
        }

        binding.btnService.setOnClickListener {
            val intent =Intent(this, ServicesActivity::class.java)
            startActivity(intent)
        }

        binding.btnAsyncTask.setOnClickListener {
            val intent =Intent(this, AsyncTaskActivity::class.java)
            startActivity(intent)
        }

        binding.btnCoroutine.setOnClickListener {
            val intent =Intent(this, CoroutineActivity::class.java)
            startActivity(intent)
        }

        binding.btnGestur1.setOnClickListener {
            val intent =Intent(this, GesturSatuActivity::class.java)
            startActivity(intent)
        }

        binding.btnGestur2.setOnClickListener {
            val intent =Intent(this, GesturDuaActivity::class.java)
            startActivity(intent)
        }

        binding.btnGestur3.setOnClickListener {
            val intent =Intent(this, GesturKetigaActivity::class.java)
            startActivity(intent)
        }

        binding.btnDataStore.setOnClickListener {
            val intent =Intent(this, DataStoreActivity::class.java)
            startActivity(intent)
        }

        binding.btnSQL.setOnClickListener {
            val intent =Intent(this, SqlActivity::class.java)
            startActivity(intent)
        }
    }
}