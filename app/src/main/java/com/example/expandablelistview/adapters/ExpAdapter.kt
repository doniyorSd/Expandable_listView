package com.example.expandablelistview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.expandablelistview.R
import com.example.expandablelistview.databinding.ItemChildBinding
import com.example.expandablelistview.databinding.ItemGroupBinding

class ExpAdapter(var map: HashMap<String, List<String>>, var words: List<String>) :
    BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return words.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return map[words[p0]]?.size!!
    }

    override fun getGroup(p0: Int): String {
        return words[p0]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return map[words[groupPosition]]?.get(childPosition)!!
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isLastChild: Boolean,
        view: View?,
        viewGroup: ViewGroup?
    ): View {
        val itemGroupView: View
        if (view == null) {
            itemGroupView = LayoutInflater.from(viewGroup?.context)
                .inflate(R.layout.item_group, viewGroup, false)
        } else {
            itemGroupView = view
        }
        val bind = ItemGroupBinding.bind(itemGroupView)
        bind.tv.text = words[groupPosition]
        return itemGroupView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        view: View?,
        parent: ViewGroup?
    ): View {
        val itemChildView: View
        if (view == null) {
            itemChildView =
                LayoutInflater.from(parent?.context).inflate(R.layout.item_child, parent, false)
        } else {
            itemChildView = view
        }
        val bind = ItemChildBinding.bind(itemChildView)
        bind.tv.text = map[words[groupPosition]]?.get(childPosition)
        return itemChildView
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}