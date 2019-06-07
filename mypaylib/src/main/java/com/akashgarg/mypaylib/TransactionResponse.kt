package com.akashgarg.mypaylib

import com.google.gson.annotations.SerializedName

data class TransactionResponse(

	@field:SerializedName("dateTime")
	val dateTime: String? = null,

	@field:SerializedName("paidAgent")
	val paidAgent: String? = null,

	@field:SerializedName("approvalCode")
	val approvalCode: String? = null,

	@field:SerializedName("subMerchantID")
	val subMerchantID: String? = null,

	@field:SerializedName("backendInvoice")
	val backendInvoice: String? = null,

	@field:SerializedName("amt")
	val amt: String? = null,

	@field:SerializedName("eci")
	val eci: String? = null,

	@field:SerializedName("bankName")
	val bankName: String? = null,

	@field:SerializedName("tranRef")
	val tranRef: String? = null,

	@field:SerializedName("failReason")
	val failReason: String? = null,

	@field:SerializedName("ippInterestRate")
	val ippInterestRate: String? = null,

	@field:SerializedName("pan")
	val pan: String? = null,

	@field:SerializedName("ippPeriod")
	val ippPeriod: String? = null,

	@field:SerializedName("uniqueTransactionCode")
	val uniqueTransactionCode: String? = null,

	@field:SerializedName("recurringUniqueID")
	val recurringUniqueID: String? = null,

	@field:SerializedName("raw")
	val raw: String? = null,

	@field:SerializedName("version")
	val version: String? = null,

	@field:SerializedName("hashValue")
	val hashValue: String? = null,

	@field:SerializedName("paymentChannel")
	val paymentChannel: String? = null,

	@field:SerializedName("issuerCountry")
	val issuerCountry: String? = null,

	@field:SerializedName("timeStamp")
	val timeStamp: String? = null,

	@field:SerializedName("refNumber")
	val refNumber: String? = null,

	@field:SerializedName("merchantID")
	val merchantID: String? = null,

	@field:SerializedName("ippMerchantAbsorbRate")
	val ippMerchantAbsorbRate: String? = null,

	@field:SerializedName("userDefined4")
	val userDefined4: String? = null,

	@field:SerializedName("userDefined5")
	val userDefined5: String? = null,

	@field:SerializedName("paidChannel")
	val paidChannel: String? = null,

	@field:SerializedName("userDefined2")
	val userDefined2: String? = null,

	@field:SerializedName("subMerchantList")
	val subMerchantList: SubMerchantList? = null,

	@field:SerializedName("userDefined3")
	val userDefined3: String? = null,

	@field:SerializedName("ippInterestType")
	val ippInterestType: String? = null,

	@field:SerializedName("userDefined1")
	val userDefined1: String? = null,

	@field:SerializedName("respCode")
	val respCode: String? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("storeCardUniqueID")
	val storeCardUniqueID: String? = null
){
	override fun toString(): String {
		return "dateTime=$dateTime, paidAgent=$paidAgent, approvalCode=$approvalCode, subMerchantID=$subMerchantID, backendInvoice=$backendInvoice, amt=$amt, eci=$eci, bankName=$bankName, tranRef=$tranRef, failReason=$failReason, ippInterestRate=$ippInterestRate, pan=$pan, ippPeriod=$ippPeriod, uniqueTransactionCode=$uniqueTransactionCode, recurringUniqueID=$recurringUniqueID, raw=$raw, version=$version, hashValue=$hashValue, paymentChannel=$paymentChannel, issuerCountry=$issuerCountry, timeStamp=$timeStamp, refNumber=$refNumber, merchantID=$merchantID, ippMerchantAbsorbRate=$ippMerchantAbsorbRate, userDefined4=$userDefined4, userDefined5=$userDefined5, paidChannel=$paidChannel, userDefined2=$userDefined2, subMerchantList=$subMerchantList, userDefined3=$userDefined3, ippInterestType=$ippInterestType, userDefined1=$userDefined1, respCode=$respCode, status=$status, storeCardUniqueID=$storeCardUniqueID"
	}
}