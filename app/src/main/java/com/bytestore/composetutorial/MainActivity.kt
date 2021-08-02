package com.bytestore.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { 
            MessageCard(msg = Message("Android","Jetpack compose!"))
        }
    }

    data class Message(val author:String, val body:String)

    @Composable
    fun MessageCard(msg:Message){
        Column{
            Text(text = msg.author)
            Text(text = msg.body)
        }
    }

    @Preview
    @Composable
    fun previewCard(){
        MessageCard(
            msg = Message("Collegue","Take a look @ Jetpack compose")
        )
    }
}