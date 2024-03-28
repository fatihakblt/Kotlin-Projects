package com.fatihakbulut.smsyakalama

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.telephony.SmsMessage.createFromPdu
import android.widget.Toast

class SmsYakalayici :BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {
        val b = intent?.extras

        if (b != null){
            val pdusObj = b.get("pdus") as Array<Any>

            for (i in pdusObj.indices){ // 0..2 ->0,1,2

                val guncelMesaj:SmsMessage

                // Mesaja ulaşma
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ // Güncel kodlama
                    val format = b.getString("format")
                    guncelMesaj = createFromPdu(pdusObj[i] as ByteArray,format)
                    // Eski versiyon kodlama
                }else{
                    guncelMesaj = createFromPdu(pdusObj[i] as ByteArray)
                }
                val telNo = guncelMesaj.displayOriginatingAddress
                val mesaj = guncelMesaj.displayMessageBody

                Toast.makeText(context,"$telNo - $mesaj",Toast.LENGTH_SHORT).show()

            }

        }

    }
}