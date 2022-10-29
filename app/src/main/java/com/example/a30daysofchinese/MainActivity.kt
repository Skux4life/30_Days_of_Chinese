package com.example.a30daysofchinese

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.a30daysofchinese.DayRepository.days
import com.example.a30daysofchinese.models.Day
import com.example.a30daysofchinese.ui.theme.ThirtyDaysOfChineseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysOfChineseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    Scaffold(
        topBar = { AppTopBar() }
    ) {
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(days) {
                ItemCard(day = it)
            }
        }
    }
}

@Composable
fun ItemCard(
    day: Day,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(16.dp)
            .fillMaxWidth(),
        elevation = 16.dp,
    ) {
        Column(
            modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CharacterImage(imageRes = day.characterImage)
            Text(
                text = "Pinyin: " + stringResource(id = day.pinyin),
                modifier = Modifier.padding(start = 24.dp),
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "English Definition: " + stringResource(id = day.definition),
                modifier = Modifier.padding(start = 24.dp, bottom = 8.dp),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
private fun CharacterImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context).data(imageRes).apply(
                    block = {
                        size(Size.ORIGINAL)
                    }).build(), imageLoader
            ),
            contentDescription = "Chinese character",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .padding(top = 4.dp)
                .clip(MaterialTheme.shapes.medium),
            )
    }
}

@Composable
private fun AppTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(MaterialTheme.colors.primaryVariant),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1
        )

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThirtyDaysOfChineseTheme {
        ItemCard(day = days[0])
    }
}