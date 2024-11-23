package com.example.example

import com.google.gson.annotations.SerializedName


data class Pricing (

  @SerializedName("offer"    ) var offer    : Offer?    = Offer(),
  @SerializedName("discount" ) var discount : Discount? = Discount(),
  @SerializedName("promo"    ) var promo    : String?   = null

)