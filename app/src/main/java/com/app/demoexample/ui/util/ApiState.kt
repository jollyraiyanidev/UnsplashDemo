package com.app.demoexample.ui.util

import com.app.demoexample.ui.data.Post

sealed class ApiState {
    class Success(val data: List<*>) : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    data object Loading : ApiState()
    data object Empty : ApiState()


}