package com.example.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun AddEditDetail(
    id: Long,
    viewModel: WishViewModel,
    navController: NavController
){
    val snackmessage= remember {
        mutableStateOf("")

    }
    val scope= rememberCoroutineScope()
    val scaffoldstate= rememberScaffoldState()
    if (id != 0L){
        val wish = viewModel.getwishbyID(id).collectAsState(initial = Wish(0L,"",""))
        viewModel.wishtitlestate = wish.value.title
        viewModel.wishdescriptiontitle = wish.value.description
    }else{
        viewModel.wishtitlestate = ""
        viewModel.wishdescriptiontitle = ""
    }
    Scaffold(
        topBar = {
            AppBarView(title =
            if(id!=0L) stringResource(id = R.string.) else stringResource(id = R.string.addwish)
        ){
        Column(
            modifier = Modifier
                .padding(it)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(label = "Title", value = viewModel.wishtitlestate, onValuechanged ={
                viewModel.wishtitlechanged(it)
            } )
            Spacer(modifier = Modifier.height(10.dp))
            WshTextField(label = "Description", value = viewModel.wishdescriptiontitle, onValuechanged ={
                viewModel.wishdescriptionchanged(it)
            } )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                if(viewModel.wishtitlestate.isNotEmpty() && viewModel.wishdescriptiontitle.isNotEmpty())
                {
                    if(id!=0L){

                    }
                    else{
                        viewModel.addwish(
                            Wish(
                                title=viewModel.wishtitlestate.trim(),
                                description = viewModel.wishdescriptiontitle.trim()
                            )
                        )
                        snackmessage.value="Wish has been created"

                    }

                }else{
                    snackmessage.value="Enter field to create a wish"

            }
                scope.launch {
                    scaffoldstate.snackbarHostState.showSnackbar(snackmessage.value)
                    navController.navigateUp()
                }
            }) {
                Text(text =
                if(id!=0L)"Update Wish" else "Add Wish"
                )
            }

        }

    }
}
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun WshTextField(
    label:String,
    value:String,
    onValuechanged:(String) -> Unit
){
    OutlinedTextField(value = value, onValueChange = onValuechanged,
        label={ Text(text = label,color= Color.Black)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            disabledTextColor = Color.Black,
            unfocusedBorderColor = colorResource(id = R.color.black),
            focusedBorderColor = colorResource(id = R.color.black),
            focusedLabelColor = colorResource(id = R.color.black),
            unfocusedLabelColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black)
        )
    )
}
@Preview
@Composable
fun WishListPreview(){
    WshTextField(label = "text", value = "text", onValuechanged ={} )
}