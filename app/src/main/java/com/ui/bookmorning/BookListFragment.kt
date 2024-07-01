package com.ui.bookmorning

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ui.bookmorning.databinding.FragmentBookListBinding
import com.ui.bookmorning.ui.adapter.BookAdapter
import com.ui.bookmorning.ui.viewmodel.BookViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookListFragment : Fragment() {

    private var _binding: FragmentBookListBinding? = null
    private val bookViewModel: BookViewModel by viewModel()
    private val bookAdapter = BookAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookListBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.rvBookList?.adapter = bookAdapter
        bookViewModel.liveData.observe(viewLifecycleOwner) {
            Log.d("bookList" , it.toString())
            bookAdapter.updateList(it)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = BookListFragment()
    }
}