package com.example.newsapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.data.DataNews
import com.example.newsapp.databinding.FragmentTopBinding
import com.example.newsapp.helper.initViewHeadline

class TopNewsFragment : Fragment() {

    private var _binding: FragmentTopBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTopBinding.inflate(inflater, container, false)

        binding.rvTopNews.apply {
            adapter = NewsAdapter(DataNews.dataTopNews)
            layoutManager = LinearLayoutManager(view?.context)
            setHasFixedSize(true)
        }

        initViewHeadline(binding.newsHeadline, 1)

        return binding.root
    }

}