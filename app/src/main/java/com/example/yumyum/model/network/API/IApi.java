package com.example.yumyum.model.network.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IApi {
    String BASE_URL = "https://api.spoonacular.com/";
    @GET("recipes/random?number=10&apiKey=63545f6766ff4238a36a974f0a9b741d")
    Call<getRecipeResponse> getRecipe();
}
