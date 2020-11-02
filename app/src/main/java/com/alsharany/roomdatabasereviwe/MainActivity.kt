package com.alsharany.roomdatabasereviwe

import android.app.Application
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var products:List<Product>
    lateinit var productTextView:TextView
    private  val productViewmodel:ProductViewmodel by lazy {
        ViewModelProviders.of(this).get(ProductViewmodel::class.java)
    }
    var productLis= listOf<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        productTextView=findViewById(R.id.product_tv)

        button_add.setOnClickListener {
            productViewmodel.addProduct(Product(UUID.randomUUID(),"prefum","nice smil prefum",10.0))
            displayProductInfo()
        }
        ProductDatabase.get(application).productDao().getProducts().
            observe(this , { products ->
                products?.let {
                    productLis=products
                    displayProductInfo()
                    Log.i(
                        "products",
                        "Got product ${products.first().productName}"

                    )
    }})
    }
    fun displayProductInfo(){
        productLis.forEach {
            productTextView.append( "${it.productName }        | ${it.productDiscribtion   }        |${it.productPrice}    \n")
        }


    }
}