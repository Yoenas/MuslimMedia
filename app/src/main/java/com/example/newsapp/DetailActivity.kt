package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.data.News
import com.example.newsapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val NEWS_DATA = "data"
        const val EXTRA_IMG_HEADLINE = "image"
        const val EXTRA_TITLE_HEADLINE = "title"
        const val EXTRA_CONTENT_HEADLINE = "desc"
        const val EXTRA_DATE_HEADLINE = "date"
        const val EXTRA_AUTHOR_HEADLINE = "author"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            title = "News Detail"
        }

        val news = intent.getParcelableExtra<News>(NEWS_DATA)

        binding.apply {
            if (news != null) {
                tvTitleDetail.text = news.title
                tvDateDetail.text = news.date
                tvAuthorDetail.text = news.author
                tvContentDetail.text = news.content
                imgNewsDetail.setImageResource(news.photo)
            } else {
                imgNewsDetail.setImageResource(intent.getIntExtra(EXTRA_IMG_HEADLINE, 0))
                tvTitleDetail.text = intent.getStringExtra(EXTRA_TITLE_HEADLINE)
                tvDateDetail.text = intent.getStringExtra(EXTRA_DATE_HEADLINE)
                tvAuthorDetail.text = intent.getStringExtra(EXTRA_AUTHOR_HEADLINE)
                tvContentDetail.text = intent.getStringExtra(EXTRA_CONTENT_HEADLINE)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}