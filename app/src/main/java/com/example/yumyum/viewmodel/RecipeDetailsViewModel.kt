package com.example.yumyum.viewmodel

import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.example.yumyum.model.network.API.bindRecipeResponse
import com.example.yumyum.model.network.API.getRecipeInfo

class RecipeDetailsViewModel : ViewModel() {
    val BindRecipeResponse = bindRecipeResponse
    var clickedPosition: Int = 0
    var recipeImageUrl: String = ""
    //lateinit var recipeDetails: getRecipeInfo

    init {
        //println(recipeDetails.recipeImageUrl)
    }

    fun getRecipe() : getRecipeInfo{
        return bindRecipeResponse.recipeArray[clickedPosition]
    }

    fun setTopImage(){

    }
}