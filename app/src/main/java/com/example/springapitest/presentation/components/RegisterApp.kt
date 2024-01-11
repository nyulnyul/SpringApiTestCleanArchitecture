package com.example.springapitest.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.springapitest.domain.model.Post
import com.example.springapitest.presentation.viewmodel.RegisterViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegisterApp() {
    val navController = rememberNavController()
    val posts = remember { mutableStateListOf<Post>() }
    var nowRoute by remember{
        mutableStateOf(navController.currentDestination?.route)
    }
    LaunchedEffect(navController){
        navController.addOnDestinationChangedListener { _, destination, _ ->
            nowRoute = destination.route
        }
    }

    Scaffold(topBar = {
        Column {
            TopLogo()
            SearchBar()
            Spacer(modifier = Modifier.padding(6.dp))

        }
    }) {
        NavHost(navController = navController, startDestination = "login", modifier = Modifier.fillMaxSize().padding(it)){
            composable("login"){
                LoginScreen(navController = navController)
            }
            composable("register"){
                UserScreen(navController = navController,viewModel = RegisterViewModel())
            }
            composable("postList"){
                PostMainScreen(navController = navController,posts= posts)
            }
            composable("postCreate") {

                PostCreate(onCreatePost = { post ->

                    posts.add(post)
                    navController.popBackStack()
                })
            }
        }

    }
}


@Composable
fun TopLogo() {
    Box() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp), contentAlignment = Alignment.Center
        ) {
            Row {
                Text(
                    "O",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Blue
                )
                Text(
                    "B",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Blue
                )
                Text(
                    "J",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Blue
                )
                Text(
                    "E",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Black
                )
                Text(
                    "C",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Black
                )
                Text(
                    "T",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.Black
                )
                Text(
                    text = "오브젝트 게시판",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp),
                    color = Color.DarkGray
                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var inputText by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp))
    ) {

        TextField(
            value = inputText,
            onValueChange = { inputText = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            placeholder = { Text(text = "검색어를 입력하세요.") },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
            )

        )
    }

}