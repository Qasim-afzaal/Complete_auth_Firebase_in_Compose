package com.example.loginsignupwithfirbase.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.ImeAction


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

@Composable
fun AppContent() {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Register",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.padding(16.dp)
        )

        TextFieldWithValidation(
            value = username,
            onValueChange = {
                username = it
                isButtonEnabled = validateFields(username, email, password)
            },
            label = "Username",
            modifier = Modifier.padding(16.dp)
        )

        TextFieldWithValidation(
            value = email,
            onValueChange = {
                email = it
                isButtonEnabled = validateFields(username, email, password)
            },
            label = "Email",
            modifier = Modifier.padding(16.dp)
        )

        TextFieldWithValidation(
            value = password,
            onValueChange = {
                password = it
                isButtonEnabled = validateFields(username, email, password)
            },
            label = "Password",
            modifier = Modifier.padding(16.dp),
            isPassword = true
        )

        Button(
            onClick = { /* Handle button click here */ },
            enabled = isButtonEnabled,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        ) {
            Text(text = "Register")
        }
    }
}

@Composable
fun TextFieldWithValidation(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean = false,
    modifier: Modifier = Modifier
) {
    var isError by remember { mutableStateOf(false) }

    BasicTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
            isError = false
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                if (!validateField(value, isPassword)) {
                    isError = true
                }
            }
        ),
        textStyle = LocalTextStyle.current.copy(color = if (isError) Color.Red else Color.Black),
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp)
    )

    if (isError) {
        Text(
            text = "Invalid $label",
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

fun validateFields(username: String, email: String, password: String): Boolean {
    return validateField(username) && validateField(email) && validateField(password)
}

fun validateField(value: String, isPassword: Boolean = false): Boolean {
    return when {
        isPassword -> value.length >= 6
        else -> value.isNotEmpty()
    }
}

