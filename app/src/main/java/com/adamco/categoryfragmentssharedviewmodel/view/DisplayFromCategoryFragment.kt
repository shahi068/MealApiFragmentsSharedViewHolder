package com.adamco.categoryfragmentssharedviewmodel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.adamco.categoryfragmentssharedviewmodel.R
import com.adamco.categoryfragmentssharedviewmodel.databinding.FragmentDisplayFromCategoryBinding
import com.adamco.categoryfragmentssharedviewmodel.model.adapters.category_adapter.CategoryAdapter
import com.adamco.categoryfragmentssharedviewmodel.model.adapters.display_category_adapter.ChosenCategoryAdapter
import com.adamco.categoryfragmentssharedviewmodel.model.data.choose_category.Meal
import com.adamco.categoryfragmentssharedviewmodel.viewmodel.MainViewModel


class DisplayFromCategoryFragment : Fragment() {
  private lateinit var binding : FragmentDisplayFromCategoryBinding
  lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisplayFromCategoryBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        setupObservers()

        return binding.root
    }



    private fun setupObservers() {
        viewModel.category.observe(viewLifecycleOwner) {
            viewModel.displayChosenCategory(it)
        }
        viewModel.displayCategoryResult.observe(viewLifecycleOwner) { response ->
            response.meals?.let {
                showCategoryOnBoard(it)
            }
        }
    }

    private fun showCategoryOnBoard(meals: List<Meal>) {
        val adapter = ChosenCategoryAdapter(meals, requireActivity())
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = adapter
    }

}