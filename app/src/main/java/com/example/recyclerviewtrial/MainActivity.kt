package com.example.recyclerviewtrial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateDummyList(500)

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)

        recycler_view.adapter = ExampleAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<ExampleItem> {

        val list = ArrayList<ExampleItem>()

        for(i in 0 until size) {
            val drawable = when(i % 3 ) {
                0 -> R.drawable.ic_baseline_ad
                1 -> R.drawable.ic_baseline_build_circle
                else -> R.drawable.ic_baseline_adb
            }

            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list.add(item)
        }

        return list

    }

}