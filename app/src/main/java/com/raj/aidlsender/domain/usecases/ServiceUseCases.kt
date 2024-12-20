package com.raj.aidlsender.domain.usecases

import android.content.Context
import com.raj.aidlsender.domain.Repository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ServiceUseCases @Inject constructor(
    val repository: Repository,
    @ApplicationContext private val context: Context
) {
    suspend fun startService() {
        repository.startService(context)
    }

    suspend fun stopService() {
        repository.stopService(context)
    }
}