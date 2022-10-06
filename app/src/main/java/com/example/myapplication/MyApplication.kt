package com.example.myapplication
import android.app.Application
import com.example.myapplication.retrofit.NetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MyApplication: Application() {

    companion object {

        val API_KEY = "be45de692eb49ad85a1eb785e4340674"
        val BASE_URL = "https://www.kobis.or.kr"

//        val API_KEY = "079dac74a5f94ebdb990ecf61c8854b7"
//        val BASE_URL = "https://newsapi.org"


        val networkService:NetworkService
        val retrofit:Retrofit//레트로핏 최초 설정
        get()=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//데이터 컨버팅을 위한 세팅
                .build()
        init{
            networkService= retrofit.create(NetworkService::class.java)//인터페이스에 네트워킹이 가능하도록 생성
        }

    }

}