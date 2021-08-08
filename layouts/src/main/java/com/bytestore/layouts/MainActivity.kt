package com.bytestore.layouts

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bytestore.layouts.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val weekDays = listOf(
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
            )
            MyScreenContent(weekDays)
        }
    }


    @Composable
    fun MyScreenContent(
        names: List<String> = listOf("Android", "There")
    ) {
        val counterState = remember { mutableStateOf(0) }

        MaterialTheme {
            Box {
                if (names.isNotEmpty()) {
                    Column(modifier = Modifier.fillMaxHeight()) {
                        Column(modifier = Modifier.weight(1f)) {
                            for (name in names) {
                                Greeting(name = name)
                                Divider(color = Color.Black)
                            }
                        }
                        Counter(
                            count = counterState.value,
                            updateCount = {
                                counterState.value = it
                            })
                    }
                } else {
                    EmptyLayout(error = "No items!!")
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Log.d("LAYOUT", "Greeting called..")
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(24.dp),
            style = MaterialTheme.typography.body2,
            fontFamily = FontFamily.Serif
        )
    }

    @Composable
    fun Counter(
        count: Int,
        updateCount: (Int) -> Unit
    ) {
        Log.d("LAYOUT", "Counter called..")

        Button(
            onClick = { updateCount(count + 1) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (count > 5) Color.Green else Color.White
            )
        ) {
            Text(text = "I've been clicked $count time")
        }
    }

    @Composable
    fun EmptyLayout(error: String) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = error)
        }
    }


    @Preview(
        showBackground = true
    )
    @Composable
    fun PreviewContent() {
        MyScreenContent()
    }

    @Preview(
        showBackground = true
    )
    @Composable
    fun PreviewEmptyLayout() {
        EmptyLayout(error = "No items!!")
    }
}