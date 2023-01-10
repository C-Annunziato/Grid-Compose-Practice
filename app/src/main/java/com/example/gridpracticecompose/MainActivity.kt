package com.example.gridpracticecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridpracticecompose.data.Topic
import com.example.gridpracticecompose.ui.theme.GridPracticeComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridPracticeComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GridList(topicList = Topic.topicsData())
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridList(modifier: Modifier = Modifier, topicList: List<Topic>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        items(topicList) { topic ->
            TopicCard(topic)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = 8.dp,
    ) {
        Row() {
                Image(
                    painter = painterResource(id = topic.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(68.dp, 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
                Column {
                    Text(
                        text = stringResource(id = topic.topic),
                        style = MaterialTheme.typography.subtitle2,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            top = 16.dp,
                            end = 16.dp,
                            bottom = 8.dp
                        ),

                        )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.icon),
                            contentDescription = null,
                            modifier = modifier
                                .padding(start = 16.dp)
                                .size(12.dp)
                        )
                        Text(
                            text = topic.id.toString(),
                            modifier = Modifier.padding(
                                start = 8.dp,

                            ),
                            style = MaterialTheme.typography.caption
                        )

                    }
                }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridPracticeComposeTheme {
        GridList(topicList = Topic.topicsData())
    }
}