package com.example.newsapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.data.DataNews
import com.example.newsapp.helper.initViewHeadline

class TopNewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top, container, false)
        val rvAllNews = view.findViewById<RecyclerView>(R.id.rv_top_news)
        rvAllNews.apply {
            adapter = NewsAdapter(DataNews.dataTopNews)
            layoutManager = LinearLayoutManager(view.context)
            setHasFixedSize(true)
        }

        val newsHeadline = view.findViewById<View>(R.id.news_headline)
        initViewHeadline(view.context, newsHeadline, 1)

        return view
    }

}