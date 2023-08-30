package com.idn.muslimmedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.muslimmedia.adapter.NewsAdapter
import com.idn.muslimmedia.data.DataNews
import com.idn.muslimmedia.databinding.FragmentPopularBinding
import com.idn.muslimmedia.helper.initViewHeadline

class PopularNewsFragment : Fragment() {

    private var _binding: FragmentPopularBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPopularBinding.inflate(inflater, container, false)

        binding.rvPopularNews.apply {
            adapter = NewsAdapter(DataNews.dataPopularNews)
            layoutManager = LinearLayoutManager(view?.context)
            setHasFixedSize(true)
        }

        initViewHeadline(binding.newsHeadline, 2)

        return binding.root
    }
}