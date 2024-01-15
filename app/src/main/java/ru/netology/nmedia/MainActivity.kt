package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val service = Service()
        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий",
            published = "21 мая в 18:36",
            content = "Привет,это новая Нетология!Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну,разработке,аналитике и управлению.Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим,что в каждом уже есть сила,которая заставляет хотеть больше,целиться выше,бежать быстрее. Наша миссия-помочь встать на путь роста и начать цепочку перемен - http//netolo.gy/fyb",
            likes = 5999,
            views = 300,
            repost = 1299
        )
        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            tvlikes.text = service.counter(post.likes)
            tvShare.text = service.counter(post.repost)
            tvViews.text = service.counter(post.views)
            if (post.likedByMe) {
                likes.setImageResource(R.drawable.baseline_favorite_24)
            }
            likes.setOnClickListener {
                println("likes")
                if (post.likedByMe) post.likes-- else post.likes++
                post.likedByMe = !post.likedByMe
                likes.setImageResource(if (post.likedByMe) R.drawable.baseline_favorite_24 else R.drawable.likes)
                tvlikes.text = service.counter(post.likes)
            }
            share.setOnClickListener {
                println("share")
                post.repost++
                tvShare.text = service.counter(post.repost)
            }

            root.setOnClickListener {
                println("root")
            }
            avatar.setOnClickListener {
                println("avatar")
            }

        }

    }


}


