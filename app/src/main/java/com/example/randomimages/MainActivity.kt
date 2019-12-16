package com.example.randomimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var model: MainActivityViewModel = MainActivityViewModel()
        var model = ViewModelProviders.of(this)[MainActivityViewModel::class.java]

        val urlImage : MutableLiveData<String?>? = model.callUrlImage()

        urlImage?.observe(this, Observer{
            Log.d("cuack","Se ejecuta si la url sufre algun cambio")
            Picasso.get().load(it).into(imagePhoto)
            Picasso.get().load(it).into(imagePhoto2)

        })

        btnImage.setOnClickListener{
            Log.d("cuack","cambio")
            model.randomNumbersUrl()
        }

    }
}
