package com.example.mvvmaristi.ui.view.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UserDetailScreen(navController: NavController, name: String?){
    /*Text(name!!, modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp), style = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.W800,
        fontStyle = FontStyle.Italic,
        letterSpacing = 0.2.em))*/
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(name!!) }
            )
        },
        content = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Pene")
            }
        })
}

@Composable
@Preview
fun Preview(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cristian Arroyave") }
            )
        },
        content = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text("Pene")
            }
        })
}