package com.example.springapitest.data.repository

import com.example.springapitest.data.source.remote.ApiService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module // Hilt 모듈임을 명시
@InstallIn(SingletonComponent::class) // Hilt의 싱글톤으로 사용
object RetrofitModule {// Retrofit 객체 생성 object는 싱클톤 패턴을 간단하게 구현해줌 어플리케이션 내에서 1회만 초기화
    
    private val retrofit: Retrofit = Retrofit.Builder() // Retrofit 객체 생성
        .baseUrl("http://10.0.2.2:8080/") // Android 에뮬레이터에서 localhost에 접근할 때 사용하는 주소
        .addConverterFactory(GsonConverterFactory.create()) // Gson을 사용하기 위해 ConverterFactory에 Gson 지정
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java) //api 인터페이스를 초기화해 서버에 api 요청


}