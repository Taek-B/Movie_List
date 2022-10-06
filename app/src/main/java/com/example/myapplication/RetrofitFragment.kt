package com.example.myapplication

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.myapplication.databinding.FragmentRetrofitBinding
import com.example.myapplication.model.BoxOfficeResult
import com.example.myapplication.model.PageListModel
import com.example.myapplication.recycler.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate


class RetrofitFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRetrofitBinding.inflate(inflater, container, false)
        var targetDt:String? = this.arguments?.get("targetDt").toString()
        Log.d("myLog","targetDt 값 : ${targetDt}")
        if(targetDt == "null"){
            targetDt = "20220101"
        }
        val call:Call<BoxOfficeResult> = MyApplication.networkService.getList(
            MyApplication.API_KEY,
            "${targetDt}"
        )
        call?.enqueue(object :Callback<BoxOfficeResult>{
            override fun onResponse(call: Call<BoxOfficeResult>, response: Response<BoxOfficeResult>) {
                //성공시 호출
                Log.d("myLog","response.raw() : ${response.raw()}")
                Log.d("myLog","response.body() : ${response.body()}")
                if (response.isSuccessful) {
                    binding.retrofitRecyclerView.layoutManager = LinearLayoutManager(activity)
                    binding.retrofitRecyclerView.adapter =
                        MyAdapter(activity as Context, response.body()?.boxOfficeResult?.dailyBoxOfficeList)
                }
            }
            override fun onFailure(call: Call<BoxOfficeResult>, t: Throwable) {
                //실패시 호출
                Log.d("myLog","error 입니다.")
            }
        })
        return binding.root
    }
}
