package com.example.pokedex

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.pokedex.databinding.ActivitySingupBinding

class Singup : AppCompatActivity() {
    lateinit var binding: ActivitySingupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_singup)

        binding.logibtn.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        binding.SingUp.setOnClickListener {
            addUser()
        }
    }

    private fun addUser() {
        // Implement your user adding logic here
    }
}
