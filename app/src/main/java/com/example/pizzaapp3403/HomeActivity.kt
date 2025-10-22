package com.example.pizzaapp3403

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class HomeActivity : AppCompatActivity() {
    //fc rep frag
    private fun  replzceFragmet(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTRX = fragmentManager.beginTransaction()
        fragmentTRX.replace(R.id.fragmentContainerView, fragment)
        fragmentTRX.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtAccount: TextView = findViewById(R.id.textViewMenuAccount)

    }
}