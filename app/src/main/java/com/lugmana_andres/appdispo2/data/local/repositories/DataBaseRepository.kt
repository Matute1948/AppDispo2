package com.lugmana_andres.appdispo2.data.local.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lugmana_andres.appdispo2.data.local.database.dao.UsersDAO
import com.lugmana_andres.appdispo2.data.local.database.entities.UsersDB
import kotlinx.coroutines.InternalCoroutinesApi

@Database(
    entities = [UsersDB::class],
    version = 1
)
abstract class DataBaseRepository : RoomDatabase() {
    abstract fun getUserDao(): UsersDAO

    // en versiones anteriores a la 12 o 10 necestiamos especificar con una etiqueta
    companion object {

        @Volatile
        private var dbConnection: DataBaseRepository? = null

        fun getDBConnection(context: Context): DataBaseRepository{
            return dbConnection ?:
                synchronized(this){
                    //esto se ejecuta en u hilo aparte el cual realiza algo muere y asi repetitivamente
                    //instancia solo ejecuta valida aqui
                    //creamos una variable para bloquear la creacion de corutinas hasta que esto termina
                    val INSTANCE =
                        Room.databaseBuilder(
                            context,
                            DataBaseRepository::class.java,
                            "Datos"
                        ).build()
                    dbConnection = INSTANCE
                    dbConnection!!
                }
        }
    }
}
