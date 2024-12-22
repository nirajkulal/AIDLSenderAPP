package com.raj.aidlsender.data.repository

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import com.raj.aidlsender.data.service.MessageService
import com.raj.aidlsender.data.service.ServiceManager
import com.raj.aidlsender.domain.Repository
import javax.inject.Inject

class RepositoryImp@Inject constructor(val serviceManager: ServiceManager) : Repository {
    override suspend fun sendMessage(message: String) {
        serviceManager.sendMessage(message)
    }

    override suspend fun startService(context: Context) {
        serviceManager.startService(context)
    }

    override suspend fun stopService(context: Context) {
        serviceManager.stopService(context)
    }
}