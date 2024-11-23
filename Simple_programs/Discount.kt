package com.example.example

import com.google.gson.annotations.SerializedName


data class Discount (

  @SerializedName("mrp"              ) var mrp            : String?     = null,
  @SerializedName("d_text"           ) var dText          : String?     = null,
  @SerializedName("d_avail"          ) var dAvail         : String?     = null,
  @SerializedName("prim_price"       ) var primPrice      : PrimPrice?  = PrimPrice(),
  @SerializedName("sec_price"        ) var secPrice       : SecPrice?   = SecPrice(),
  @SerializedName("offer_entry_text" ) var offerEntryText : String?     = null,
  @SerializedName("offer_available"  ) var offerAvailable : String?     = null,
  @SerializedName("camp_detail"      ) var campDetail     : CampDetail? = CampDetail()

)