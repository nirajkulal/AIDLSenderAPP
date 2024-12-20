package com.raj.aidlsender.data.repository

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import com.raj.aidlsender.data.service.MessageService
import com.raj.aidlsender.domain.Repository

class RepositoryImp : Repository {
    override suspend fun sendMessage(message: String) {

    }

    override suspend fun startService(context: Context) {
        Log.i("RepositoryImp", "startService with context = $context")
        val intent = Intent(context, MessageService::class.java)
        context.startService(intent)
    }

    override suspend fun stopService(context: Context) {
    }

    val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(
            p0: ComponentName?,
            p1: IBinder?
        ) {

        }

        override fun onServiceDisconnected(p0: ComponentName?) {

        }

    }
}