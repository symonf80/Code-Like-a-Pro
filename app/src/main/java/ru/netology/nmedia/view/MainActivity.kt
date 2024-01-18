package ru.netology.nmedia.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.nmedia.R
import ru.netology.nmedia.service.Service
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.repository.Post
import ru.netology.nmedia.viewModel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: PostViewModel by viewModels()
        val service = Service()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                tvlikes.text = service.counter(post.likes)
                tvShare.text = service.counter(post.repost)
                tvViews.text = service.counter(post.views)
                likes.setImageResource(
                    if (post.likedByMe) R.drawable.baseline_favorite_24 else R.drawable.likes
                )

                likes.setOnClickListener {
                    viewModel.like()

                }
                share.setOnClickListener {
                    viewModel.repost()
                }
            }
        }
    }
}