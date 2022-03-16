package com.example.yumyum.model.network.API

class bindRecipeResponse {
    public var recipeArray: ArrayList<getRecipeInfo> = ArrayList()
    public var imageRecipeUrl: ArrayList<String> = ArrayList()
    public var isComplete: Boolean = false

    val getRecipe: getRecipe = getRecipe()

    /*init {
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
        })*/

        fun bindRecipeResponseCallback(callback: (result: ArrayList<getRecipeInfo>) -> Unit){
            getRecipe.getResponseRecipe(object : ApiCallback<getRecipeResponse> {
                override fun onSucces(t: getRecipeResponse) {
                    println("SUCCESS !")
                    println(t)
                    for(i in t.recipe.indices){
                        recipeArray.add(t.recipe[i])
                        imageRecipeUrl.add(t.recipe[i].recipeImageUrl)
                    }
                    callback.invoke(recipeArray)
                }

                override fun onError(error: String) {
                    println("ERROR !")
                }

                override fun onException(error: Throwable) {
                    println("EXCEPTION !")
                }
            })
        }
}