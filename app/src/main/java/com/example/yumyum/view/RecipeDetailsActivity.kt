package com.example.yumyum.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestOptions
import com.example.yumyum.R
import com.example.yumyum.viewmodel.CategoryNavAdapter
import com.example.yumyum.viewmodel.RecipeDetailsViewModel
import com.example.yumyum.viewmodel.RecipeThumbnailAdapter

class RecipeDetailsActivity : AppCompatActivity() {
    private lateinit var adapter: CategoryNavAdapter
    private var recipeDetailsViewMode: RecipeDetailsViewModel = RecipeDetailsViewModel()
    //private var topImage: ImageView = ImageView(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)
        val topImage: ImageView = findViewById(R.id.topImage)
        var requestOption = RequestOptions()
        requestOption = requestOption.transform(FitCenter())
        Glide.with(this).load(recipeDetailsViewMode.BindRecipeResponse.recipeArray[getClickedPosition()].recipeImageUrl).placeholder(R.mipmap.placeholder).apply(requestOption).skipMemoryCache(true).into(topImage)
    }

    fun getClickedPosition() : Int{
        val extras: Bundle? = intent.extras
        val pos = extras?.getString("position")
        Toast.makeText(this, "new Activity: "+pos, Toast.LENGTH_SHORT)
        return Integer.parseInt(pos)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }
}