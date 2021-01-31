package com.example.recyclerviewtrial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ExampleAdapter (private val exampleList: List<ExampleItem>) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {

       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
       return ExampleViewHolder(itemView)


//        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)       //setting the layout
//        val binding = DataBindingUtil.inflate(layoutInflater, R.layout.recycler_item, parent, false)
//        return ExampleViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {

        val currentItem = exampleList[position]

       holder.imageView.setImageResource(currentItem.imageResource)
       holder.textView1.text = currentItem.text1
       holder.textView2.text = currentItem.text2

    }

    override fun getItemCount(): Int {
        return exampleList.size
    }

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val textView1: TextView = itemView.findViewById(R.id.text_view_1)
        val textView2: TextView = itemView.findViewById(R.id.text_view_2)
    }





}