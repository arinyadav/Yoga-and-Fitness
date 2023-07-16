package com.example.fitnessandyoga



import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.fitnessandyoga.MainScreenCorousel.SliderModel
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var musicbtn:ImageButton
    lateinit var yogabtn:ImageButton
    lateinit var motivbtn:ImageButton
    lateinit var horobtn:ImageButton

//    private lateinit var mainActivityslider: ImageSlider
//    lateinit var wishUser: TextView
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )

        gretings()
        mainSlider()
        onCardClick()


        val settingsIcon: ImageView = findViewById(R.id.setting_icon)
        settingsIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked=true
            when (menuItem.itemId) {
                R.id.nav_home-> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
            true
        }


    }

    private fun gretings(){
      val wishUser:TextView = findViewById(R.id.wish)
        val timeduration = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val showMessage = when (timeduration) {
            in 0..11 -> "Good Morning"
            in 12..15 -> "Good Afternoon"
            in 16..19 -> "Good Evening"
            else -> "Good Night"
        }
        wishUser.text = showMessage

    }

    private fun mainSlider(){

      val  mainActivityslider:ImageSlider = findViewById(R.id.image_slider)
        val remoteimages: MutableList<SliderModel> = ArrayList()

        FirebaseDatabase.getInstance().reference.child("Slider")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (data in dataSnapshot.children) {
                        val imageUrl = data.child("url").value.toString()
                        val imageTitle = data.child("title").value.toString()
                        val websiteUrl = data.child("websiteUrl").value.toString()

                        val slideModel = SlideModel(imageUrl, imageTitle, ScaleTypes.FIT)
                        val slideModelWithUrl = SliderModel(slideModel, websiteUrl)
                        remoteimages.add(slideModelWithUrl)
                    }

                    mainActivityslider.setImageList(remoteimages.map { it.slideModel }, ScaleTypes.FIT)
                    mainActivityslider.setItemClickListener(object : ItemClickListener {
                        override fun doubleClick(position: Int) {
                        }

                        override fun onItemSelected(i: Int) {
                            val websiteUrl = remoteimages[i].websiteUrl
                            val intent = Intent(Intent.ACTION_VIEW)
                            intent.data = Uri.parse(websiteUrl)
                            startActivity(intent)
                        }
                    })
                }

                override fun onCancelled(databaseError: DatabaseError) {
                }
            })


    }

    private fun onCardClick(){
        val crd1 = findViewById<RelativeLayout>(R.id.motiv_btn)
        crd1.setOnClickListener {

            startActivity(Intent(this, MotivationalQuotesActivity::class.java))
        }

        val crd2 = findViewById<RelativeLayout>(R.id.yoga_btn)
        crd2.setOnClickListener {

            startActivity(Intent(this, YogaActivity::class.java))
        }

        val crd3 = findViewById<RelativeLayout>(R.id.wht_btn)
        crd3.setOnClickListener {

            startActivity(Intent(this, WhiteMusicActivity::class.java))
        }

        val card4 = findViewById<RelativeLayout>(R.id.horo_btn)
        card4.setOnClickListener {

            startActivity(Intent(this, HoroscopeActivity::class.java))
        }
    }

}