package com.example.myapplication

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(login: LoginEntity)

    @Query("SELECT * FROM logins ORDER BY update_at DESC")
    fun loadAll(): Flow<List<LoginEntity>>
}
