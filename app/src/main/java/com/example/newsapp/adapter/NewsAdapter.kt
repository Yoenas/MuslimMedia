package com.example.newsapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.DetailActivity
import com.example.newsapp.data.News
import com.example.newsapp.databinding.RowItemNewsBinding

class NewsAdapter(private val listNews: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RowItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val news = listNews[position]
        holder.binding.apply {
            tvCategory.text = news.category
            tvTitle.text = news.title
            tvDate.text = news.date
            tvTime.text = news.time
            imgNews.setImageResource(news.photo)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.NEWS_DATA, news)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listNews.size
}