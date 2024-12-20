package com.raj.aidlsender.application.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.raj.aidlsender.application.theme.AIDLSenderTheme
import com.raj.aidlsender.application.theme.Typography
import com.raj.aidlsender.application.vm.SenderVM
import com.raj.aidlsender.application.vm.ViewEvents
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class AIDLSenderActivity : ComponentActivity() {
    private val viewModel: SenderVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AIDLSenderPage(viewModel)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.setEvent(ViewEvents.Init)
    }

    override fun onStop() {
        super.onStop()
        viewModel.setEvent(ViewEvents.Stop)

    }
}

@Composable
fun AIDLSenderPage(viewModel: SenderVM) {
    AIDLSenderTheme {
        MessageInputText{
            viewModel.setEvent(ViewEvents.SendMessage(it))
        }
    }
}

@Composable
fun MessageInputText(
    onNewMessage: (query: String) -> Unit
) {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = stringResource(id = com.raj.aidlsender.R.string.message),
            )
        },
        textStyle = Typography.bodyMedium,
        value = text,
        onValueChange = {
            text = it
            onNewMessage(it)
        })
}