package com.rafif.coroutine_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AsyncAwaitDecomposition : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_await_decomposition)

        CoroutineScope(IO).launch {
            val stock1 = getStock1()
            val stock2 = getStock2()

            val total = stock1 + stock2
            Log.i("MyTag", "Result stock: $total ")
        }
    }
}

private suspend fun getStock1(): Int{
    delay(10000)
    Log.i("MyTag", "getStock1: stock 1 finished")
    return 50000
}

private suspend fun getStock2(): Int{
    delay(8000)
    Log.i("MyTag", "getStock2: stock 2 finished")
    return 25000
}