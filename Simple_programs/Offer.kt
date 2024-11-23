package com.example.example

import com.google.gson.annotations.SerializedName


data class Offer (

  @SerializedName("offer_available"    ) var offerAvailable   : String?           = null,
  @SerializedName("offer_entry_text"   ) var offerEntryText   : String?           = null,
  @SerializedName("offer_ent_txt"      ) var offerEntTxt      : String?           = null,
  @SerializedName("text_color"         ) var textColor        : String?           = null,
  @SerializedName("background"         ) var background       : Background?       = Background(),
  @SerializedName("background_border"  ) var backgroundBorder : BackgroundBorder? = BackgroundBorder(),
  @SerializedName("arrow_image"        ) var arrowImage       : String?           = null,
  @SerializedName("campaign_type"      ) var campaignType     : String?           = null,
  @SerializedName("campaign_type_slug" ) var campaignTypeSlug : String?           = null,
  @SerializedName("campaign_type_icon" ) var campaignTypeIcon : String?           = null

)