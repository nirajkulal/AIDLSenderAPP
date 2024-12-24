package com.raj.aidlsender.data.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.raj.aidlsender.service.ICallback
import com.raj.aidlsender.service.IMessageReciver
import com.raj.aidlsender.service.ISendMessage

class MessageService : Service() {
    val TAG = "MessageService"
    private var mCallback: ICallback? = null
    private val mBinderCallback = object : IMessageReciver.Stub() {
        override fun setMesssageReciever(callback: ICallback?) {
            Log.i(TAG, "setMesssageReciever = $callback")
            mCallback = callback
        }
    }

    private val mBinderSendMessage = object : ISendMessage.Stub() {
        override fun sendMesssage(message: String?) {
            Log.i(TAG, "sendMesssage = $message")
            mCallback?.onMesssage(message)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.i(TAG, "onBind " + intent?.action)
        return when (intent?.action) {
            "com.raj.aidlsender.service.SendMessage" -> mBinderSendMessage
            "com.raj.aidlsender.service.SetCallback" -> mBinderCallback
            else -> null
        }
    }
}