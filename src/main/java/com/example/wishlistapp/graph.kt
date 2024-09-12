package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object graph {
    lateinit var database: WishDatabase
    val wishrepository by lazy {
        Wishrepository(wishDao = database.WishDao())
    }
    fun provide(context:Context){
        database=Room.databaseBuilder(context,WishDatabase::class.java,"wishlist.db").build()

    }
}