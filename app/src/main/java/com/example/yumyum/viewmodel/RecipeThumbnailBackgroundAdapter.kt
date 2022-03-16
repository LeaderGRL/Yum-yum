/*package com.example.yumyum.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestOptions
import com.example.yumyum.R
import com.example.yumyum.databinding.CategoryNavFragmentBinding.inflate
import com.example.yumyum.model.RecipeThumbnailBackground

class RecipeThumbnailBackgroundAdapter(val context: Context, val backgroundArray: ArrayList<Int>) : RecyclerView.Adapter<RecipeThumbnailBackgroundAdapter.recipeItemViewHolder>() {
    val background: RecipeThumbnailBackground = RecipeThumbnailBackground()
    var randomBackground: ArrayList<ImageView> = ArrayList()
    var test: ArrayList<ImageView> = ArrayList()
    init {

    }

    class recipeItemViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val imageView: ImageView = view.findViewById(R.id.recipeThumbnailBackgroundItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recipeItemViewHolder {
        val recipeThumbnailInflater: View = LayoutInflater.from(parent.context).inflate(R.layout.recipe_thumbnail_background_items, parent, false)
        background.setBackground()
        var image: ImageView = ImageView(context)
        for(i in 1..10){
            image.setImageResource(backgroundArray[0])
            test.add(image)

        }
        //randomBackground = background.setImageView(context, 10)
        println("BACKGROUNDD !")
        println(test)
        return recipeItemViewHolder(recipeThumbnailInflater)
    }

    override fun onBindViewHolder(holder: recipeItemViewHolder, position: Int) {
        //background.setImageView(context, 10)

        //val item = randomBackground[position]
        var requestOption = RequestOptions()
        requestOption = requestOption.transform(FitCenter())
        Glide.with(context).load(backgroundArray[0]).apply(requestOption).skipMemoryCache(true).into(holder.imageView)
        holder.imageView
    }

    override fun getItemCount(): Int {
        println("BACKGROUND SIZEEE")
        println(backgroundArray.size)
        return backgroundArray.size
    }
}*/