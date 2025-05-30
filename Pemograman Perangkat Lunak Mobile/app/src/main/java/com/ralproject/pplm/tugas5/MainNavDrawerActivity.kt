package com.ralproject.pplm.tugas5

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import com.ralproject.pplm.databinding.ActivityMainNavDrawerBinding
import com.google.android.material.navigation.NavigationView
import com.ralproject.pplm.R
import com.ralproject.pplm.tugas5.navdrawer.HalamanDraftFragment
import com.ralproject.pplm.tugas5.navdrawer.HalamanHelpFragment
import com.ralproject.pplm.tugas5.navdrawer.HalamanInboxFragment
import com.ralproject.pplm.tugas5.navdrawer.HalamanSendFragment
import com.ralproject.pplm.tugas5.navdrawer.HalamanSettingFragment


class MainNavDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainNavDrawerBinding

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var inboxFragment: HalamanInboxFragment
    private lateinit var draftFragment: HalamanDraftFragment
    private lateinit var sendFragment: HalamanSendFragment
    private lateinit var settingFragment: HalamanSettingFragment
    private lateinit var helpFragment: HalamanHelpFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNavDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.open,
            R.string.close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.inbox -> {
                inboxFragment = HalamanInboxFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, inboxFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Inbox", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.draft -> {
                draftFragment = HalamanDraftFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, draftFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Draft", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.send -> {
                sendFragment = HalamanSendFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, sendFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Send", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.setting -> {
                settingFragment = HalamanSettingFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, settingFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Setting", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.help -> {
                helpFragment = HalamanHelpFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, helpFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Help", Toast.LENGTH_SHORT).show()
            }
        }

        binding.drawerLayout.closeDrawers()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
