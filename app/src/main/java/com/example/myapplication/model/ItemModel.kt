package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

//class ItemModel {
//    var id : Long = 0
//    var author: String? = null
//    var title: String? = null
//    var description: String? = null
//    var urlToImage: String? = null
//    var publishedAt: String? = null
//}

//data class ItemModel (
//    var id : Long,
//    var author: String,
//    var title: String,
//    var description: String,
//    var urlToImage: String,
//    var publishedAt: String
//    )

data class ItemModel (
    var rank : Long,
    var movieNm: String,
    var openDt: String,
    var rankInten: String
)



