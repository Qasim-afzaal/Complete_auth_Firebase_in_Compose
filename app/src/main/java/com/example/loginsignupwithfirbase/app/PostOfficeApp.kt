package com.example.loginsignupwithfirbase.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginsignupwithfirbase.components.AppContent

@Composable
fun mainScreen(){

    Surface(modifier = Modifier.fillMaxSize().background(Color.White)) {
        AppContent()


    }
}

@Preview
@Composable
fun DefualtPreviewOfSignUpScreen(){
    mainScreen()

}
