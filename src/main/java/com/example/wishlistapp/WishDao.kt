package com.example.wishlistapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    @Insert(onConflict =OnConflictStrategy.ABORT)
    abstract fun addwish(wishEntry:Wish)

    @Query("Select * from `wish table`")
    abstract  fun getallwishes(): Flow<List<Wish>>

    @Update
    abstract  fun updatewish(wishEntry: Wish)

    @Delete
    abstract fun deletewish(wishEntry: Wish)

    @Query("Select * from `wish table` where id=:id")
    abstract fun getwishbyid(id:Long): Flow<Wish>
}