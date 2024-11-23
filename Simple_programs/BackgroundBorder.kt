package com.example.example

import com.google.gson.annotations.SerializedName


data class BackgroundBorder (

  @SerializedName("gradient"  ) var gradient  : String? = null,
  @SerializedName("direction" ) var direction : String? = null

)