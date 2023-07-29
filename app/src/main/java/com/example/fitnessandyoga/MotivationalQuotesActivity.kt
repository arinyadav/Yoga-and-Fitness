package com.example.fitnessandyoga

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.fitnessandyoga.databinding.MotivationalquotesBinding


class MotivationalQuotesActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var binding:MotivationalquotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.motivationalquotes)

        //Now creating mainViewModel instance by following syntax
        mainViewModel= ViewModelProvider(this,MainViewModelFactory(application)).get(MainViewModel::class.java)

        //Handling mainViewModel directlt in layout itself.
//        mainViewModel.quoteLive.observe(this,{
//            binding.quote=mainViewModel.quoteLive.value
//        })
        binding.mainViewModel=mainViewModel
        binding.lifecycleOwner=this
    }

    fun onShare(view: View) {
        val intent= Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,"${mainViewModel.getQuote().text} \n~${mainViewModel.getQuote().author}")
        startActivity(intent)
    }
}
