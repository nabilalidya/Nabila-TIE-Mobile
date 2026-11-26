package com.example.nabila_tie_mobile.Note

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.nabila_tie_mobile.data.AppDatabase
import com.example.nabila_tie_mobile.data.entity.NoteEntity
import com.example.nabila_tie_mobile.databinding.ActivityNoteFormBinding
import kotlinx.coroutines.launch

class NoteFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteFormBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /** Toolbar **/
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        /** Inisialisasi DB **/
        db = AppDatabase.getInstance(this)

        binding.btnSaveNote.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val content = binding.etContent.text.toString()

            if (title.isNotBlank() && content.isNotBlank()) {
                /** Penggunaan Coroutine dalam melakukan insert data **/
                lifecycleScope.launch {
                    val note = NoteEntity(
                        title = title,
                        content = content,
                        createdAt = System.currentTimeMillis()
                    )
                    db.noteDao().insert(note)
                    Toast.makeText(this@NoteFormActivity, "Catatan tersimpan!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else {
                Toast.makeText(this, "Isi semua kolom!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}