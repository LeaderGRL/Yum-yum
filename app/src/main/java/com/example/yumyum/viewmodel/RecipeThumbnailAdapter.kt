package com.example.yumyum.viewmodel

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestOptions
import com.example.yumyum.R
import com.example.yumyum.model.network.API.ApiCallback
import com.example.yumyum.model.network.API.getRecipe
import com.example.yumyum.model.network.API.getRecipeInfo
import com.example.yumyum.model.network.API.getRecipeResponse
import java.util.zip.Inflater

class RecipeThumbnailAdapter(val context: Context) : RecyclerView.Adapter<RecipeThumbnailAdapter.recipeItemViewHolder>(){

    var recipeArray: ArrayList<getRecipeInfo> = ArrayList()
    var imageRecipeUrl: ArrayList<String> = ArrayList()

    val getRecipe: getRecipe = getRecipe()

    init {
        getRecipe.getResponseRecipe(object : ApiCallback<getRecipeResponse> {
            override fun onSucces(t: getRecipeResponse) {
                println("SUCCES !")
                println(t)
                for(i in t.recipe.indices){
                    recipeArray.add(t.recipe[i])
                    imageRecipeUrl.add(t.recipe[i].recipeImageUrl)
                }

            }

            override fun onError(error: String) {
                println("ERROR !")
            }

            override fun onException(error: Throwable) {
                println("EXCEPTION !")
            }
        })
    }

    class recipeItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.recipeThumbnailItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recipeItemViewHolder {
        val recipeThumbnailInflater: View = LayoutInflater.from(parent.context).inflate(R.layout.recipe_thumbnail_items, parent, false)

        return recipeItemViewHolder(recipeThumbnailInflater)
    }

    override fun onBindViewHolder(holder: recipeItemViewHolder, position: Int) {
        val item = recipeArray[position]
        var requestOption = RequestOptions()
        requestOption = requestOption.transform(FitCenter())
        Glide.with(context).load(imageRecipeUrl).apply(requestOption).skipMemoryCache(true).into(holder.imageView)
        holder.imageView

        println("OUIII $imageRecipeUrl[0]")
    }

    override fun getItemCount(): Int {
        return recipeArray.size
    }
}