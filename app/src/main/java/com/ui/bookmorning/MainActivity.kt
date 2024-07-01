package com.ui.bookmorning


import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ui.bookmorning.databinding.ActivityMainBinding
import com.ui.bookmorning.ui.adapter.BookAdapter
import com.ui.bookmorning.ui.viewmodel.BookViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        changeFragment(
            fragment = BookListFragment.newInstance()
        )

        binding?.bottomNavigation?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    changeFragment(
                        fragment = BookListFragment.newInstance()
                    )
                    true
                }

                R.id.navigation_fav -> {
                    changeFragment(
                        fragment = FavouriteBookList.newInstance()
                    )
                    true
                }

                else -> false
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
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
        binding = null
        super.onDestroy()
        Log.d("state", "destroy - MainActivity")

    }


}