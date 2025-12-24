package com.example.pizzaapp3403.client

object RetrofitClient {
    const val BASE_URL = "http://192.168.100.87:80/rest_api3403/index.php/"

    val instance:Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseurl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
    retrofit.create(Api::class.java)
}