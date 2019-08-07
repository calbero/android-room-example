package com.calbero.roomexample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.calbero.roomexample.data.models.Author
import com.calbero.roomexample.data.models.Book

@Database(
    entities = [Book::class, Author::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun getBookDao(): BookDao

    abstract fun getAuthorDao(): AuthorDao
}