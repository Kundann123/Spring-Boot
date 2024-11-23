package com.example.example

import com.google.gson.annotations.SerializedName


data class VariableWeight (

  @SerializedName("msg"  ) var msg  : String? = null,
  @SerializedName("link" ) var link : String? = null

)