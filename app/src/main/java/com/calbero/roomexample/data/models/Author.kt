package com.calbero.roomexample.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class Author (@PrimaryKey(autoGenerate = true) val id: Long,
                   val name: String,
                   val surname: String)