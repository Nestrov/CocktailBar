package com.summer.cocktailbar.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CocktailDbData::class, IngredientDbData::class], version = 1, exportSchema = false)
abstract class CocktailBarDb:RoomDatabase() {
    abstract fun cocktailBarDao():CocktailBarDao

    companion object {
        @Volatile
        private  var INSTANCE: CocktailBarDb? = null

        fun getDatabase(context: Context):CocktailBarDb{
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CocktailBarDb::class.java,
                    "cocktail_bar"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}