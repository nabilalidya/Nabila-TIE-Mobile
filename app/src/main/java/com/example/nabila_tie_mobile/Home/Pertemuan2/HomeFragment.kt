package com.example.nabila_tie_mobile.Home.Pertemuan2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan11.EleventhActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan3.ThirdActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan4.FourthActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan5.FifthActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan6.SixthActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.Pertemuan7.SeventhActivity
import com.example.nabila_tie_mobile.Home.Pertemuan2.pertemuan_10.TenthActivity
import com.example.nabila_tie_mobile.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val btnP2: Button = view.findViewById(R.id.btnPertemuan2)
        val btnP3: Button = view.findViewById(R.id.btnPertemuan3)
        val btnP4: Button = view.findViewById(R.id.btnPertemuan4)
        val btnP5: Button = view.findViewById(R.id.btnPertemuan5)
        val btnP6: Button = view.findViewById(R.id.btnPertemuan6)
        val btnP7: Button = view.findViewById(R.id.btnPertemuan7)
        val btnP10: Button = view.findViewById(R.id.btnPertemuan10)
        val btnP11: Button = view.findViewById(R.id.btnPertemuan11)

        btnP2.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        btnP3.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        btnP4.setOnClickListener {
            startActivity(Intent(requireContext(), FourthActivity::class.java))
        }

        btnP5.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }

        btnP6.setOnClickListener {
            startActivity(Intent(requireContext(), SixthActivity::class.java))
        }

        btnP7.setOnClickListener {
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }

        btnP10.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        btnP11.setOnClickListener {
            startActivity(Intent(requireContext(), EleventhActivity::class.java))
        }

        return view
    }
}