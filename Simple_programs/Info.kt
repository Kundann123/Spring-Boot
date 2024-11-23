package com.example.example

import com.google.gson.annotations.SerializedName


data class Info (

  @SerializedName("id"        ) var id       : String? = null,
  @SerializedName("type"      ) var type     : String? = null,
  @SerializedName("image_url" ) var imageUrl : String? = null,
  @SerializedName("sub_type"  ) var subType  : String? = null,
  @SerializedName("label"     ) var label    : String? = null,
  @SerializedName("position"  ) var position : String? = null

)