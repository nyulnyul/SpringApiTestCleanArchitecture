package com.example.springapitest.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.springapitest.R
import com.example.springapitest.domain.model.Post
import com.example.springapitest.domain.repository.PostList
import com.example.springapitest.domain.repository.PostListItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostMainScreen(posts: List<Post>, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        ConstraintLayout() {
            val (tops, bottoms,bottom2) = createRefs()
            Image(
                painterResource(id = R.drawable.world2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(tops) {
                        top.linkTo(parent.top)



                    })
            Text("오브젝트 게시판", fontSize = 25.sp, fontWeight = FontWeight.Bold,modifier = Modifier
                .padding(top = 16.dp)
                .constrainAs(bottoms) {

                    start.linkTo(tops.start)
                    end.linkTo(tops.end)
                })
            Button(onClick = {navController.navigate("postCreate") }, modifier = Modifier.fillMaxWidth().padding(16.dp)

                .constrainAs(bottom2) {
                    top.linkTo(bottoms.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                Text("게시글 작성하기")

            }
        }
        PostList(posts = posts) { post ->
            navController.navigate("postDetail/${post.id}")
        }





    }
}