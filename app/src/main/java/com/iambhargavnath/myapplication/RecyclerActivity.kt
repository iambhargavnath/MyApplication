package com.iambhargavnath.myapplication

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iambhargavnath.myapplication.adapter.ItemAdapter
import com.iambhargavnath.myapplication.model.Flower

class RecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val assetManager = assets
        val kopou = Drawable.createFromStream(assetManager.open("kopou.jpg"), null)
        val lotus = Drawable.createFromStream(assetManager.open("lotus.jpg"), null)
        val dahlia = Drawable.createFromStream(assetManager.open("dahlia.jpg"), null)
        val pinkRose = Drawable.createFromStream(assetManager.open("pink_rose.jpeg"), null)
        val sunflower = Drawable.createFromStream(assetManager.open("sunflower.jpg"), null)


        val items = listOf(
            Flower("Kopou Flower", "This is an orchid", kopou),
            Flower("Lotus", "This is the symbol of BJP", lotus),
            Flower("Dahlia", "This is a red colored flower but not rose", dahlia),
            Flower("Pink Rose", "This is an rose but not red", pinkRose),
            Flower("Sunflower", "This is a yellow flower which always faces the Sun", sunflower)
        )

        recyclerView.adapter = ItemAdapter(items) { item ->
            Toast.makeText(this, "Clicked: ${item.name}", Toast.LENGTH_SHORT).show()
        }

    }
}