package com.ui.bookmorning

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ui.bookmorning.ui.viewmodel.BookViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        Log.d("state", "onCreate-BookActivity")


    }

    override fun onPause() {
        super.onPause()
        Log.d("state", "onPause-BookActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d("state", "onStop-BookActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d("state", "onResume-BookActivity")
    }

    override fun onStart() {
        super.onStart()
        Log.d("state", "onStart-BookActivity")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("state", "destroy - BookActivity")
    }
}