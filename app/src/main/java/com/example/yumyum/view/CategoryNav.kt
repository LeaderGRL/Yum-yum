package com.example.yumyum.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.yumyum.R
import com.example.yumyum.databinding.CategoryNavFragmentBinding
import com.example.yumyum.viewmodel.CategoryNavViewModel

class CategoryNav : Fragment(){

    companion object {
        fun newInstance() = CategoryNav()
    }

    private lateinit var viewModel: CategoryNavViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<CategoryNavFragmentBinding>(inflater,
            R.layout.category_nav_fragment, container, false)
        return binding.root
        //return inflater.inflate(R.layout.category_nav_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoryNavViewModel::class.java)
        // TODO: Use the ViewModel
    }

}