package com.bytestore.modifiersadvanced

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bytestore.modifiersadvanced.ui.theme.ComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createArtist()
        setContent {

        }
    }

    private fun createArtist(): Artist {
        return Artist(
            "Random",
            lastSeen = "3 minutes ago"
        )
    }


    @Composable
    fun ScreenContent(artist: Artist) {
        MaterialTheme {
            ArtistCard(artist)
        }
    }

    @Composable
    fun ArtistCard(artist: Artist) {
        Card {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_artist),
                    contentDescription = "",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.Blue, shape = CircleShape)
                )
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth().offset(x= 8.dp)
                ) {
                    ArtistText(
                        text = artist.name,
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.body1
                    )
                    ArtistText(
                        text = artist.lastSeen,
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }

    @Composable
    fun ArtistText(
        text: String,
        modifier: Modifier,
        style: TextStyle
    ) {
        Text(
            text = text,
            modifier = modifier,
            style = style
        )
    }

    @Preview(
        showBackground = true
    )
    @Composable
    fun PreviewCard() {
        ScreenContent(artist = createArtist())
    }

    data class Artist(
        val name: String,
        val lastSeen: String
    )
}