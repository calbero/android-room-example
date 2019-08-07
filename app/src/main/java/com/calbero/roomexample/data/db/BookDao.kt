package com.calbero.roomexample.data.db

import androidx.room.Dao
import androidx.room.Query
import com.calbero.roomexample.data.models.Book
import com.calbero.roomexample.data.models.BookAuthor

@Dao
interface BookDao : BaseDao<Book> {

    @Query("SELECT * FROM books")
    suspend fun findAll(): MutableList<Book>

    @Query("SELECT books.name AS bookName, authors.name AS authorName, authors.surname AS authorSurname" +
            " FROM books, authors WHERE books.authorId = authors.id")
    suspend fun findAllBooksAuthors(): MutableList<BookAuthor>
}