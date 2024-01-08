package com.example.tema9app1.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tema9app1.entities.UserEntity

@Dao
interface UserDao {
    @Insert
    fun insertAll(UserEntityList : List<UserEntity>)

    @Update
    fun updateUsers(UserEntityList : List<UserEntity>)


    @Delete
    fun delete(userEntity: UserEntity)

    @Query("SELECT * FROM UserEntity")
    fun getAll(): List<UserEntity>
}