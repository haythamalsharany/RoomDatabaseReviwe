package com.alsharany.roomdatabasereviwe

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "Product_Table")
data class Product(@PrimaryKey var  productId :UUID,
                   var productName:String="", var productDiscribtion:String="", var productPrice: Double =0.0) {
}