package com.example.yumyum.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.example.yumyum.R
import com.example.yumyum.databinding.SearchBarFragmentBinding
import com.example.yumyum.viewmodel.SearchBarViewModel

class searchBar : Fragment() {

    companion object {
        fun newInstance() = searchBar()
    }

    private lateinit var viewModel: SearchBarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val binding = DataBindingUtil.setContentView<SearchBarViewModel>(, R.layout.search_bar_fragment )
        val binding = DataBindingUtil.inflate<SearchBarFragmentBinding>(inflater,
            R.layout.search_bar_fragment, container,false)
        return binding.root
        //return inflater.inflate(R.layout.search_bar_fragment, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.option_menu, menu)
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SearchBarViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}