package com.example.nabila_tie_mobile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan6.AuthActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan6.SixthActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan7.SeventhActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPertemuan6: Button = findViewById(R.id.btnPertemuan6)
        val btnPertemuan7: Button = findViewById(R.id.btnPertemuan7)
        val btnLogout: Button = findViewById(R.id.btnLogout)

        // Klik untuk melihat hasil 3 Fragment di SixthActivity
        btnPertemuan6.setOnClickListener {
            val intent = Intent(this, SixthActivity::class.java)
            startActivity(intent)
        }

        // Navigasi ke Pertemuan 7
        btnPertemuan7.setOnClickListener {
            val intent = Intent(this, SeventhActivity::class.java)
            startActivity(intent)
        }

        // Logout
        btnLogout.setOnClickListener {
            val sharedPref = getSharedPreferences("user_session", Context.MODE_PRIVATE)
            sharedPref.edit().clear().apply()

            val intent = Intent(this, AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}