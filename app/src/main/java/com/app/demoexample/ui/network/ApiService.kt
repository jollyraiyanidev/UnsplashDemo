package com.app.demoexample.ui.network

import com.app.demoexample.ui.data.GetImages
import com.app.demoexample.ui.data.GetImagesItem
import com.app.demoexample.ui.data.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("photos")
    suspend fun getUnsplashImages(
        @Query("client_id") accessKey: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 16,
    ): List<GetImagesItem>
}