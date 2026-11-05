package com.example.nabila_tie_mobile.Home.Pertemuan2.pertemuan_10

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nabila_tie_mobile.databinding.ActivityTenthBinding
import com.google.android.material.chip.Chip

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol kembali di Toolbar
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // Action Login Button
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            Toast.makeText(this, "Login dengan Email: $email", Toast.LENGTH_SHORT).show()
        }

        // Action Chip Group Listener
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(this, "Filter dipilih: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}