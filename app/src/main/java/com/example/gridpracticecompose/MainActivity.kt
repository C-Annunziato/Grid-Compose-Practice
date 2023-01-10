package com.example.gridpracticecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
                GridList(topicList = Topic.topicsData())
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridList(modifier: Modifier = Modifier, topicList: List<Topic>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(topicList) { topic ->
            TopicCard(topic)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier.size(68.dp), elevation = 4.dp, shape = RoundedCornerShape(20.dp)) {
        Row() {
            Image(
                painter = painterResource(id = topic.image),
                contentDescription = null,
                modifier = Modifier.weight(1f).fillMaxHeight()
            )
            Column(modifier = Modifier.weight(2f)) {
                Text(text = topic.id.toString())
                Text(text = stringResource(id = topic.topic))
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.icon), contentDescription = null)

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