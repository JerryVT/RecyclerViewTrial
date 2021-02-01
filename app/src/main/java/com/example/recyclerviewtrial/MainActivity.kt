package com.example.recyclerviewtrial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
   private val exampleList = generateDummyList(500)
    private val adapter = ExampleAdapter(exampleList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this) //positioning the elements into list item- Linear/Grid
        recycler_view.setHasFixedSize(true)         //for performance /optimization when we know the size of list
    }

    fun insertItem(view: View) {
        val index = Random.nextInt(8)

        val newItem = ExampleItem(
            R.drawable.ic_baseline_adb,
            text1 = "New Item at position $index",
            text2 = "Line 2"
        )
        exampleList.add(index, newItem)
        adapter.notifyItemInserted(index)       //affects

    }

    fun removeItem(view: View) {
        val index = Random.nextInt(8)

        exampleList.removeAt(index)
        adapter.notifyItemRemoved(index)
    }


    private fun generateDummyList(size: Int): ArrayList<ExampleItem> {       // a fn to create random data
        //ArrayList = read and wirte
        //List - read only

        val list = ArrayList<ExampleItem>()

        for(i in 0 until size) {
            val drawable = when(i % 3 ) {
                0 -> R.drawable.ic_baseline_ad
                1 -> R.drawable.ic_baseline_build_circle
                else -> R.drawable.ic_baseline_adb
            }

            val item = ExampleItem(drawable, "Item $i", "Line 2") //constructor is called here
            list.add(item)
        }

        return list

    }

}