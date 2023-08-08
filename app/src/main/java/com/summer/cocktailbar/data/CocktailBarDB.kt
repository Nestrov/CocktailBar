package com.summer.cocktailbar.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CocktailDBData::class, IngredientDBData::class], version = 2, exportSchema = false)
abstract class CocktailBarDB:RoomDatabase() {
    abstract fun cocktailBarDao():CocktailBarDao

    companion object {
        @Volatile
        private  var INSTANCE: CocktailBarDB? = null

        fun getDatabase(context: Context):CocktailBarDB{
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CocktailBarDB::class.java,
                    "cocktail_bar"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}