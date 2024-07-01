package com.ui.bookmorning.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ui.bookmorning.data.repository.BookRepository
import com.ui.bookmorning.domain.model.BookModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.Continuation

class BookViewModel(private val bookRepository: BookRepository) : ViewModel() {

    //LiveData , MutableLiveData
    val liveData = MutableLiveData<BookUiState>()

    // 2 builder function can call from normal function

    init {
        liveData.value =
            BookUiState(loading = true, listOfBooks = emptyList(), errorMessage = "")


        viewModelScope.launch {
            bookRepository.getBookList().let {
                Log.d("bookList", it.toString())
                liveData.value = BookUiState(
                    loading = false,
                    listOfBooks = it,
                    errorMessage = ""
                )
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("viewmodel", "clear")
    }
}

data class BookUiState(
    val loading: Boolean,
    val listOfBooks: List<BookModel>,
    val errorMessage: String
)
