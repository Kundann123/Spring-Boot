package com.example.example

import com.google.gson.annotations.SerializedName


data class Brand (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("slug" ) var slug : String? = null,
  @SerializedName("url"  ) var url  : String? = null

)