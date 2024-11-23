package com.example.example

import com.google.gson.annotations.SerializedName


data class Category (

  @SerializedName("tlc_name" ) var tlcName : String? = null,
  @SerializedName("tlc_slug" ) var tlcSlug : String? = null,
  @SerializedName("llc_slug" ) var llcSlug : String? = null,
  @SerializedName("llc_name" ) var llcName : String? = null,
  @SerializedName("llc_id"   ) var llcId   : Int?    = null

)