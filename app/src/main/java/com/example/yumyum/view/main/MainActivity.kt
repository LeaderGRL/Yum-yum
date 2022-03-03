package com.example.yumyum.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yumyum.CategoryNavAdapter
import com.example.yumyum.R
import com.example.yumyum.model.network.API.APIInstance
import com.example.yumyum.model.network.API.ApiCallback
import com.example.yumyum.model.network.API.getRecipe
import com.example.yumyum.model.network.API.getRecipeResponse
import com.example.yumyum.viewmodel.RecipeThumbnailAdapter
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity(), CategoryNavAdapter.ItemClickListener {
    private lateinit var adapter: CategoryNavAdapter
    private val catName: ArrayList<String> = ArrayList()
    private val recipeImage: ArrayList<String> = ArrayList()
    private val getRecipe: getRecipe = getRecipe()
    //private lateinit var recipeListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var recipeListView = findViewById(R.id.recipeThumbnailItems)

        //--------TEMP--------//
        catName.add("oui")
        catName.add("Indian")
        catName.add("japanese")
        catName.add("vegetarian")
        catName.add("Tex-Mex")
        catName.add("Tacos")
        catName.add("Burger")

        val recyclerView: RecyclerView = findViewById(R.id.CatNavBar)
        val horizontalLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = horizontalLayoutManager
        adapter = CategoryNavAdapter(this, catName)
        adapter.setClickListener(this)
        recyclerView.adapter = adapter

        //--------TEMPS--------//

        //----TEMPS-RECIPE----//

        val recipeThumbnailRecyclerView: RecyclerView = findViewById(R.id.recipeThumbnail)
        val verticalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recipeThumbnailRecyclerView.layoutManager = verticalLayoutManager
        recipeThumbnailRecyclerView.adapter = RecipeThumbnailAdapter(this)

        //recipeImage.add()

        //----TEMPS-RECIPE----//

        /*val typeface = Typeface.createFromAsset(assets, "CountrysideTwo-r9WO.ttf")

        val toolbarRecipe = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_recipe)
        for(i in 0 until toolbarRecipe.childCount){
            val view = toolbarRecipe.getChildAt(i)
            if(view is TextView){
                view.typeface = typeface
                break
            }
        }*/

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(this, adapter.getItem(position) + "on item position" + position, Toast.LENGTH_SHORT).show();
    }

}

