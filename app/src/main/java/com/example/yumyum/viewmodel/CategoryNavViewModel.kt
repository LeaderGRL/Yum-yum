package com.example.yumyum.viewmodel

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yumyum.R


class CategoryNavViewModel : ViewModel() {
   var catName: ArrayList<String> = ArrayList()

    init {
        setCatName()
    }
   private fun getCatName(){

   }

    fun setCatName(){
        catName.add("oui")
        catName.add("Indian")
        catName.add("japanese")
        catName.add("vegetarian")
        catName.add("Tex-Mex")
        catName.add("Tacos")
        catName.add("Burger")
    }

}