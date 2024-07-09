package com.ui.bookmorning.ui.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.ui.bookmorning.databinding.ItemViewBookBinding
import com.ui.bookmorning.domain.model.book.BookModel

class BookViewHolder(
    private val binding: ItemViewBookBinding,
    private val onClickItem: (String, String, String) -> Unit
) : ViewHolder(
    binding.root
) {

    fun bind(bookModel: BookModel) {
        binding.tvBookTitle.text = bookModel.bookName
        Glide.with(
            binding.root
        ).load(
            bookModel.bookCover
        ).into(binding.ivBookCover)
        itemView.setOnClickListener {
            onClickItem(
                bookModel.bookCover,
                bookModel.bookName,
                bookModel.bookDescription
            )
        }
    }
}