package com.loki.customrm.resource

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loki.customrm.R

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val drawableName = "one.png"
        val drawable = CustomResourceManager.loadDrawable(this, loc, drawableName)


        val image = findViewById<ImageView>(R.id.my_image_two)
        image.setImageDrawable(drawable)

        image?.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}