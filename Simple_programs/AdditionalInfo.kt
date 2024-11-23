package com.example.example

import com.google.gson.annotations.SerializedName


data class AdditionalInfo (

  @SerializedName("key_highlights"   ) var keyHighlights   : ArrayList<String> = arrayListOf(),
  @SerializedName("assurance_widget" ) var assuranceWidget : ArrayList<String> = arrayListOf()

)