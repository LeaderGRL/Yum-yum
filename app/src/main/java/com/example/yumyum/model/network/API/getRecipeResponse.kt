package com.example.yumyum.model.network.API
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName;

data class getRecipeResponse (
    @SerializedName("recipes")
    //@JsonAdapter(Deserializer::class)
    @Expose
    var recipe: List<getRecipeInfo>,
    /*@SerializedName("userId")
    @Expose
    var userId: Int,

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("body")
    @Expose
    var body: String*/

)

data class getRecipeInfo(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("vegetarian")
    @Expose
    var isVegetarian : Boolean,

    @SerializedName("vegan")
    @Expose
    var isVegan: Boolean,

    @SerializedName("glutenFree")
    @Expose
    var isGlutenFree: Boolean,

    @SerializedName("veryPopular")
    @Expose
    var isPopular: Boolean,

    @SerializedName("title")
    @Expose
    var recipeName: String,

    @SerializedName("readyInTime")
    @Expose
    var cookingTime: Float,

    @SerializedName("image")
    @Expose
    var recipeImageUrl: String,
)


