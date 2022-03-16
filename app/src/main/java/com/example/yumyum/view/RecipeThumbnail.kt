package com.example.yumyum.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.yumyum.R
import com.example.yumyum.databinding.RecipeThumbnailFragmentBinding
import com.example.yumyum.viewmodel.RecipeThumbnailViewModel

class RecipeThumbnail : Fragment() {

    companion object {
        fun newInstance() = RecipeThumbnail()
    }

    private lateinit var viewModel: RecipeThumbnailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<com.example.yumyum.databinding.RecipeThumbnailFragmentBinding>(inflater,
            R.layout.category_nav_fragment, container, false)
        return binding.root
        //return inflater.inflate(R.layout.category_nav_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecipeThumbnailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}