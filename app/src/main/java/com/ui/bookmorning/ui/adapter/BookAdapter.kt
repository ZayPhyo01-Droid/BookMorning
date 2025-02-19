package com.ui.bookmorning.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ui.bookmorning.databinding.ItemViewBookBinding
import com.ui.bookmorning.domain.model.book.BookModel
import com.ui.bookmorning.ui.viewholder.BookViewHolder

class BookAdapter(
    private val onClickItem: (String, String, String) -> Unit
) : RecyclerView.Adapter<BookViewHolder>() {

    private var bookList: List<BookModel> = emptyList()
    fun updateList(list: List<BookModel>) {
        bookList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            ItemViewBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClickItem = onClickItem
        )
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookModel = bookList[position])
    }

}