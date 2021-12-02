package com.mahdi.d.o.taha.recycleruitesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahdi.d.o.taha.recycleruitesting.adapter.recyclerAdapter
import com.mahdi.d.o.taha.recycleruitesting.model.data
import kotlinx.android.synthetic.main.activity_data.*

class DataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        val myRecyclerList = ArrayList<data>()
        for (i in 0..17) {
            myRecyclerList.add(data("Text$i"))
        }

        val adapter = recyclerAdapter(this, myRecyclerList)
        myRecyclerView.adapter = adapter
        myRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}