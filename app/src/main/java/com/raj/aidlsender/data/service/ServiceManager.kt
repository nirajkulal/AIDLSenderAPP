package com.raj.aidlsender.data.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import com.raj.aidlsender.service.ISendMessage
import javax.inject.Inject

class ServiceManager @Inject constructor() {
    private var message: ISendMessage? = null

    fun startService(context: Context) {
        val intent = Intent().apply {
            action = "com.raj.aidlsender.service.SendMessage"
            setPackage("com.raj.aidlsender")
        }
        context.bindService(intent, sendMessageServiceConnection, Context.BIND_AUTO_CREATE)
    }

    fun sendMessage(msg: String) {
        message?.sendMesssage(msg)
    }

    val sendMessageServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(
            p0: ComponentName?, p1: IBinder?
        ) {
            message = ISendMessage.Stub.asInterface(p1)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
        }

    }

    fun stopService(context: Context) {
        val intent = Intent().apply {
            action = "com.raj.aidlsender.service.SendMessage"
            setPackage("com.raj.aidlsender")
        }
        context.stopService(intent)
    }
}