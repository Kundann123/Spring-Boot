package com.example.example

import com.google.gson.annotations.SerializedName


data class Icon (

  @SerializedName("base_url" ) var baseUrl : String? = null,
  @SerializedName("image"    ) var image   : String? = null,
  @SerializedName("format"   ) var format  : String? = null

)