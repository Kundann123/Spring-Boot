package com.example.example

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("product" ) var product : Product? = Product()

)