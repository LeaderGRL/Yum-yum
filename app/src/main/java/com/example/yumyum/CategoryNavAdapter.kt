package com.example.yumyum

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.view.allViews
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

public class CategoryNavAdapter(context: Context, cat: List<String>) : RecyclerView.Adapter<CategoryNavAdapter.ViewHolder>() {
    private var catName: List<String> = listOf("All, Indian")
    private var catInflater: LayoutInflater
    private lateinit var clickListener: ItemClickListener

    //Data pass into the constructor
    init {
        this.catInflater = LayoutInflater.from(context)
        this.catName = cat
    }

    //Inflate Layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val view: View = catInflater.inflate(R.layout.category_nav_items, parent, false)
        return ViewHolder(view)
    }

    //Bind data into textView
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cat = catName[position]
        holder.textView.text = cat

        if(holder.selectedPos == holder.bindingAdapterPosition){
            holder.textView.paintFlags = Paint.UNDERLINE_TEXT_FLAG
            holder.selectedPos = -1
        } else {
            holder.textView.paintFlags = 0
        }
    }

    override fun getItemCount() : Int {
        return catName.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        lateinit var view: View
        var textView: TextView
        var selectedPos: Int = -1
        var currentPos: Int = 0

        init {
            super.itemView
            //view = itemView.findViewById()
            textView = itemView.findViewById(R.id.catName)
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            selectedPos = bindingAdapterPosition

            bindingAdapter?.notifyDataSetChanged()

        }
    }

        fun getItem(id: Int): String{
            return catName[id]
        }

        fun setClickListener(itemClickListener: ItemClickListener){
            this.clickListener = itemClickListener
        }

        interface ItemClickListener {
            fun onItemClick(view: View, position: Int)
        }
}

