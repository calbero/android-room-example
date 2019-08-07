package com.calbero.roomexample.data.db

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg entity: T)

    @Update
    suspend fun update(entity: T)

    @Delete
    suspend fun delet(entity: T)

}