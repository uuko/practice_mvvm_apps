package com.example.practice_apps.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [UserEntity::class],
    exportSchema = false
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

}