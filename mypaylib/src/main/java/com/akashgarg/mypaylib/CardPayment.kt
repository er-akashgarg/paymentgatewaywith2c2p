package com.akashgarg.mypaylib

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.ccpp.my2c2psdk.cores.My2c2pResponse
import com.ccpp.my2c2psdk.cores.My2c2pSDK
import com.ccpp.my2c2psdk.cores.My3DSActivity
import com.google.gson.Gson

/**
 * Created by Akash Garg on 22/05/19.
 */

open class CardPayment(var mContext: Activity) {
    private var secretKey: String = ""
    private var merchantID: String = ""
    private var uniqueTransactionCode: String = ""
    private var desc: String = ""
    private var amount: Double = 0.0
    private var currencyCode: String = ""
    private var my2c2pKey: String = ""
    private var requestCode = 1000
    private var productionMode = false
    private var storedCardPayment = false
    private var mobileNumber = ""
    private var userDefined1 = ""
    private var userDefined2 = ""

    companion object {
        @SuppressLint("StaticFieldLeak")
        var cardPaymentObj: CardPayment? = null

        fun init(context: Activity): CardPayment {
            if (cardPaymentObj == null) {
                cardPaymentObj = CardPayment(context)
            }
            return cardPaymentObj!!
        }
    }

    fun setRequestCode(requestCode: Int): CardPayment {
        this@CardPayment.requestCode = requestCode
        return cardPaymentObj!!
    }

    fun setSecretKey(secreateKey: String): CardPayment {
        this@CardPayment.secretKey = secreateKey
        return cardPaymentObj!!
    }

    fun set2c2pGenerateKey(my2c2pKey: String): CardPayment {
        this@CardPayment.my2c2pKey = my2c2pKey
        return cardPaymentObj!!
    }

    fun setMerchantID(merchantId: String): CardPayment {
        this@CardPayment.merchantID = merchantId
        return cardPaymentObj!!
    }

    fun setAmount(amount: Double): CardPayment {
        this@CardPayment.amount = amount
        return cardPaymentObj!!
    }

    fun setUniqueTransactionCode(code: String): CardPayment {
        this@CardPayment.uniqueTransactionCode = code
        return cardPaymentObj!!
    }

    fun setDescription(description: String): CardPayment {
        this@CardPayment.desc = description
        return cardPaymentObj!!
    }

    fun setCurrencyCode(currencyCode: String): CardPayment {
        this@CardPayment.currencyCode = currencyCode
        return cardPaymentObj!!
    }

    fun setProductionModeEnable(productionMode: Boolean): CardPayment {
        this@CardPayment.productionMode = productionMode
        return cardPaymentObj!!
    }

    fun setStoredCardPayment(storedCardPayment: Boolean): CardPayment {
        this@CardPayment.storedCardPayment = storedCardPayment
        return cardPaymentObj!!
    }

    fun setMobileNumber(mobileNumber: String): CardPayment {
        this.mobileNumber = mobileNumber
        return cardPaymentObj!!
    }

    fun setUserDefined1(userDefined1: String): CardPayment {
        this.userDefined1 = userDefined1
        return cardPaymentObj!!
    }

    fun setUserDefined2(userDefined2: String): CardPayment {
        this.userDefined2 = userDefined2
        return cardPaymentObj!!
    }

    fun build() {
        cardPaymentObj?.let {
            requestPayment()
        } ?: run {
            Toast.makeText(mContext, "Please try again later !", Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestPayment() {
        val sdk = My2c2pSDK(my2c2pKey)
        //set mandatory fields
        sdk.merchantID = merchantID
        sdk.secretKey = secretKey
        sdk.uniqueTransactionCode = uniqueTransactionCode
        sdk.desc = desc
        sdk.amount = amount
        sdk.currencyCode = currencyCode
        sdk.paymentUI = productionMode
        sdk.paymentOption = My2c2pSDK.PaymentOption.ALL //Refer My2c2pSDK.PaymentOption class
        sdk.mobileNo = mobileNumber
        //sdk.pan = ""

        //optionals
        sdk.enableStoreCard = storedCardPayment
        sdk.userDefined1 = userDefined1
        sdk.userDefined2 = userDefined2
        sdk.userDefined4 = "ref4"
        sdk.userDefined5 = "ref5"
        sdk.request3DS = "Y"

        // sdk.cardHolderName = "Akash Garg"
        // sdk.cardHolderEmail = "akashgarg1000@email.com"
        // sdk.paymentChannel = My2c2pSDK.PaymentChannel.CREDIT_CARD

        val intent = Intent(mContext, My3DSActivity::class.java)
        intent.putExtra(My2c2pSDK.PARAMS, sdk)
        mContext.startActivityForResult(intent, requestCode)
    }

    fun getTransactionResponse(data: Intent, listener: TransactionResponseListener) {
        val my2c2pResponse = data.getParcelableExtra<My2c2pResponse>(My2c2pResponse.RESPONSE)
        val response = Gson().toJson(my2c2pResponse)
        Log.d("#Response From 2C2P : ", ":: $response \n \n")
        val transactionResponse = Gson().fromJson(response, TransactionResponse::class.java)
        listener.getTransactionResponse(transactionResponse)
    }

    interface TransactionResponseListener {
        fun getTransactionResponse(transResponse: TransactionResponse)
    }

}