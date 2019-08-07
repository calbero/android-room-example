package com.calbero.roomexample.data.models

data class BookAuthor(val bookName: String,
                      val authorName: String,
                      val authorSurname: String) {

    fun getFullName(): String {
        return "$authorName $authorSurname"
    }
}