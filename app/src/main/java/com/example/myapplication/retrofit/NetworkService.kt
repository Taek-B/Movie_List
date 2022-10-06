package com.example.myapplication.retrofit

import com.example.myapplication.model.BoxOfficeResult
import com.example.myapplication.model.PageListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {
    //네트워킹을 위한 함수 작성
//    @GET("/v2/top-headlines")
    @GET("/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json")
    fun getList(
//        @Query("apiKey") apiKey: String?,
//        @Query("country") country: String?,
//        @Query("category") category: String?

        @Query("key") apiKey: String?,
        @Query("targetDt") targetDt: String?
    ): Call<BoxOfficeResult> //결과를 PageListModel에 담는다.
}
