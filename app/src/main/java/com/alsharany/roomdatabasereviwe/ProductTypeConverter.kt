package com.alsharany.roomdatabasereviwe

import androidx.room.TypeConverter
import java.util.*

class ProductTypeConverter {

    @TypeConverter
    fun toUUID(uuid:String?): UUID?{
        return  UUID.fromString(uuid)
    }
    @TypeConverter
    fun fromUUID(uuid:UUID?): String?{
        return  uuid?.toString()
    }
}