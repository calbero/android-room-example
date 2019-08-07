package com.calbero.roomexample.data.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(
    tableName = "books",
    foreignKeys = [
        ForeignKey(entity = Author::class, parentColumns = ["id"], childColumns = ["authorId"])
    ]
)
data class Book (@PrimaryKey(autoGenerate = true) val id: Long,
                 val name: String,
                 val authorId: Long)