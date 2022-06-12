package com.example.practice_apps.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.practice_apps.util.USER_TABLE_NAME

@Entity(tableName = USER_TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String?,
    val username: String?,
    val email: String?,
    val phone: String?,
    val website: String?,
)