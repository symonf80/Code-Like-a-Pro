package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun repost()

}