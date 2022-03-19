package com.example.expandablelistview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.expandablelistview.R
import com.example.expandablelistview.databinding.ItemGroupBinding

class SpinnerAdapter(var list: List<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): String = list[p0]


    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val itemView : View
        if (p1 == null){
            itemView = LayoutInflater.from(p2?.context).inflate(R.layout.item_group,p2,false)
        }else{
            itemView = p1
        }
        val bind = ItemGroupBinding.bind(itemView)
        bind.tv.text = list[p0]
        return itemView
    }
}