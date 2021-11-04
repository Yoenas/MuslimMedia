package com.example.newsapp.helper

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.newsapp.DetailActivity
import com.example.newsapp.R
import com.example.newsapp.data.DataNews

fun initViewHeadline(context: Context, view: View, position: Int) {
    val imgHeadline = view.findViewById<ImageView>(R.id.img_headline)
    val tvTitleHeadline = view.findViewById<TextView>(R.id.tv_title_headline)
    val tvDescHeadline = view.findViewById<TextView>(R.id.tv_desc_headline)
    val tvDateHeadline = view.findViewById<TextView>(R.id.tv_date_headline)
    val tvAuthorHeadline = view.findViewById<TextView>(R.id.tv_author_headline)

    imgHeadline.setImageResource(DataNews.photoHeadline[position])
    tvTitleHeadline.text = DataNews.titleHeadline[position]
    tvDescHeadline.text = DataNews.contentHeadline[position]
    tvDateHeadline.text = DataNews.dateHeadline[position]
    tvAuthorHeadline.text = DataNews.authorHeadline[position]

    view.setOnClickListener {
        val intentToDetail = Intent(context, DetailActivity::class.java)
        intentToDetail.putExtra(DetailActivity.EXTRA_IMG_HEADLINE, DataNews.photoHeadline[position])
        intentToDetail.putExtra(DetailActivity.EXTRA_TITLE_HEADLINE, DataNews.titleHeadline[position])
        intentToDetail.putExtra(DetailActivity.EXTRA_CONTENT_HEADLINE, DataNews.contentHeadline[position])
        intentToDetail.putExtra(DetailActivity.EXTRA_DATE_HEADLINE, DataNews.dateHeadline[position])
        intentToDetail.putExtra(DetailActivity.EXTRA_AUTHOR_HEADLINE, DataNews.authorHeadline[position])
        context.startActivity(intentToDetail)
    }
}