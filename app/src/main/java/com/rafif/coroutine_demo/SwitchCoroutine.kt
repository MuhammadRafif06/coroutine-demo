package com.rafif.coroutine_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rafif.coroutine_demo.databinding.ActivityMainBinding
import com.rafif.coroutine_demo.databinding.ActivitySwitchCoroutineBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SwitchCoroutine : AppCompatActivity() {

    private lateinit var binding: ActivitySwitchCoroutineBinding

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwitchCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener{
            binding.tvCount.text = score++.toString()
        }

        binding.btnDownloadUserData.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                downloadData()
            }
        }
    }

    private suspend fun downloadData() {
        for (i in 1..2000){
            withContext(Dispatchers.Main){
                binding.tvUserMessage.text = "Download $i% ${Thread.currentThread().name}"
            }
        }
    }
}