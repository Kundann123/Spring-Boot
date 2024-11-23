package com.example.example

import com.google.gson.annotations.SerializedName


data class Availability (

  @SerializedName("avail_status" ) var availStatus : String?  = null,
  @SerializedName("short_eta"    ) var shortEta    : String?  = null,
  @SerializedName("medium_eta"   ) var mediumEta   : String?  = null,
  @SerializedName("long_eta"     ) var longEta     : String?  = null,
  @SerializedName("label"        ) var label       : String?  = null,
  @SerializedName("display_mrp"  ) var displayMrp  : Boolean? = null,
  @SerializedName("display_sp"   ) var displaySp   : Boolean? = null,
  @SerializedName("not_for_sale" ) var notForSale  : Boolean? = null,
  @SerializedName("button"       ) var button      : String?  = null,
  @SerializedName("show_express" ) var showExpress : Boolean? = null

)