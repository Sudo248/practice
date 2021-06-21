package com.duonglh.fragmentpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.duonglh.fragmentpractice.databinding.ActivityMainBinding
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.staticFragmentButton.setOnClickListener {
            startActivity(Intent(this, StaticFragmentActivity::class.java))
        }

        binding.dynamicFragmentButton.setOnClickListener {
            startActivity(Intent(this, DynamicFragmentActivity::class.java))
        }


    }
}

data class Person(val name:String, var age: Short) : Serializable