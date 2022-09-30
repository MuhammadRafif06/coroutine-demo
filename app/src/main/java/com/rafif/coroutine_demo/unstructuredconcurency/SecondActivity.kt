package com.rafif.coroutine_demo.unstructuredconcurency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rafif.coroutine_demo.databinding.ActivityMainBinding
import com.rafif.coroutine_demo.databinding.ActivitySecondBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener{
            binding.tvCount.text = score++.toString()
        }

        binding.btnDownloadUserData.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                binding.tvUserMessage.text = UserDataManager1().getTotalUserCount().toString()
            }

//            downloadData()
        }
    }

    private fun downloadData() {
        for (i in                                                                          1..2000){
            Log.i("MyTag", "downloadData: $i")
        }
    }
}