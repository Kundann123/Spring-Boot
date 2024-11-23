package com.example.example

import com.google.gson.annotations.SerializedName


data class AdditionalAttr (

  @SerializedName("bby_lod" ) var bbyLod : String?         = null,
  @SerializedName("info"    ) var info   : ArrayList<Info> = arrayListOf()

)