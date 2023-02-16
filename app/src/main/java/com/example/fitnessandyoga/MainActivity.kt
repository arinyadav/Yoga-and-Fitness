package com.example.fitnessandyoga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btn1:ImageButton
    lateinit var btn2:ImageButton
    lateinit var btn3:ImageButton
    lateinit var btn4:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1=findViewById(R.id.wht_btn)
        btn2=findViewById(R.id.horo_btn)
        btn3=findViewById(R.id.motiv_btn)
        btn4=findViewById(R.id.yoga_btn)

        btn1.setOnClickListener {
            Toast.makeText(this,"Opening White Music",Toast.LENGTH_SHORT).show()

            val Intent= Intent(this,WhiteMusicActivity::class.java)
            startActivity(Intent)
        }

        btn2.setOnClickListener {
            Toast.makeText(this,"Opening Horoscope",Toast.LENGTH_SHORT).show()

            val Intent= Intent(this,WhiteMusicActivity::class.java)
            startActivity(Intent)

        }

        btn3.setOnClickListener {
            Toast.makeText(this,"Opening Motivational Quotes",Toast.LENGTH_SHORT).show()
        }

        btn4.setOnClickListener {
            Toast.makeText(this,"Opening Yoga",Toast.LENGTH_SHORT).show()
        }


    }

}