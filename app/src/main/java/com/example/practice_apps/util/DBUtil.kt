package com.example.practice_apps.util

import com.example.practice_apps.Users
import com.example.practice_apps.db.UserEntity

class DBUtil {
    fun Users.toUserEntity(): UserEntity {
        return UserEntity(
            id = id,
            name=name,
            username= username,
            email = email,
            phone = phone,
            website = website,
        )
    }

}