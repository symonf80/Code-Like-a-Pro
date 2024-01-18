package ru.netology.nmedia.repository

data class Post(
    val id: Int,
    val author:String,
    val content:String,
    val published:String,
    val likes: Int,
    val repost:Int,
    val views:Int,
    val likedByMe: Boolean
)
