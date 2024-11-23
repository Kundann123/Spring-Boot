package com.example.example

import com.google.gson.annotations.SerializedName


data class Tabs (

  @SerializedName("content" ) var content : String? = null,
  @SerializedName("title"   ) var title   : String? = null

)