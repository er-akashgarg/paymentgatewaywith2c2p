package com.akashgarg.paymentlib

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.akashgarg.mypaylib.CardPayment
import com.akashgarg.mypaylib.TransactionResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var REQUEST_SDK = 10010

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pay.setOnClickListener {
            CardPayment.init(this@MainActivity)
                .setMerchantID(AppConstants.MERCHANT_ID)
                .setSecretKey(AppConstants.SECRATE_KEY)
                .set2c2pGenerateKey(AppConstants.MY2C2PGENERATE_KEY)
                .setCurrencyCode(AppConstants.CURRENCY_CODE)
                .setRequestCode(REQUEST_SDK)
                .setProductionModeEnable(true)
                .setStoredCardPayment(false)
                .setMobileNumber("00959768077189")
                .setAmount(10.0)
                .setUniqueTransactionCode("0060789090")
                .setDescription("Payment for ZayOk E-Commerce App...!")
                .setUserDefined1("ref1")
                .setUserDefined2("ref2")
                .build()
        }
    }

    /* This is a response method */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e("###: ", "--##requestCode-: $requestCode :: resultCode:  $resultCode")
        if (REQUEST_SDK == requestCode) {
            if (Activity.RESULT_CANCELED == resultCode) {
                Log.e("##########:", "Transaction is canceled ######")
                Toast.makeText(this@MainActivity, "Payment Denied !", Toast.LENGTH_SHORT).show()
            } else if (resultCode == Activity.RESULT_OK) {
                data?.let {
                    CardPayment.init(this@MainActivity)
                        .getTransactionResponse(data, object : CardPayment.TransactionResponseListener {
                            override fun getTransactionResponse(transResponse: TransactionResponse) {
                                Log.e("#MainActivity# ", "Transaction Response : ${transResponse}")
                            }
                        })
                } ?: run {
                    Toast.makeText(
                        this@MainActivity,
                        "Something error from 2C2P ! Please try again..",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        } else {
            Toast.makeText(this@MainActivity, "Request Code Mismatched !", Toast.LENGTH_SHORT).show()
        }
    }
}
