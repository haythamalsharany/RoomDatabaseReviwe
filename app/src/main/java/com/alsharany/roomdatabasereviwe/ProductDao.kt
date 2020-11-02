package com.alsharany.roomdatabasereviwe

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao  {
    @Query("SELECT * FROM Product_Table " )
   fun  getProducts():LiveData<List<Product>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProducts(Product:Product)
}