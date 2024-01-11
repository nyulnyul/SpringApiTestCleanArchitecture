package com.example.springapitest.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.springapitest.data.model.UserModel
import com.example.springapitest.data.repository.RetrofitModule
import com.example.springapitest.data.repository.UserDTO
import com.example.springapitest.data.source.remote.ApiService

import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    val isLoginSuccess = MutableLiveData<Boolean>()//로그인 성공 여부를 저장하는 변수
    val loginErrorMessage = MutableLiveData<String>()//로그인 실패시 에러 메시지를 저장하는 변수

    fun login(email: String, password: String) {
        val loginDto = UserDTO(email, password)
        viewModelScope.launch {
            val response = RetrofitModule.apiService.login(loginDto)
            if (response.isSuccessful) {
                isLoginSuccess.postValue(true)//로그인 성공시 true 저장
            } else {
                isLoginSuccess.postValue(false)//로그인 실패시 false 저장
                loginErrorMessage.postValue("아이디 또는 비밀번호가 다릅니다.")//로그인 실패시 에러 메시지 저장
            }
        }
    }
}
