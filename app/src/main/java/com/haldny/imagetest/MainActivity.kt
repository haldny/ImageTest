package com.haldny.imagetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haldny.imagetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = AnimalAdapter(this)
        (binding.recyclerView.adapter as? AnimalAdapter)?.setData(getAnimals())
    }

    private fun getAnimals() = listOf<Animal>(
        Animal("cachorro"),
        Animal("cobra"),
        Animal("elefante"),
        Animal("gato"),
        Animal("girafa"),
        Animal("leao"),
        Animal("onca"),
        Animal("rinoceronte"),
        Animal("urso"),
        Animal("vaca")
    )
}