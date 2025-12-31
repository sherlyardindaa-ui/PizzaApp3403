package com.example.pizzaapp3403

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pizzaapp3403.client.RetrofitClient
import com.example.pizzaapp3403.response.account.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val txtUsername: EditText = findViewById(R.id.editTextTextUsername)
        val txtPassword: EditText = findViewById(R.id.editTextPassword)
        val btnLogin: Button = findViewById(R.id.buttonLogin)
        val txtError: TextView = findViewById(R.id.txtError)

        btnLogin.setOnClickListener {

            txtError.visibility = View.GONE

            val user = txtUsername.text.toString().trim()
            val pwd = txtPassword.text.toString().trim()

            if (user.isEmpty()) {
                txtUsername.error = "Username tidak boleh kosong"
                txtUsername.requestFocus()
                return@setOnClickListener
            }

            if (pwd.isEmpty()) {
                txtPassword.error = "Password tidak boleh kosong"
                txtPassword.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.postLogin(user, pwd)
                .enqueue(object : Callback<LoginResponse> {

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val account = response.body()

                        if (account?.success == true) {
                            Toast.makeText(
                                this@LoginActivity,
                                account.message,
                                Toast.LENGTH_SHORT
                            ).show()

                            startActivity(
                                Intent(
                                    this@LoginActivity,
                                    AccountActivity::class.java
                                )
                            )
                        } else {
                            txtError.text = account?.message ?: "Login gagal"
                            txtError.visibility = View.VISIBLE
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        txtError.text = t.message ?: "Terjadi kesalahan"
                        txtError.visibility = View.VISIBLE
                    }
                })
        }
    }
}
