package com.example.pizzaapp3403

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtUsername: EditText= findViewById(R.id.editTextTextUsername)
        val txtPassword: EditText= findViewById(R.id.editTextPassword)
        val btnLogin: Button= findViewById(R.id.buttonLogin)

        btnLogin.setOnClickListener {
            var user = txtUsername.text.toString().trim()
            var pwd = txtUsername.text.toString().trim()

            if(user.isEmpty()){
                txtUsername.error = "Email required"
            }
        }
    }
}