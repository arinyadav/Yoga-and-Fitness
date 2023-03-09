package com.example.fitnessandyoga

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessandyoga.R
import com.example.fitnessandyoga.YogaAdapter

class YogaActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var title: Array<String>
    private var animation: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga)
        supportActionBar?.hide()
        listView = findViewById<ListView>(R.id.list_view)
        title = resources.getStringArray(R.array.title)
        val adapter = YogaAdapter(this@YogaActivity, title)
        animation = AnimationUtils.loadAnimation(this, R.anim.animation1)
        listView.adapter = adapter
        listView.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(adapterView: AdapterView<*>, view: View, i: Int, l: Long) {
                val selectedItem = adapterView.getItemAtPosition(i) as String
                val intent = when (selectedItem) {
                    "Bhujangasana" -> Intent(this@YogaActivity, Bhujangasana::class.java)
                    "Dhanurasana" -> Intent(this@YogaActivity, Dhanurasana::class.java)
                    // Add more cases for each item in the list
                    else-> Intent(this@YogaActivity, MainActivity::class.java)
                }
                startActivity(intent)
            }
        })
    }
}
