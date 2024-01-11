package com.example.springapitest.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.springapitest.data.model.UserModel

import com.example.springapitest.data.repository.RetrofitModule
import com.example.springapitest.data.repository.User

import kotlinx.coroutines.launch


class RegisterViewModel: ViewModel() { //viewmodel 클래스 선언
    val isRegisterSuccess = MutableLiveData<Boolean>()//로그인 성공 여부를 저장하는 변수
    val registerErrorMessage = MutableLiveData<String>()//로그인 실패시 에러 메시지를 저장하는 변수


    private val _userData = mutableStateOf<UserModel?>(null) //UserModel형태의 데이터를 담는 상태 변수 선언
    val userData: State<UserModel?> = _userData //_userData를 ui에서 읽을 수 있게 선언

    fun registerUser( password: String, name: String, email: String) {
        viewModelScope.launch { //코루틴을 실행해 ViewModel의 생명주기에 맞추어 코루틴을 관리하는 Scope
            try {
                val user = User(password, name, email) // Request 객체 생성
                val response = RetrofitModule.apiService.registerUser(user) //apiService의 registerUser 메소드를 호출하여 서버에 요청후 응답을 response에 저장
                if(response.isSuccessful) {
                    // Response에서 body를 추출하여 상태에 할당
                    _userData.value = response.body() //서버로 부터 받은 응답을 _userData에 저장해 서버로 부터 받은 데이터 읽기 가능
                    isRegisterSuccess.postValue(true)//로그인 성공시 true 저장
                } else {
                    // 에러 처리
                    Log.e("MainViewModel", "Error: ${response.errorBody()?.string()}")
                    isRegisterSuccess.postValue(false)//로그인 실패시 false 저장
                    registerErrorMessage.postValue("회원가입 실패")//로그인 실패시 에러 메시지 저장
                }
                Log.d("MainViewModel", response.toString())
            } catch (e: Exception) {
                Log.e("MainViewModel", e.toString())
            }
        }
    }
}