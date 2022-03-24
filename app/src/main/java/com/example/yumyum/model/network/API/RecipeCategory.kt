package com.example.yumyum.model.network.API

import com.example.yumyum.viewmodel.CategoryNavAdapter
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yumyum.R

class RecipeCategory {
    private val catName: ArrayList<String> = ArrayList()
    private lateinit var adapter: CategoryNavAdapter

    fun setFakeRecipeCategory() : ArrayList<String>{
        catName.add("oui")
        catName.add("Indian")
        catName.add("japanese")
        catName.add("vegetarian")
        catName.add("Tex-Mex")
        catName.add("Tacos")
        catName.add("Burger")

        return catName
    }
}