package com.example.yumyum.viewmodel

import androidx.lifecycle.ViewModel
import com.example.yumyum.model.network.API.RecipeCategory

class RecipeThumbnailViewModel : ViewModel() {
    val recipeCategory: RecipeCategory = RecipeCategory()
    fun setCategory(){
        recipeCategory.setFakeRecipeCategory()
    }
}