package com.raj.aidlsender.domain

import android.content.Context

interface Repository {
    suspend fun sendMessage(message: String)
    suspend fun startService(context: Context)
    suspend fun stopService(context: Context)
}