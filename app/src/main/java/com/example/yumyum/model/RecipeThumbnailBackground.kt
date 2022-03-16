package com.example.yumyum.model

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.yumyum.R
import kotlin.random.Random

class RecipeThumbnailBackground {
    public var background: ArrayList<Int> = ArrayList()

    init {

    }

    fun setBackground(){
        background.add(R.mipmap.green_pepper_background)
        background.add(R.mipmap.yellow_pepper_background)
        background.add(R.mipmap.red_pepper_background)
    }

    fun randNumber(min: Int, max: Int) : Int{
        val random: Random = Random
        return random.nextInt(max-min) + min
    }

    fun setImageView(context: Context, range: Int) : ArrayList<ImageView>{
        val backgroundImage: ArrayList<ImageView> = ArrayList()
        val image: ImageView = ImageView(context)
        val view: View = View(context)
        //image = view.findViewById(R.id.recipeThumbnailBackgroundItems)!!
        for(i in 1..range){
            image.setImageResource(background[randNumber(2, 3)])
            backgroundImage.add(image)
        }
        return backgroundImage
    }
}