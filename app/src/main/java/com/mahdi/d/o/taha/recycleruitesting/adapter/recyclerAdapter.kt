package com.mahdi.d.o.taha.recycleruitesting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahdi.d.o.taha.recycleruitesting.R
import com.mahdi.d.o.taha.recycleruitesting.model.data
import kotlinx.android.synthetic.main.mylist_item.view.*

class recyclerAdapter(val context: Context, val list: ArrayList<data>) :
    RecyclerView.Adapter<recyclerAdapter.ViewHolder>() {
    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val checkedTextView = item.item_checked_text
        val item = item.item_layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mylist_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkedTextView.text = list[position].checkedTextView
        holder.item.setOnClickListener {
            holder.checkedTextView.isChecked = !holder.checkedTextView.isChecked
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}