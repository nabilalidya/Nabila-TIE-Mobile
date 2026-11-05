package com.example.nabila_tie_mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.nabila_tie_mobile.Home.Pertemuan2.HomeFragment
import com.example.nabila_tie_mobile.Message.MessageFragment
import com.example.nabila_tie_mobile.More.MoreFragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class BaseActivity : AppCompatActivity() {

    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        val mainView = findViewById<android.view.View>(R.id.main)
        toolbar = findViewById(R.id.toolbarBase)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
                insets
            }
        }

        // Tampilkan HomeFragment & atur Judul Toolbar pertama kali
        replaceFragment(HomeFragment(), "Home")

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment(), "Home")
                    true
                }
                R.id.message -> {
                    replaceFragment(MessageFragment(), "Message")
                    true
                }
                R.id.more -> {
                    replaceFragment(MoreFragment(), "Message")
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        toolbar.title = title
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}