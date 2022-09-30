package com.rafif.coroutine_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThreadName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_name)

        CoroutineScope(Dispatchers.IO).launch {
            Log.i("MyTag", "onCreate: Hello from one ${Thread.currentThread().name.toString()}")
        }
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("MyTag", "onCreate: Hello from two ${Thread.currentThread().name.toString()}")
        }
        CoroutineScope(Dispatchers.Main).launch {
            Log.i("MyTag", "onCreate: Hello from three ${Thread.currentThread().name.toString()}")
        }
    }
}