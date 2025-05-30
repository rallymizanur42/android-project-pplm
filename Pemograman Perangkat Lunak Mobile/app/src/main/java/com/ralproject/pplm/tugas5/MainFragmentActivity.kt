package com.ralproject.pplm.tugas5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ralproject.pplm.databinding.ActivityMainFragmentBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ralproject.pplm.tugas5.fragment.DraftFragment
import com.ralproject.pplm.tugas5.fragment.InboxFragment
import com.ralproject.pplm.tugas5.fragment.SentFragment

class MainFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbarAwal
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        val tabLayout: TabLayout = binding.tabLayout
        val viewPager: ViewPager = binding.viewPager
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        viewPagerAdapter.tambahFragment(InboxFragment(), "Inbox")
        viewPagerAdapter.tambahFragment(DraftFragment(), "Draft")
        viewPagerAdapter.tambahFragment(SentFragment(), "Sent")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    internal class ViewPagerAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val fragments = ArrayList<Fragment>()
        private val juduls = ArrayList<String>()

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        fun tambahFragment(fragment: Fragment, judul: String) {
            fragments.add(fragment)
            juduls.add(judul)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return juduls[position]
        }
    }
}
