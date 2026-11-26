package com.example.nabila_tie_mobile.Note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nabila_tie_mobile.data.entity.NoteEntity
import com.example.nabila_tie_mobile.databinding.ItemNoteBinding

class NoteAdapter(
    private var notes: List<NoteEntity>,
    private val onDeleteClick: (NoteEntity) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.tvNoteTitle.text = note.title
        holder.binding.tvNoteContent.text = note.content
        holder.binding.btnDeleteNote.setOnClickListener {
            onDeleteClick(note)
        }
    }

    override fun getItemCount(): Int = notes.size

    fun updateData(newNotes: List<NoteEntity>) {
        notes = newNotes
        notifyDataSetChanged()
    }
}