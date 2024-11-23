package com.example.example

import com.google.gson.annotations.SerializedName


data class SecPrice (

  @SerializedName("sp"         ) var sp         : String? = null,
  @SerializedName("icon"       ) var icon       : String? = null,
  @SerializedName("desc"       ) var desc       : String? = null,
  @SerializedName("background" ) var background : String? = null

)