package com.example.mvvmaristi.ui.view.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mvvmaristi.R
import com.example.mvvmaristi.data.model.fullUserInfo.FullUserInfo
import com.example.mvvmaristi.ui.ViewModel.FullUserInfoViewModel

@Composable
fun UserDetailScreen(navController: NavController, name: String?, fullUserInfoViewModel: FullUserInfoViewModel = hiltViewModel()){
    val user by fullUserInfoViewModel.fullInfo.observeAsState(initial = FullUserInfo(age = 0))
    fullUserInfoViewModel.onCreate(name!!)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(name) }
            )
        },
        content = {
            Column {
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)){
                    Column {
                        Box(modifier = Modifier.fillMaxWidth(0.75f)){
                            Text(   modifier = Modifier.fillMaxWidth(),
                                text = user!!.name,
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily.Monospace,
                                    fontWeight = FontWeight.W800,
                                    fontStyle = FontStyle.Italic,
                                    letterSpacing = 0.2.em
                                ))
                        }
                        Box(modifier = Modifier.fillMaxWidth(0.75f)){
                            Text(   modifier = Modifier.fillMaxWidth(),
                                text = user!!.age.toString(),
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 43.sp,
                                    fontFamily = FontFamily.Monospace,
                                    fontWeight = FontWeight.W800,
                                    fontStyle = FontStyle.Italic,
                                    letterSpacing = 0.2.em
                                ))
                        }
                    }
                    Image(
                        modifier = Modifier
                            .size(90.dp),
                        painter = rememberImagePainter(data = user!!.image,
                            builder = {
                                placeholder(R.drawable.placeholder)
                                error(R.drawable.placeholder)
                            }
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )
                }
                Text(user!!.email, textAlign = TextAlign.Left, modifier = Modifier
                    .padding(start = 20.dp), style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W800,
                    fontStyle = FontStyle.Italic,
                    letterSpacing = 0.2.em
                ) )
                Text(user!!.street, textAlign = TextAlign.Left, modifier = Modifier
                    .padding(start = 20.dp), style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W800,
                    fontStyle = FontStyle.Italic,
                    letterSpacing = 0.2.em
                ) )
                Text(user!!.city, textAlign = TextAlign.Left, modifier = Modifier
                    .padding(start = 20.dp), style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W800,
                    fontStyle = FontStyle.Italic,
                    letterSpacing = 0.2.em
                ) )
                Text(user!!.country, textAlign = TextAlign.Left, modifier = Modifier
                    .padding(start = 20.dp), style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W800,
                    fontStyle = FontStyle.Italic,
                    letterSpacing = 0.2.em
                ) )
            }
        })
}