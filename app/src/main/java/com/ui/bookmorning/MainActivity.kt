package com.ui.bookmorning


import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ui.bookmorning.databinding.ActivityMainBinding
import com.ui.bookmorning.ui.adapter.BookAdapter
import com.ui.bookmorning.ui.viewmodel.BookViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val bookViewModel: BookViewModel by viewModel()
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookAdapter: BookAdapter = BookAdapter()
        binding.rvBookList.adapter = bookAdapter
        bookViewModel.liveData.observe(this) {
            Log.d("bookList" , it.toString())
            bookAdapter.updateList(it)
        }

    }

    override fun onPause() {
        super.onPause()
        Log.d("state", "onPause  - MainActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d("state", "onStop  - MainActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d("state", "onResume  - MainActivity")
    }

    override fun onStart() {
        super.onStart()
        Log.d("state", "onStart  - MainActivity")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("state", "destroy - MainActivity")

    }


}