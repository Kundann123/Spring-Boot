package com.example.example

import com.google.gson.annotations.SerializedName


data class Breadcrumb (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("slug" ) var slug : String? = null,
  @SerializedName("type" ) var type : String? = null,
  @SerializedName("url"  ) var url  : String? = null

)