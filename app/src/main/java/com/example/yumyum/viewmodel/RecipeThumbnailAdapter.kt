package com.example.yumyum.viewmodel

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Layout
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestOptions
import com.example.yumyum.R
import com.example.yumyum.model.RecipeThumbnailBackground
import com.example.yumyum.model.network.API.*
import com.example.yumyum.view.ItemDecoration
import java.util.zip.Inflater

class RecipeThumbnailAdapter(val context: Context, val thumbnail: ArrayList<getRecipeInfo>) : RecyclerView.Adapter<RecipeThumbnailAdapter.recipeItemViewHolder>(){
    var recipeThumbnailBackground: RecipeThumbnailBackground = RecipeThumbnailBackground()
    init {
        recipeThumbnailBackground.setBackground()
        //itemDecoration.spaceBetweenItem(5)
    }

    class recipeItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val imageViewBackground: ImageView = view.findViewById(R.id.recipeThumbnailBackgroundItems)
        val imageView: ImageView = view.findViewById(R.id.recipeThumbnailItems)
        val catTextView: TextView = view.findViewById(R.id.recipeThumbnailCat)
        val recipeName : TextView = view.findViewById(R.id.recipeNameThumbnail)
        val cookingTime : TextView = view.findViewById(R.id.cookingTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recipeItemViewHolder {
        val recipeThumbnailInflater: View = LayoutInflater.from(parent.context).inflate(R.layout.recipe_thumbnail_items, parent, false)
        return recipeItemViewHolder(recipeThumbnailInflater)
    }

    override fun onBindViewHolder(holder: recipeItemViewHolder, position: Int) {
        //Glide.with(context).load("https://spoonacular.com/recipeImages/638385-556x370.jpg").into(holder.imageView)

        val item = thumbnail[position]
        var cat = ""
        if(thumbnail[position].dishType.isNotEmpty()){
            println(thumbnail[position].dishType)
            for(i in 1..thumbnail[position].dishType.size -1){
                cat += thumbnail[position].dishType[i] + "     "
            }
            if(cat == ""){
                cat = "empty"
            }
        }

        var requestOption = RequestOptions()
        requestOption = requestOption.transform(FitCenter())
        Glide.with(context).load(recipeThumbnailBackground.background[recipeThumbnailBackground.randNumber(0, 3)]).placeholder(R.mipmap.yellow_pepper_background).apply(requestOption).skipMemoryCache(true).into(holder.imageViewBackground)
        Glide.with(context).load(thumbnail[position].recipeImageUrl).placeholder(R.mipmap.placeholder).apply(requestOption).skipMemoryCache(true).into(holder.imageView)
        holder.imageViewBackground
        holder.imageView
        holder.catTextView.setTypeface(null, Typeface.BOLD)
        holder.catTextView.textSize = 10f
        holder.catTextView.setTextColor(Color.WHITE)
        holder.catTextView.text = cat
        holder.recipeName.setTypeface(null, Typeface.BOLD)
        holder.recipeName.setTextColor(Color.WHITE)

        if(thumbnail[position].recipeName.isNotEmpty() && thumbnail[position].recipeName.length > 36){
            holder.recipeName.text = thumbnail[position].recipeName.substring(0, 32) + "..."
        } else {
            holder.recipeName.text = thumbnail[position].recipeName
        }

        holder.cookingTime.setTypeface(null, Typeface.BOLD)
        holder.cookingTime.setTextColor(Color.WHITE)
        holder.cookingTime.textSize = 12f
        holder.cookingTime.text = thumbnail[position].cookingTime.toString()
    }

    override fun getItemCount(): Int {
        println(thumbnail.size)
        return thumbnail.size
    }
}

