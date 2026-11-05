package com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.nabila_tie_mobile.R

class SeventhActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seventh)

        val toolbar: Toolbar = findViewById(R.id.toolbarSeventh)
        setSupportActionBar(toolbar)

        // Tombol Back di Toolbar
        toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}