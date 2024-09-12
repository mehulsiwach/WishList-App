package com.example.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wishlistapp.graph.wishrepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel( private val wishrepository: Wishrepository= graph.wishrepository):ViewModel() {
    var  wishtitlestate by mutableStateOf("")
    var wishdescriptiontitle by mutableStateOf("")
    fun wishtitlechanged(newString: String){
        wishtitlestate=newString
    }
    fun wishdescriptionchanged(newString: String){
        wishdescriptiontitle=newString
    }
    lateinit var getallwishes: Flow<List<Wish>>
    init {
        viewModelScope.launch {
            getallwishes= wishrepository.getwishes()
        }
    }
    fun addwish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishrepository.AddaWish(wish = wish)
        }

    }
    fun getwishbyID(id:Long): Flow<Wish>{
        return wishrepository.getwishbyID(id)
    }
    fun updatewish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishrepository.updatewishes(wish = wish)
        }
    }
    fun deletewish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO){
            wishrepository.deletewish(wish=wish)
        }
    }
}