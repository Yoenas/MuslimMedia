package com.example.newsapp.helper

import android.content.Intent
import com.example.newsapp.DetailActivity
import com.example.newsapp.data.DataNews
import com.example.newsapp.databinding.NewsHeadlineBinding

fun initViewHeadline(binding: NewsHeadlineBinding, position: Int) {

    binding.apply {
        imgHeadline.setImageResource(DataNews.photoHeadline[position])
        tvTitleHeadline.text = DataNews.titleHeadline[position]
        tvDescHeadline.text = DataNews.contentHeadline[position]
        tvDateHeadline.text = DataNews.dateHeadline[position]
        tvAuthorHeadline.text = DataNews.authorHeadline[position]
    }

    binding.root.setOnClickListener {
        val intentToDetail = Intent(it.context, DetailActivity::class.java)
        intentToDetail.putExtra(DetailActivity.EXTRA_IMG_HEADLINE, DataNews.photoHeadline[position])
        intentToDetail.putExtra(
            DetailActivity.EXTRA_TITLE_HEADLINE,
            DataNews.titleHeadline[position]
        )
        intentToDetail.putExtra(
            DetailActivity.EXTRA_CONTENT_HEADLINE,
            DataNews.contentHeadline[position]
        )
        intentToDetail.putExtra(DetailActivity.EXTRA_DATE_HEADLINE, DataNews.dateHeadline[position])
        intentToDetail.putExtra(
            DetailActivity.EXTRA_AUTHOR_HEADLINE,
            DataNews.authorHeadline[position]
        )
        it.context.startActivity(intentToDetail)
    }
}