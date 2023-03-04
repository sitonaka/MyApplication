package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logins")
data class LoginEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "login") val login: String,
    @ColumnInfo(name = "update_at") val updateAt: Long,
)
