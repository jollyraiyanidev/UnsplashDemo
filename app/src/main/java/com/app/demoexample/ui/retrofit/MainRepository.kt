package com.app.demoexample.ui.retrofit

import com.app.demoexample.ui.data.GetImagesItem
import com.app.demoexample.ui.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository
@Inject
constructor(private val apiService: ApiService) {
    fun getPost(accessKey: String, pageNum: Int): Flow<List<GetImagesItem>> = flow {
        emit(apiService.getUnsplashImages(accessKey, pageNum))
    }.flowOn(Dispatchers.IO)
}