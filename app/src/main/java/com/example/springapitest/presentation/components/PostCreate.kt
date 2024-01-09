package com.example.springapitest.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.springapitest.domain.model.Post
import java.util.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostCreate(onCreatePost: (Post) -> Unit) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("제목") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        TextField(
            value = author,
            onValueChange = { author = it },
            label = { Text("작성자") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        TextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("내용") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Button(onClick = {
            if(title.isNotEmpty()&&author.isNotEmpty()&&content.isNotEmpty()){
            onCreatePost(

                Post(
                    id = generateId(),
                    title = title,
                    author = author,
                    content = content
                )

            )}else{
                Toast.makeText(null,"빈칸을 채워주세요",Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("작성하기")
        }
    }
}

fun generateId(): Int {
    // Generate a new ID for the post (this could be an auto-incremented ID in a database)
    return Random().nextInt(1000)
}
