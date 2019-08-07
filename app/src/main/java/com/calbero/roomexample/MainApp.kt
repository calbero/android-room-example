package com.calbero.roomexample

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.calbero.roomexample.data.db.MyDatabase
import com.calbero.roomexample.data.db.PREPOPULATE_AUTHORS
import com.calbero.roomexample.data.db.PREPOPULATE_BOOKS
import com.facebook.stetho.Stetho
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainApp : Application(), CoroutineScope {

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    companion object {
        lateinit var db: MyDatabase
    }

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        initDatabase()
    }

    private fun initDatabase() {
        db = Room.databaseBuilder(this, MyDatabase::class.java, "my-db.db")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    job = Job()
                    launch {
                        MainApp.db.getAuthorDao().insertAll(*PREPOPULATE_AUTHORS)
                        MainApp.db.getBookDao().insertAll(*PREPOPULATE_BOOKS)
                    }
                }
            })
            .build()
    }
}