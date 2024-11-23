package com.example.example

import com.google.gson.annotations.SerializedName


data class CampDetail (

  @SerializedName("c"            ) var c           : ArrayList<String> = arrayListOf(),
  @SerializedName("r_c"          ) var rC          : ArrayList<String> = arrayListOf(),
  @SerializedName("d_t"          ) var dT          : String?           = null,
  @SerializedName("d_v"          ) var dV          : Int?              = null,
  @SerializedName("v_f"          ) var vF          : Int?              = null,
  @SerializedName("m_f"          ) var mF          : Int?              = null,
  @SerializedName("c_f"          ) var cF          : Int?              = null,
  @SerializedName("narq"         ) var narq        : Int?              = null,
  @SerializedName("dual_pricing" ) var dualPricing : Boolean?          = null

)