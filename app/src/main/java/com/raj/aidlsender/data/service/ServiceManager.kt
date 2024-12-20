package com.raj.aidlsender.data.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder

class ServiceManager {

    fun startService(context: Context) {
        val intent = Intent().apply {
            setAction("com.raj.aidlsender.service.SendMessage")
            setPackage("com.raj.aidlsender")
        }
        context.bindService(intent, sendMessageServiceConnection, Context.BIND_AUTO_CREATE);
    }

    val sendMessageServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(
            p0: ComponentName?,
            p1: IBinder?
        ) {

        }

        override fun onServiceDisconnected(p0: ComponentName?) {
        }

    }

    fun stopService(context: Context) {
        val intent = Intent(context, MessageService::class.java)
        context.stopService(intent)
    }
}