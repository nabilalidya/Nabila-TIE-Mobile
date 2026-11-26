package com.example.nabila_tie_mobile.Note

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nabila_tie_mobile.data.AppDatabase
import com.example.nabila_tie_mobile.data.entity.NoteEntity
import com.example.nabila_tie_mobile.databinding.FragmentNoteBinding
import kotlinx.coroutines.launch

class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var db: AppDatabase
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = AppDatabase.getInstance(requireContext())

        noteAdapter = NoteAdapter(emptyList()) { note ->
            deleteNote(note)
        }

        binding.rvNotes.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }

        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(requireContext(), NoteFormActivity::class.java))
        }

        loadNotes()
    }

    override fun onResume() {
        super.onResume()
        loadNotes()
    }

    private fun loadNotes() {
        viewLifecycleOwner.lifecycleScope.launch {
            val notes = db.noteDao().getAll()
            _binding?.let {
                noteAdapter.updateData(notes)
                it.tvEmptyNote.visibility = if (notes.isEmpty()) View.VISIBLE else View.GONE
            }
        }
    }

    private fun deleteNote(note: NoteEntity) {
        viewLifecycleOwner.lifecycleScope.launch {
            db.noteDao().delete(note)
            context?.let {
                Toast.makeText(it, "Catatan dihapus", Toast.LENGTH_SHORT).show()
            }
            loadNotes()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}