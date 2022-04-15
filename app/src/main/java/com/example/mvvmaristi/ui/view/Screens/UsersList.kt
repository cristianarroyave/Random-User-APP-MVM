package com.example.mvvmaristi.ui.view.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.mvvmaristi.R
import com.example.mvvmaristi.ui.navigation.AppScreens
import com.example.mvvmaristi.ui.ViewModel.UserViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListsUsers(userViewModel: UserViewModel = hiltViewModel(),navController: NavController) {
    val userList by userViewModel.userModel.observeAsState(initial = emptyList())
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Random Users") }
            )
        },
        content = {
            SwipeRefresh(state = rememberSwipeRefreshState(isRefreshing = false), onRefresh = {
                userViewModel.onCreate()
            }, indicator = {state, refreshTrigger ->  SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = refreshTrigger,
                scale = true
            )
            }){
                LazyColumn{
                    items(userList!!){
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .clickable {
                                },
                            onClick = {navController.navigate(route = AppScreens.DetailScreen.route + "/${it.nombre}")}
                        ){
                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        modifier = Modifier
                                            .size(90.dp)
                                            .clip(CircleShape),
                                        painter = rememberImagePainter(data = it.image,
                                            builder = {
                                                placeholder(R.drawable.placeholder)
                                                error(R.drawable.placeholder)
                                            }
                                        ),
                                        contentDescription = null,
                                        contentScale = ContentScale.FillWidth
                                    )
                                    Box(modifier = Modifier.fillMaxHeight()){
                                        Text(it.nombre, textAlign = TextAlign.Left, modifier = Modifier
                                            .fillMaxSize()
                                            .padding(start = 20.dp), style = TextStyle(
                                            fontSize = 16.sp,
                                            fontFamily = FontFamily.Monospace,
                                            fontWeight = FontWeight.W800,
                                            fontStyle = FontStyle.Italic,
                                            letterSpacing = 0.2.em
                                        ) )
                                    }
                                }
                                Column(Modifier.padding(8.dp)) {
                                    Text(it.email ?: "", maxLines = 1)

                                }
                            }
                        }
                    }
                }

            }
        }
    )
}