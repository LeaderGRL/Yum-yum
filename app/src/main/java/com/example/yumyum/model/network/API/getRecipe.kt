package com.example.yumyum.model.network.API

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson
import java.util.*

class getRecipe() : ApiCallback<getRecipeResponse>{
    val apiInstance: APIInstance = APIInstance(IApi::class.java)

    init {
        //getResponseRecipe()
    }

    fun getResponseRecipe(callback: ApiCallback<getRecipeResponse>) {
        println("GETRECIPE!")
        /*val retrofit: Retrofit = Retrofit.Builder().baseUrl(IApi.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()*/
        val responseCallback: Callback<getRecipeResponse>
        //val call: Call<List<getRecipeResponse>> = apiInstance.getInstance().getApi()
        apiInstance.retrofit.create(IApi::class.java).recipe.enqueue(object: Callback<getRecipeResponse>{
            override fun onResponse(call: Call<getRecipeResponse>, response: Response<getRecipeResponse>){
                println("RESPONSE!")
                if(response.body() != null){
                    val recipeList: getRecipeResponse? = response.body()
                    val gson: Gson = Gson()
                    if (recipeList != null) {
                        callback.onSucces(recipeList)
                        //println(recipeList.recipe[1].recipeImageUrl)
                        //var recipeJson: String = gson.toJson(recipeList.recipe)
                        //var test: getRecipeResponse = gson.fromJson(recipeJson, getRecipeResponse::class.java)
                        //println(test)
                    }
                    /*for(i in recipeList){
                        println("Recipe URL : ${i.recipeName}")
                    }*/
                }
            }

            override fun onFailure(call: Call<getRecipeResponse>, t: Throwable) {
                error(t)
            }
        })
    }

    override fun onException(error: Throwable){
        println("exception")
    }

    override fun onError(error: String) {
        println("error")
    }

    override fun onSucces(t: getRecipeResponse) {
        println(t)
    }

    fun getData(objects: ApiCallback<getRecipeResponse>){
        //apiInstance.retrofit.create(IApi::class.java).recipe.enqueue(callback)
    }

}



