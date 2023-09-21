package com.idn.muslimmedia.ui.detail

import android.graphics.Bitmap
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.idn.muslimmedia.R
import com.idn.muslimmedia.data.ArticlesItem
import com.idn.muslimmedia.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)

        setSupportActionBar(binding.toolbarDetail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.news_detail)
        }

        setContentView(binding.root)

        val newsData = when {
            SDK_INT >= 33 -> intent.getParcelableExtra(NEWS_DATA, ArticlesItem::class.java)
            else -> @Suppress("DEPRECATION") intent.getParcelableExtra(NEWS_DATA)
        }
        val newsDate = intent.getStringExtra(EXTRA_DATA_DATE)
        val newsTime = intent.getStringExtra(EXTRA_DATA_TIME)
        val publishedAt = newsDate + newsTime

        binding.apply {
            detailTitle.text = newsData?.title
            detailAuthor.text = newsData?.author
            detailPublishedAt.text = publishedAt
            Picasso.get().load(newsData?.urlToImage).into(detailImage)
            setWebView(newsData)
        }
    }

    private fun setWebView(data: ArticlesItem?) {
        var loadingFinished = true
        var redirect = false

        binding.wvDetail.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                if (!loadingFinished) {
                    redirect = true
                }
                loadingFinished = false
                view?.loadUrl(request?.url.toString())
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                loadingFinished = false
                // Show loading if it is not already visible
                binding.loadingView.root.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                if (!redirect) {
                    loadingFinished = true
                }

                if (loadingFinished && !redirect) {
                    //HIDE LOADING IT HAS FINISHED
                    binding.loadingView.root.visibility = View.GONE
                } else {
                    redirect = false
                }
            }
        }
        data?.url?.let { binding.wvDetail.loadUrl(it) }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val NEWS_DATA = "data"
        const val EXTRA_DATA_DATE = "date"
        const val EXTRA_DATA_TIME = "time"
    }
}