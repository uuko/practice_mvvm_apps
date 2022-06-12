package com.example.practice_apps.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userEntity: UserEntity): Long

    @Query("SELECT * FROM users_favorite")
    fun loadUser(): Single<List<UserEntity>>
}