package com.example.example

import com.google.gson.annotations.SerializedName


data class PrimPrice (

  @SerializedName("base_price" ) var basePrice : String? = null,
  @SerializedName("base_unit"  ) var baseUnit  : String? = null,
  @SerializedName("sp"         ) var sp        : String? = null,
  @SerializedName("icon"       ) var icon      : Icon?   = Icon(),
  @SerializedName("desc"       ) var desc      : String? = null

)