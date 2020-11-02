package com.alsharany.roomdatabasereviwe

import android.app.Application
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
@Database(entities = [Product::class],version = 2)
@TypeConverters(ProductTypeConverter::class)
abstract class ProductDatabase :RoomDatabase() {
    abstract fun productDao():ProductDao

    companion object {
        fun get(application: Application):ProductDatabase{
            return  Room.databaseBuilder(
                application,
                ProductDatabase::class.java,
                "productDB"
            ).fallbackToDestructiveMigration().build()
        }
    }


}
