package com.example.newsapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.data.DataNews
import com.example.newsapp.utils.initViewHeadline
import com.example.newsapp.utils.intentToDetail

class AllNewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_news, container, false)
        val rvAllNews = view.findViewById<RecyclerView>(R.id.rv_news)
        rvAllNews.apply {
            adapter = NewsAdapter(DataNews.dataAllNews)
            layoutManager = LinearLayoutManager(view.context)
            setHasFixedSize(true)
        }

        val cvHeadline = view.findViewById<CardView>(R.id.cv_headline)
        cvHeadline.setOnClickListener {
            intentToDetail(view.context, 0)
        }

        initViewHeadline(view, 0)

        return view
    }
}