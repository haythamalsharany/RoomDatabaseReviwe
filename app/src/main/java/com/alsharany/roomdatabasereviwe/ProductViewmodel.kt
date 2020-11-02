package com.alsharany.roomdatabasereviwe

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import java.util.*
import java.util.concurrent.Executors

public  class ProductViewmodel public  constructor( application: Application
):AndroidViewModel(application) {
    var productListLiveData: LiveData<List<Product>>? = null
    private val executor = Executors.newSingleThreadExecutor()
    init {
        productListLiveData=ProductDatabase.get(application).productDao().getProducts()
    }
    fun addProduct(product: Product){
        executor.execute {
            ProductDatabase.get(getApplication()).productDao().addProducts(product)
        }
    }
}
class AddProduct(val product: Product,val context: Application):AsyncTask<Void,Void,Void>(){
    override fun doInBackground(vararg params: Void?): Void? {
        ProductDatabase.get(context).productDao().addProducts(product)
        return null

    }
}
