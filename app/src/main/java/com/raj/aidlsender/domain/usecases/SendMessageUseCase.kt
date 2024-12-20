package com.raj.aidlsender.domain.usecases

import com.raj.aidlsender.domain.Repository
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(val repository: Repository) {

    suspend fun sendMessage(message: String) {
        repository.sendMessage(message)
    }

}