package com.example.example

import com.google.gson.annotations.SerializedName


data class Values (

  @SerializedName("display_name" ) var displayName : String? = null,
  @SerializedName("dest_type"    ) var destType    : String? = null,
  @SerializedName("dest_slug"    ) var destSlug    : String? = null,
  @SerializedName("url"          ) var url         : String? = null

)