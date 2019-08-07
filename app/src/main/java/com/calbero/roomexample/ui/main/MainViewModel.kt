package com.calbero.roomexample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.calbero.roomexample.data.db.Repository
import com.calbero.roomexample.data.models.BookAuthor
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel : ViewModel(), CoroutineScope {

    private lateinit var job: Job
    private val repository = Repository()
    val books: MutableLiveData<MutableList<BookAuthor>> = MutableLiveData()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    fun getBooks() {
        job = Job()
        launch {
            val res = withContext(Dispatchers.IO) {
                repository.findAllBooksAuthors()
            }
            books.postValue(res)
        }
    }
}