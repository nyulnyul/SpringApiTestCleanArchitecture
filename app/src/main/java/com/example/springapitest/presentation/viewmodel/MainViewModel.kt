package com.example.springapitest.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.springapitest.data.model.UserModel

import com.example.springapitest.data.repository.RetrofitModule
import com.example.springapitest.data.repository.User

import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {
    private val _userData = mutableStateOf<UserModel?>(null)
    val userData: State<UserModel?> = _userData

    fun registerUser( password: String, name: String, email: String) {
        viewModelScope.launch {
            try {
                val user = User(password, name, email) // Request 객체 생성
                val response = RetrofitModule.apiService.registerUser(user)
                if(response.isSuccessful) {
                    // Response에서 body를 추출하여 상태에 할당
                    _userData.value = response.body()
                } else {
                    // 에러 처리
                    Log.e("MainViewModel", "Error: ${response.errorBody()?.string()}")
                }
                Log.d("MainViewModel", response.toString())
            } catch (e: Exception) {
                Log.e("MainViewModel", e.toString())
            }
        }
    }
}