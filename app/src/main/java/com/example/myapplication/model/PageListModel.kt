package com.example.myapplication.model

//class PageListModel{
//    val articles: MutableList<ItemModel>?= null
//}

data class PageListModel (
    var boxofficeType : String,
    var dailyBoxOfficeList: MutableList<ItemModel>
)

data class BoxOfficeResult(
    var boxOfficeResult: PageListModel
)