package com.calbero.roomexample.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.calbero.roomexample.R
import com.calbero.roomexample.data.models.Book
import com.calbero.roomexample.data.models.BookAuthor
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter(var items: MutableList<BookAuthor>,
                  val action: (bookAuthor: BookAuthor) -> Unit) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false) as LinearLayout)
        return item.listen { book -> action(book) }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].bookName
        holder.author.text = items[position].getFullName()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.tv_book_name
        val author = view.tv_book_author
    }

    private fun <T: RecyclerView.ViewHolder> T.listen(event: (bookAuthor: BookAuthor) -> Unit) : T {
        itemView.setOnClickListener {
            event.invoke(items[adapterPosition])
        }
        return this
    }
}