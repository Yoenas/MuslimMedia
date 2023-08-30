package com.idn.muslimmedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.muslimmedia.adapter.NewsAdapter
import com.idn.muslimmedia.data.DataNews
import com.idn.muslimmedia.databinding.FragmentAllNewsBinding
import com.idn.muslimmedia.helper.initViewHeadline

class AllNewsFragment : Fragment() {

    private var _binding: FragmentAllNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAllNewsBinding.inflate(inflater, container, false)

        binding.rvAllNews.apply {
            adapter = NewsAdapter(DataNews.dataAllNews)
            layoutManager = LinearLayoutManager(view?.context)
            setHasFixedSize(true)
        }

        initViewHeadline(binding.newsHeadline, 0)

        return binding.root
    }
}