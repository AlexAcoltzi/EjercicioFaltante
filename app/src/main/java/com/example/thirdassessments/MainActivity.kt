package com.example.thirdassessments

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var cache: Cache

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cache = Cache(this)

        init()
    }

    private fun init() {
        println(cache.add("test1", "hello world"))
        println(cache.add("test2", "kotlin"))
        println(cache.get("test1"))
        println(cache.get("test2"))
        println(cache.update("test2", "Hola Mundo"))
        println(cache.get("test13"))
        println(cache.get("test2"))

    }

    class Cache(context: Context) {

        val SHARED_NAME = "dataCache"

        val storage = context.getSharedPreferences(SHARED_NAME, 0)

        fun add(Key: String, data: String): String {
            storage.edit().putString(Key, data).apply()
            return "Save"
        }

        fun get(Key: String): String? {
            if (storage.contains(Key)) {
                return storage.getString(Key, "")
            }
            return "Empty"
        }

        fun update(Key: String, reSave: String): String {
            if (storage.contains(Key)) {
                storage.edit().putString(Key, reSave).apply()
                return "Update"
            }
            return "Unknown"
        }
    }
}