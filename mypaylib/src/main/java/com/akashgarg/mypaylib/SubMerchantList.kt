package com.akashgarg.mypaylib

import com.google.gson.annotations.SerializedName

data class SubMerchantList(

	@field:SerializedName("subMerchant")
	val subMerchant: List<Any?>? = null
)