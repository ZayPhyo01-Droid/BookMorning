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
        // Loading state emit
        liveData.value = BookUiState.Loading


        viewModelScope.launch {
            bookRepository.getBookList().let {
                Log.d("bookList", it.toString())
                liveData.value = BookUiState.Success(it)
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        Log.d("viewmodel", "clear")
    }
}
//readable
//Maintable

sealed class BookUiState {
    object Loading : BookUiState()
    data class Success(val bookList: List<BookModel>) : BookUiState()

    data class Error(
        val icon: String,
        val message: String,
    ) : BookUiState()
}
