package com.calbero.roomexample.data.db

import com.calbero.roomexample.MainApp
import com.calbero.roomexample.data.models.Book
import com.calbero.roomexample.data.models.BookAuthor

class Repository {

    private var bookDao: BookDao = MainApp.db.getBookDao()
    private var authorDao: AuthorDao = MainApp.db.getAuthorDao()

    suspend fun insertBook(book: Book) {
        bookDao.insert(book)
    }

    suspend fun findAllBooks(): MutableList<Book> {
        return bookDao.findAll()
    }

    suspend fun findAllBooksAuthors(): MutableList<BookAuthor> {
        return bookDao.findAllBooksAuthors()
    }

}