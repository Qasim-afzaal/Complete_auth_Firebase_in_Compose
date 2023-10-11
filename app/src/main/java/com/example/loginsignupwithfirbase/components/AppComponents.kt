package com.example.loginsignupwithfirbase.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar




@Composable
fun HeadingText(name:String, size:Int, fontWeight: FontWeight){
    Text(text = name,
        fontSize = size.sp,
        fontWeight = fontWeight,
        fontStyle = FontStyle.Normal
        )
}

@Composable
fun HeadingTextItalic(name:String, size:Int, fontWeight: FontWeight){
    Text(text = name,
        fontSize = size.sp,
        fontWeight = fontWeight,
        fontStyle = FontStyle.Italic
    )
}

@Composable
fun button(text: String){
    Button(onClick = { /*TODO*/ }, modifier = Modifier
        .fillMaxWidth()
        .heightIn(48.dp), contentPadding = PaddingValues(),
    colors = ButtonDefaults.buttonColors(Color.LightGray)) {
      Box(modifier = Modifier
          .fillMaxWidth()
          .heightIn(48.dp)
          .background(
              brush = Brush.horizontalGradient(
                  colors = listOf(
                      Color(0xFF6200EE), // Start color
                      Color(0xFFD500F9)
                  ),
                  startX = 0f,
                  endX = 1000f
              ),
              shape = RoundedCornerShape(50.dp),

              ),
              contentAlignment = Alignment.Center
      ) {
          Text(text = text,fontSize = 18.sp, fontStyle = FontStyle.Normal)
      }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun toolBarApp(toolBar:String) {

    TopAppBar(
        title = { Text(text = toolBar)},

        navigationIcon = {
            Icon(imageVector = Icons.Default.Menu, contentDescription ="Menu" )

        },


        )
//    Icon(
//        imageVector = Icons.Default.Favorite, // The icon you want to display
//        contentDescription = null, // You can provide a description for accessibility
//        tint = Color.Red, // Color of the icon (optional)
//        modifier = Modifier.fillMaxSize() // Modify the size and positioning (optional)
//    )
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { toolBarApp(toolBar = "Home") }
    ) {
        // Your content goes here
        // You can add Composables or content within this block
    }
}

