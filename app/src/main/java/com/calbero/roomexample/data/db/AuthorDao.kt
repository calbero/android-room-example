package com.calbero.roomexample.data.db

import androidx.room.Dao
import com.calbero.roomexample.data.models.Author

@Dao
interface AuthorDao : BaseDao<Author> {
}