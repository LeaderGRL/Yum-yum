package com.example.yumyum.model.network.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*object Api : Call<List<Any>> {
    public val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
}*/
class APIInstance(java: Class<IApi>) {

    private lateinit var api: IApi
    private lateinit var instance: APIInstance
    val retrofit: Retrofit = Retrofit.Builder().baseUrl(IApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    //lateinit var retrofit: Retrofit

    init {

        //val retrofit: Retrofit = Retrofit.Builder().baseUrl(IApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        api = retrofit.create(IApi::class.java)
        println(IApi.BASE_URL)
    }

    fun getInstance() : APIInstance{
        if(instance == null){
            instance = APIInstance(IApi::class.java)
        }
        return instance
    }

    fun getApi() : IApi{
        return api
    }
    /*interface IApi {
        companion object {
            val BASE_URL: String = "test"

        }
    }*/

}