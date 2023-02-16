package com.example.fitnessandyoga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val WhtBtn=findViewById<ImageButton>(R.id.wht_btn)
        WhtBtn.setOnClickListener {
            Toast.makeText(this,"Opening White Music",Toast.LENGTH_SHORT).show()
        }






    }
}