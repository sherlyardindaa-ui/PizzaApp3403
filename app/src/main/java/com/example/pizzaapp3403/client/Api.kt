package com.example.pizzaapp3403.client

interface Api {
    @FormUrlEncoded
    @POST("login")
    fun postLogin(
        @Field("username") username:String,
        @Field("password") password:String
    ): Call<LoginResponse>
}