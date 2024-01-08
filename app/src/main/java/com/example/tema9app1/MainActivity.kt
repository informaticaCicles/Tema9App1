package com.example.tema9app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.tema9app1.database.UserApplication
import com.example.tema9app1.database.UserDatabase
import com.example.tema9app1.entities.UserEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Insertar usuarios, lo haremos en un hilo secundario
        Thread{
            val userEntityLists : List<UserEntity> = listOf(
                UserEntity(1, "John", "Doe"),
                UserEntity(2, "Jane", "Smith"),
                UserEntity(3, "Alice", "Johnson")
            )

            UserApplication.database.UserDao().insertAll(userEntityLists)
        }.start()

        // Obtener la lista de usuarios en otro hilo secundario

        Thread{
            val userEntities: List<UserEntity> = UserApplication.database.UserDao().getAll()
            // Hacer algo con la lista de usuarios (por ejemplo, imprimir en el Log)
            for (user in userEntities) {
                println("User: ${user.firstName} ${user.lastName}")
            }
        }.start()
    }
}