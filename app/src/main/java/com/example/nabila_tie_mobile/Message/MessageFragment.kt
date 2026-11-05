package com.example.nabila_tie_mobile.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nabila_tie_mobile.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    // Menggunakan URL foto profil orang asli yang stabil
    private val messageList by lazy {
        listOf(
            MessageModel("Alya", "Halo! Apa kabar?", "https://i.pravatar.cc/150?img=1"),
            MessageModel("Budi", "Sudah makan?", "https://i.pravatar.cc/150?img=12"),
            MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://i.pravatar.cc/150?img=5"),
            MessageModel("Dika", "Besok kita rapat jam 9", "https://i.pravatar.cc/150?img=8"),
            MessageModel("Eka", "Nice job kemarin!", "https://i.pravatar.cc/150?img=9")
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}