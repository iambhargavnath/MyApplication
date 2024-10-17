package com.iambhargavnath.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alert_dialog)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val showDialogBtn = findViewById<Button>(R.id.showDialogBtn)
        showDialogBtn.setOnClickListener {
            showAlertDialog()
        }

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showConfirmExitDialog()
            }
        }
        onBackPressedDispatcher.addCallback(this, callback)

    }

    private fun showAlertDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Alert !")
        builder.setMessage("This is an Alert Dialog...")
        builder.setPositiveButton("OK") { dialog, which ->
            Toast.makeText(this@AlertDialogActivity, "Positive Button Clicked", Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("Dismiss") { dialog, which ->
            dialog.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            Toast.makeText(this@AlertDialogActivity, "Negative Button Clicked", Toast.LENGTH_SHORT).show()
        }
        val alertDialog = builder.create()
        alertDialog.show()

    }

    private fun showConfirmExitDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Exit App?")
        builder.setMessage("Are you sure you want to exit this app?")
        builder.setPositiveButton("OK") { dialog, which ->
            finishAffinity()
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }

}