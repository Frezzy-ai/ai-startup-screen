package com.frezzy.ailistener

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.frezzy.ailistener.ui.screens.ListenerScreen
import com.frezzy.ailistener.ui.theme.AIStartupScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AIStartupScreenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF030b17)
                ) {
                    ListenerScreen()
                }
            }
        }
    }
}
