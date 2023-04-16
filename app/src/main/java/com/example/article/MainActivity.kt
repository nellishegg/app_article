package com.example.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyImage()
                }
            }
        }
    }
}

@Composable
fun MyImage() {
    val myImage = painterResource(id = R.drawable.bg_compose_background)
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = myImage,
            contentDescription = null
        )
        TextToTask(
            text1 = stringResource(R.string.first_text),
            text2 = stringResource(R.string.second_text),
            text3 = stringResource(R.string.third_text)
        )
    }
}

@Composable
fun TextToTask(text1: String, text2: String, text3: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text1,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = text2,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = text3,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArticleTheme {
        MyImage()
    }
}