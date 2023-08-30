package com.idn.muslimmedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.muslimmedia.adapter.NewsAdapter
import com.idn.muslimmedia.data.DataNews
import com.idn.muslimmedia.databinding.FragmentTopBinding
import com.idn.muslimmedia.helper.initViewHeadline

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