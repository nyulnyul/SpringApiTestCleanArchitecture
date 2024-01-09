package com.example.springapitest.domain.repository

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.springapitest.domain.model.Post


@Composable
fun PostListItem(post: Post, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "제목 : ${post.title}", fontWeight = FontWeight.Bold)
                Text(text = ("작성자: ${post.author}"), maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(text = post.content, maxLines = 1, overflow = TextOverflow.Ellipsis)

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostList(posts: List<Post>, onPostClick: (Post) -> Unit) {if (posts.isEmpty()) {
    // 게시물이 없을 때의 화면을 표시합니다.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "게시물이 없습니다",
            style = MaterialTheme.typography.headlineMedium
        )

    }
} else {
    LazyColumn {

        stickyHeader {
            Text(
                text = "게시물 목록",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black)
                    .padding(3.dp),
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 20.sp

            )
        }
        items(posts) { post ->
            PostListItem(post = post, onClick = { onPostClick(post) })
        }
    }
}
}
