package com.iambhargavnath.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailFill: EditText = findViewById(R.id.emailFill)
        val passwordFill: EditText = findViewById(R.id.passwordFill)
        val loginBtn: Button = findViewById(R.id.loginBtn)

        loginBtn.setOnClickListener {
            val email: String = emailFill.getText().toString()
            val password = passwordFill.text.toString()
            if(email=="user@example.com" && password=="password")
            {
                Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_SHORT).show()
                emailFill.text = null
                passwordFill.text = null
                finish()
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@LoginActivity, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}