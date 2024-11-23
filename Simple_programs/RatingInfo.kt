package com.example.example

import com.google.gson.annotations.SerializedName


data class RatingInfo (

  @SerializedName("avg_rating"   ) var avgRating   : String? = null,
  @SerializedName("rating_count" ) var ratingCount : String? = null,
  @SerializedName("review_count" ) var reviewCount : String? = null,
  @SerializedName("sku_id"       ) var skuId       : Int?    = null

)