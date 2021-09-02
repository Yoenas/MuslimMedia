package com.example.newsapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.data.DataNews
import com.example.newsapp.utils.initViewHeadline
import com.example.newsapp.utils.intentToDetail

class TopNewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_news, container, false)
        val rvAllNews = view.findViewById<RecyclerView>(R.id.rv_news)
        rvAllNews.apply {
            adapter = NewsAdapter(DataNews.dataTopNews)
            layoutManager = LinearLayoutManager(view.context)
            setHasFixedSize(true)
        }

        val cvHeadline = view.findViewById<CardView>(R.id.cv_headline)
        cvHeadline.setOnClickListener {
            intentToDetail(view.context, 1)
        }

        initViewHeadline(view, 1)

        return view
    }

}