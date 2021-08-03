package com.bytestore.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bytestore.state.ui.theme.ComposeTutorialTheme
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Playground()
        }
    }

    @Composable
    fun Playground() {
        MaterialTheme {
            Counter()
        }
    }

    @Composable
    fun Counter() {
        val count = remember { mutableStateOf(0) }
        OutlinedButton(
            onClick = { count.value++ },
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .height(48.dp),
            border = BorderStroke(2.dp, Color.Blue)
        ) {
            Text(
                "I've been clicked ${count.value} times",
                fontFamily = FontFamily.Serif)
        }
    }

    @Preview(
        showBackground = true
    )
    @Composable
    fun PreviewComposable() {
        Playground()
    }
}