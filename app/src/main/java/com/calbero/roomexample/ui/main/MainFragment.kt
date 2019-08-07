package com.calbero.roomexample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calbero.roomexample.R
import com.calbero.roomexample.data.models.Book
import com.calbero.roomexample.data.models.BookAuthor
import com.calbero.roomexample.ui.BaseFragment
import com.calbero.roomexample.ui.addbook.AddBookFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel = MainViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBooks()
        viewModel.books.observe(this, Observer { books ->
            showBooks(books)
        })
        fab_add.setOnClickListener {
            replaceFragment(AddBookFragment(), R.id.contentFrame)
        }
    }

    private fun showBooks(books: MutableList<BookAuthor>) {
        (recyclerView.adapter as ListAdapter).items = books
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        recyclerView = rv_books
        recyclerView.adapter = ListAdapter(mutableListOf()) {

        }
        recyclerView.layoutManager = LinearLayoutManager(context)
    }
}