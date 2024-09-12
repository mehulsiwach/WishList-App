package com.example.wishlistapp

import androidx.compose.material.Text
import androidx.core.app.NotificationCompat.TvExtender
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish table")

data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0L,
    @ColumnInfo(name = "title")
    val title: String="",
    @ColumnInfo(name = "description")
    val description: String=""
)
object Dummywish{
    val wishlist= listOf(
        Wish(title = "Samsung Phone", description = "Samsung Galaxy S24")
    )
}