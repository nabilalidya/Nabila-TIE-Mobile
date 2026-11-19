package com.example.nabila_tie_mobile.Home.Pertemuan2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan11.EleventhActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan3.ThirdActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan4.FourthActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan5.FifthActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan6.SixthActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan7.SeventhActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.pertemuan_10.TenthActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.photo.PhotoAdapter
import com.example.nabila_tie_mobile.data.api.CatFactApiClient
import com.example.nabila_tie_mobile.data.api.PhotoApiClient
import com.example.nabila_tie_mobile.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigasi tombol Pertemuan 2 - 11
        binding.btnPertemuan2.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnPertemuan3.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        binding.btnPertemuan4.setOnClickListener {
            startActivity(Intent(requireContext(), FourthActivity::class.java))
        }

        binding.btnPertemuan5.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }

        binding.btnPertemuan6.setOnClickListener {
            startActivity(Intent(requireContext(), SixthActivity::class.java))
        }

        binding.btnPertemuan7.setOnClickListener {
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }

        binding.btnPertemuan10.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        binding.btnPertemuan11.setOnClickListener {
            startActivity(Intent(requireContext(), EleventhActivity::class.java))
        }

        // Langkah 5 Modul 12: Panggil loadCatFact() & event klik btnRefresh
        loadCatFact()

        binding.btnRefresh.setOnClickListener {
            loadCatFact()
        }

        // Langkah 6 Modul 12: Panggil loadPhoto() untuk galeri picsum.photos
        loadPhoto()
    }

    private fun loadCatFact() {
        lifecycleScope.launch {
            try {
                val response = CatFactApiClient.apiService.getCatFact()
                binding.tvCatFact.text = "\"${response.fact}\""
            } catch (e: Exception) {
                binding.tvCatFact.text = "Gagal mengambil fakta kucing."
            }
        }
    }

    private fun loadPhoto() {
        lifecycleScope.launch {
            try {
                val photos = PhotoApiClient.apiService.getPhotos()
                val adapter = PhotoAdapter(photos)
                binding.rvGallery.adapter = adapter

                /** List Tampil Vertical */
                // binding.rvGallery.layoutManager = LinearLayoutManager(requireContext())

                /** List Tampil Horizontal */
                // binding.rvGallery.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

                /** List Tampil Grid */
                binding.rvGallery.layoutManager = GridLayoutManager(requireContext(), 2)
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Gagal memuat gambar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}