package com.example.example

import com.google.gson.annotations.SerializedName


data class Tags (

  @SerializedName("header" ) var header : String?           = null,
  @SerializedName("values" ) var values : ArrayList<Values> = arrayListOf()

)