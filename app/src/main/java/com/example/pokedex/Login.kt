package com.example.pokedex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.database.DatabaseHelper
import androidx.databinding.DataBindingUtil
import com.example.pokedex.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.singupbtn.setOnClickListener {
            intent = Intent(this, Singup::class.java)
            startActivity(intent)
        }

        dbHelper = DatabaseHelper(this)

        val emailEditText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword)
        val confirmButton = findViewById<Button>(R.id.confirm_button)

        confirmButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (dbHelper.checkUser(email, password)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbHelper.closeDatabase() // Fecha o banco de dados quando a Activity for destruída
    }
}
