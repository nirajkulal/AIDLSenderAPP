package com.raj.aidlsender.data.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.raj.aidlsender.service.ICallback
import com.raj.aidlsender.service.IMessageReciver
import com.raj.aidlsender.service.ISendMessage

class MessageService : Service() {

    private var mCallback: ICallback? = null
    private val mBinderCallback = object : IMessageReciver.Stub() {
        override fun setMesssageReciever(callback: ICallback?) {
            mCallback = callback
        }
    }

    private val mBinderSendmessage = object : ISendMessage.Stub() {

        override fun sendMesssage(message: String?) {
            mCallback?.onMesssage(message)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return mBinderCallback
    }

    fun updateMessage(message: String) {
        mCallback?.onMesssage(message)
    }

}