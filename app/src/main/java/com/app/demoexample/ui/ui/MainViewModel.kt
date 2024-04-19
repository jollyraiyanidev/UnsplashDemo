package com.app.demoexample.ui.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.demoexample.BuildConfig
import com.app.demoexample.ui.retrofit.MainRepository
import com.app.demoexample.ui.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<ApiState>(ApiState.Empty)
    val uiState: StateFlow<ApiState> = _uiState.asStateFlow()


    private val _eventFlow = MutableSharedFlow<ApiState>()
    val eventFlow = _eventFlow.asSharedFlow()

    // val response: MutableState<ApiState> = mutableStateOf(ApiState.Empty)
    private var pageNum = 1

    init {
        getPost()
    }

    fun getPost() =
        viewModelScope.launch {
            mainRepository.getPost(BuildConfig.TOKEN, pageNum++).onStart {
                _uiState.value = ApiState.Loading
            }.catch {
                _uiState.value = ApiState.Failure(it)
            }.collect {
                _uiState.value = ApiState.Success(it)
            }
        }
}