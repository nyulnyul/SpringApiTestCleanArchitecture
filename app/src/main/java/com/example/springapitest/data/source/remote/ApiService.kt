package com.example.springapitest.data.source.remote

import com.example.springapitest.data.model.UserModel
import com.example.springapitest.data.repository.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService { //서버와 통신위한 메소드 정의
    @POST("users/register") //retrofit2 어노테이샨을 통해 registerUser메소드가 서버의 users/register 경로에 POST 요청
    suspend fun registerUser( //코루틴을 통해 비동기적으로 실행되는 함수임을 정의
        //suspend란 코루틴을 사용해 비동기 처리하겠다는 것을 의미하여 이 키워드가 붙은 함수는 코루틴 혹은 다른 suspend 함수 내에서만 호출 가능
        @Body user: User // Request Body에 User 객체를 담아 보냄
    ): Response<UserModel> // Response는 retrtofit 클래스의 http응답을 나타내며 서버로 받은 응답이 UserModel형태의 데이터를 담음을 의미
}