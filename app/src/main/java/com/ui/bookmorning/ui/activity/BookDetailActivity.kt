package com.ui.bookmorning.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ui.bookmorning.databinding.ActivityBookDetailBinding

class BookDetailActivity : AppCompatActivity() {

    companion object {
        private val IMAGE_KEY = "image"
        private val BOOK_NAME_KEY = "bookName"
        private val BOOK_DESCRIPTION = "bookDescription"
        fun newIntent(
            context: Context,
            imageUrl: String,
            bookName: String,
            bookDescription: String
        ): Intent {
            return Intent(context, BookDetailActivity::class.java).apply {
                putExtra(IMAGE_KEY, imageUrl)
                putExtra(BOOK_NAME_KEY, bookName)
                putExtra(BOOK_DESCRIPTION, bookDescription)

            }
        }
    }


    private lateinit var binding: ActivityBookDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = intent.getStringExtra(
            IMAGE_KEY
        )
        val bookName = intent.getStringExtra(
            BOOK_NAME_KEY
        )
        val bookDescription = intent.getStringExtra(
            BOOK_DESCRIPTION
        )

        with(binding) {
            Glide.with(this@BookDetailActivity)
                .load(imageUrl)
                .into(ivBookCover)
            tvBookTitle.text = bookName
            tvBookDescription.text = bookDescription
        }


    }
}