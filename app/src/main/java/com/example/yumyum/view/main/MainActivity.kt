package com.example.yumyum.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yumyum.viewmodel.CategoryNavAdapter
import com.example.yumyum.R
import com.example.yumyum.view.RecipeDetailsActivity
import com.example.yumyum.model.network.API.*
import com.example.yumyum.model.ItemDecoration
import com.example.yumyum.viewmodel.CategoryNavViewModel
import com.example.yumyum.viewmodel.RecipeThumbnailAdapter
//import com.example.yumyum.viewmodel.RecipeThumbnailBackgroundAdapter
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), CategoryNavAdapter.ItemClickListener {
    private lateinit var adapter: CategoryNavAdapter
    private lateinit var recipeThumbnailAdapter: RecipeThumbnailAdapter
    private val navViewModel: CategoryNavViewModel = CategoryNavViewModel()
    var catViewModel: CategoryNavViewModel = CategoryNavViewModel()
    //private lateinit var recipeThumbnailBackgroundAdapter: RecipeThumbnailBackgroundAdapter
    private val catName: ArrayList<String> = ArrayList()
    private val recipeImage: ArrayList<String> = ArrayList()
    private val getRecipe: getRecipe = getRecipe()
    private val BindRecipeResponse: bindRecipeResponse = bindRecipeResponse
    //private lateinit var recipeListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var recipeListView = findViewById(R.id.recipeThumbnailItems)

        //--------TEMP--------//
        /*catName.add("oui")
        catName.add("Indian")
        catName.add("japanese")
        catName.add("vegetarian")
        catName.add("Tex-Mex")
        catName.add("Tacos")
        catName.add("Burger")*/

        setCategoryRecyclerView()

        setThumbnailRecyclerView()

        //----TEMPS-RECIPE----//
        setRecipeThumbnailData()

    }

    private fun setCategoryRecyclerView(){
        val recyclerView: RecyclerView = findViewById(R.id.CatNavBar)
        val horizontalLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = horizontalLayoutManager
        adapter = CategoryNavAdapter(this, navViewModel.catName)
        adapter.setClickListener(this)
        recyclerView.adapter = adapter
    }

    private fun setThumbnailRecyclerView(){
        val recipeThumbnailRecyclerView: RecyclerView = findViewById(R.id.recipeThumbnail)
        val verticalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recipeThumbnailRecyclerView.layoutManager = verticalLayoutManager
        recipeThumbnailAdapter = RecipeThumbnailAdapter(this, BindRecipeResponse.recipeArray)
        recipeThumbnailRecyclerView.adapter = recipeThumbnailAdapter
        recipeThumbnailRecyclerView.setOnClickListener{
            println("START NEW ACTIVITY")
            val intent = Intent(this, RecipeDetailsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setRecipeThumbnailData(){
        BindRecipeResponse.bindRecipeResponseCallback { result ->
            val recipeThumbnailRecyclerView: RecyclerView = findViewById(R.id.recipeThumbnail)
            val itemDecoration = ItemDecoration(this)
            itemDecoration.spaceBetweenItem(0)
            recipeThumbnailRecyclerView.addItemDecoration(itemDecoration)
            val verticalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            recipeThumbnailRecyclerView.layoutManager = verticalLayoutManager
            recipeThumbnailAdapter = RecipeThumbnailAdapter(this, result)
            recipeThumbnailRecyclerView.adapter = recipeThumbnailAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(this, adapter.getItem(position) + "on item position" + position, Toast.LENGTH_SHORT).show();
    }

}

