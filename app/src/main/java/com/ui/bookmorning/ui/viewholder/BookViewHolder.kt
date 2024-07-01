package com.ui.bookmorning.ui.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ui.bookmorning.databinding.ItemViewBookBinding
import com.ui.bookmorning.domain.model.BookModel

class BookViewHolder(private val binding: ItemViewBookBinding) : ViewHolder(binding.root) {

    fun bind(bookModel: BookModel) {
        binding.tvBookTitle.text = bookModel.bookName
    }
}