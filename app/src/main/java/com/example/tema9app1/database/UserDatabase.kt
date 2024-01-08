package com.example.tema9app1.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tema9app1.daos.UserDao
import com.example.tema9app1.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun UserDao(): UserDao
}