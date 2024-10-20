package com.iambhargavnath.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginPageBtn: Button = findViewById(R.id.loginPageBtn)
        loginPageBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        val alertDialogPageBtn: Button = findViewById(R.id.alertDialogPageBtn)
        alertDialogPageBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, AlertDialogActivity::class.java)
            startActivity(intent)
        }

        val sharedPrefBtn: Button = findViewById(R.id.sharedPrefBtn)
        sharedPrefBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, SharedPrefActivity::class.java)
            startActivity(intent)
        }

        val recycleViewBtn: Button = findViewById(R.id.recycleViewBtn)
        recycleViewBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, RecyclerActivity::class.java)
            startActivity(intent)
        }

        val webViewBtn: Button = findViewById(R.id.webViewBtn)
        webViewBtn.setOnClickListener {
            val intent = Intent(this@MainActivity, WebViewActivity::class.java)
            startActivity(intent)
        }


    }
}