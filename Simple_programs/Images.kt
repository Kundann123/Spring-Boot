package com.example.example

import com.google.gson.annotations.SerializedName


data class Images (

  @SerializedName("s"   ) var s   : String? = null,
  @SerializedName("l"   ) var l   : String? = null,
  @SerializedName("ml"  ) var ml  : String? = null,
  @SerializedName("m"   ) var m   : String? = null,
  @SerializedName("xl"  ) var xl  : String? = null,
  @SerializedName("xxl" ) var xxl : String? = null

)