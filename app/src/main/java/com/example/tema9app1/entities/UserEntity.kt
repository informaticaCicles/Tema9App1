package com.example.tema9app1.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey val id: Int,

    val firstName: String?,
    val lastName: String?
)

