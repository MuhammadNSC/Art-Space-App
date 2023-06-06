package com.example.artspacepictures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.example.artspacepictures.ui.theme.ArtSpacePicturesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpacePicturesTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageSlider()
                }
            }
        }
    }
}

@Composable
fun ImageSlider() {
    val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10
    )
    val descriptions = listOf(
        R.string.picture1,
        R.string.picture2,
        R.string.picture3,
        R.string.picture4,
        R.string.picture5,
        R.string.picture6,
        R.string.picture7,
        R.string.picture8,
        R.string.picture9,
        R.string.picture10
    )
    var currentIndex by remember { mutableStateOf(0) }


    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = images[currentIndex]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Divider(Modifier.padding(horizontal = 16.dp))
        Box(
            modifier = Modifier
                .padding(16.dp)
                .border(width = 2.dp, color = Color.Black)
                .background(color = Color.LightGray)
                .padding(8.dp)
        ) {
            Text(
                text = stringResource(id = descriptions[currentIndex]),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        Divider(Modifier.padding(horizontal = 16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = { if (currentIndex > 0) currentIndex-- },
                colors = ButtonDefaults.buttonColors( Color.Blue)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = { if (currentIndex < images.size - 1) currentIndex++ },
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(text = "Next")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpacePicturesTheme() {
        ImageSlider()
    }
}

