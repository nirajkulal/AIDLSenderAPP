package com.raj.aidlsender.application.vm

import com.raj.aidlsender.domain.usecases.SendMessageUseCase
import com.raj.aidlsender.domain.usecases.ServiceUseCases
import com.raj.mylibrary.MviEffect
import com.raj.mylibrary.MviEvent
import com.raj.mylibrary.MviState
import com.raj.mylibrary.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SenderVM @Inject constructor(
    private val serviceUseCases: ServiceUseCases,
    private val sendMessageUseCase: SendMessageUseCase
) : MviViewModel<ViewState, ViewEvents, ViewEffect>(
    ViewState(

    )
) {
    override suspend fun handleEffects(effect: ViewEffect) {

    }

    override suspend fun handleEvents(event: ViewEvents) {
        when (event) {
            ViewEvents.Init -> {
                serviceUseCases.startService()
            }

            is ViewEvents.SendMessage -> {
                sendMessageUseCase.sendMessage(event.message)
            }

            ViewEvents.Stop -> {
                serviceUseCases.stopService()
            }
        }
    }
}

data class ViewState(
    var message: String? = ""
) : MviState

sealed class ViewEvents : MviEvent {
    object Init : ViewEvents()
    object Stop : ViewEvents()
    data class SendMessage(val message: String) : ViewEvents()
}

sealed class ViewEffect : MviEffect