package com.rafif.coroutine_demo.unstructuredconcurency

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserDataManager2 {

    var count = 0
    suspend fun getTotalUserCount() : Int{

        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                count = 50
            }
        }
        return count
    }
}