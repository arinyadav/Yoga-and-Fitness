package com.example.fitnessandyoga



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var musicbtn:ImageButton
    lateinit var yogabtn:ImageButton
    lateinit var motivbtn:ImageButton
    lateinit var horobtn:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicbtn=findViewById(R.id.wht_btn)
        yogabtn=findViewById(R.id.yoga_btn)
        motivbtn=findViewById(R.id.motiv_btn)
        horobtn=findViewById(R.id.horo_btn)



        musicbtn.setOnClickListener {
            Toast.makeText(this,"Opening White Music",Toast.LENGTH_SHORT).show()

            val Intent= Intent(this,WhiteMusicActivity::class.java)
            startActivity(Intent)
        }

        horobtn.setOnClickListener {
            Toast.makeText(this,"Opening Horoscope",Toast.LENGTH_SHORT).show()

            val Intent= Intent(this,WhiteMusicActivity::class.java)
            startActivity(Intent)

        }

        motivbtn.setOnClickListener {
            Toast.makeText(this,"Opening Motivational Quotes",Toast.LENGTH_SHORT).show()

            val Intent= Intent(this,WhiteMusicActivity::class.java)
            startActivity(Intent)

        }

        yogabtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, YogaActivity::class.java))

        })




    }

}