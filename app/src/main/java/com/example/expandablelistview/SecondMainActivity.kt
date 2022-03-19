package com.example.expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.expandablelistview.adapters.SpinnerAdapter
import com.example.expandablelistview.databinding.ActivitySecondMainBinding

class SecondMainActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondMainBinding
    var list = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        val spinnerAdapter = SpinnerAdapter(list)
        binding.spinner.adapter = spinnerAdapter
        binding.btn.setOnClickListener {
            val position = binding.spinner.selectedItemPosition
            Toast.makeText(this, list[position], Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadData() {
        for (i in 0 until 5) {
            list.add("item $i")
        }
    }
}