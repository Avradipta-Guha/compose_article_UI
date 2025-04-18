package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArticleImage(
                        stringResource(R.string.text1),
                        stringResource(R.string.text2),
                        stringResource(R.string.text3),
                        modifier = Modifier.padding(innerPadding)
                        )

                }
            }
        }
    }
}

@Composable
fun ArticleText( mes1: String, mes2: String, mes3: String, modifier: Modifier = Modifier  ){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start, modifier = Modifier.padding(8.dp)) {
        Text(
            text = mes1,
            fontSize = 24.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        Text(
            text = mes2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            )

        )
        Text(
            text = mes3,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ArticleImage(mes1: String, mes2: String, mes3: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.bg_compose_background)

    Column(modifier.padding(
        top = 8.dp)) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth

        )
        ArticleText(
            mes1 = mes1,
            mes2 = mes2,
            mes3 = mes3

        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ArticleImage("Jetpack Compose tutorial", "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\n", "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.")
    }
}