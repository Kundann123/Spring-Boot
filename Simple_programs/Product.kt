package com.example.example

import com.google.gson.annotations.SerializedName


data class Product (

  @SerializedName("base_img_url"    ) var baseImgUrl     : String?               = null,
  @SerializedName("id"              ) var id             : String?               = null,
  @SerializedName("desc"            ) var desc           : String?               = null,
  @SerializedName("pack_desc"       ) var packDesc       : String?               = null,
  @SerializedName("sort_index_pos"  ) var sortIndexPos   : Int?                  = null,
  @SerializedName("w"               ) var w              : String?               = null,
  @SerializedName("absolute_url"    ) var absoluteUrl    : String?               = null,
  @SerializedName("cart_count"      ) var cartCount      : Int?                  = null,
  @SerializedName("availability"    ) var availability   : Availability?         = Availability(),
  @SerializedName("images"          ) var images         : ArrayList<Images>     = arrayListOf(),
  @SerializedName("variable_weight" ) var variableWeight : VariableWeight?       = VariableWeight(),
  @SerializedName("brand"           ) var brand          : Brand?                = Brand(),
  @SerializedName("additional_attr" ) var additionalAttr : AdditionalAttr?       = AdditionalAttr(),
  @SerializedName("tabs"            ) var tabs           : ArrayList<Tabs>       = arrayListOf(),
  @SerializedName("tags"            ) var tags           : ArrayList<Tags>       = arrayListOf(),
  @SerializedName("combo"           ) var combo          : String?               = null,
  @SerializedName("category"        ) var category       : Category?             = Category(),
  @SerializedName("rating_info"     ) var ratingInfo     : RatingInfo?           = RatingInfo(),
  @SerializedName("breadcrumb"      ) var breadcrumb     : ArrayList<Breadcrumb> = arrayListOf(),
  @SerializedName("aplus_url"       ) var aplusUrl       : String?               = null,
  @SerializedName("additional_info" ) var additionalInfo : AdditionalInfo?       = AdditionalInfo(),
  @SerializedName("pricing"         ) var pricing        : Pricing?              = Pricing(),
  @SerializedName("children"        ) var children       : ArrayList<Children>   = arrayListOf()

)