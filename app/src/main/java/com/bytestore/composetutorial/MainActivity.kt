package com.bytestore.composetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.nio.file.Files.size

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(msg = Message("Android", "Jetpack compose!"))
        }
    }

    data class Message(val author: String, val body: String)

    @Composable
    fun MessageCard(msg: Message) {
        MaterialTheme {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.profile_pic),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = msg.author,
                        modifier = Modifier.padding(4.dp),
                        color = MaterialTheme.colors.secondaryVariant,
                        style = MaterialTheme.typography.subtitle2,

                        )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = msg.body,
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }


    }

    @Preview(
        name = "Light mode",
        showBackground = true
    )
    @Preview(
        name = "Dark mode",
        showBackground = true,
        uiMode = Configuration.UI_MODE_NIGHT_YES
    )

    @Composable
    fun previewCard() {
        MessageCard(
            msg = Message("Collegue", "Take a look @ Jetpack compose")
        )
    }
}