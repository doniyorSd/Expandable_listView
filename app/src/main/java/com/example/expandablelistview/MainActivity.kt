package com.example.expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.expandablelistview.adapters.ExpAdapter
import com.example.expandablelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val map = HashMap<String, List<String>>()
    var words = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
        val expAdapter = ExpAdapter(map, words)
        binding.expandableListView.setAdapter(expAdapter)
        binding.expandableListView.setOnChildClickListener { expandableListView, view, groupPosition, childPosition, l ->
            Toast.makeText(this, map[words[groupPosition]]?.get(childPosition), Toast.LENGTH_SHORT)
                .show()
            true
        }
        var lastIndex = -1
//        binding.expandableListView.setOnGroupCollapseListener {
//            Toast.makeText(this, "$it collapse", Toast.LENGTH_SHORT).show()
//        }
        //last index = 0
        // last index = 1
        binding.expandableListView.setOnGroupExpandListener {
            if (lastIndex != -1 && lastIndex != it){
                binding.expandableListView.collapseGroup(lastIndex)
            }
            Log.d("tag", "onCreate: $it $lastIndex")
            lastIndex = it
        }


    }

    private fun setData() {
        map["Afrika"] = arrayListOf("Nigeriya", "Gana", "Mali", "Misr")
        map["Amerika"] = arrayListOf("AQSH", "Kuba", "Ekvador")
        map["Avstraliya"] = arrayListOf("Samoa", "Fiji", "Tuvalu", "yangi zelandiya")
        words = arrayListOf("Afrika", "Amerika", "Avstraliya")
    }
}