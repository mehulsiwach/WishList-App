package com.example.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel

){
    val context= LocalContext.current
    val scaffoldState= rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { AppBarView(title ="Wishlist") },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(all = 20.dp),
                backgroundColor = Color.Black,
                contentColor = Color.White,
                onClick = {
                    Toast.makeText(context, "FAButton Clicked", Toast.LENGTH_LONG).show()
                    navController.navigate(Screen.AddScreen.route + "/0L")
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
                

    ) {
        val wishlist= viewModel.getallwishes.collectAsState(initial = listOf())
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)){
            items(wishlist.value){
                wish-> Wishitem(wish = wish) {
                    val id= wish.id
                    navController.navigate(route = Screen.AddScreen.route + "/$id")

                
            }
            }

        }

    }
}
@Composable
fun Wishitem(wish:Wish,onClick : () -> Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable { onClick() },
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier=Modifier.padding(16.dp)
        ) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description)

            
        }

    }
}