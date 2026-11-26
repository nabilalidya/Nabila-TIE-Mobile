package com.example.nabila_tie_mobile.Message

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.nabila_tie_mobile.Message.tutorial.TutorialMessageActivity
import com.example.nabila_tie_mobile.R
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

        setupToolbarMenu()

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    private fun setupToolbarMenu() {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.message_toolbar_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_tutorial -> {
                        val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}