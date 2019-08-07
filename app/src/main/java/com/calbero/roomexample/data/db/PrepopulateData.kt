package com.calbero.roomexample.data.db

import com.calbero.roomexample.data.models.Author
import com.calbero.roomexample.data.models.Book

val PREPOPULATE_AUTHORS = arrayOf(
    Author(1, "J.R.R", "Tolkien"),
    Author(2, "J.K", "Rowling")
)

val PREPOPULATE_BOOKS = arrayOf(
    Book(1, "The Lord of the Rings", 1),
    Book(2, "Harry Potter and the Secrets Chamber", 2)
)