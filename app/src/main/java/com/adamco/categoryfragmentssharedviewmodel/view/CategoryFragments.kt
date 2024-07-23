package com.adamco.categoryfragmentssharedviewmodel.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adamco.categoryfragmentssharedviewmodel.databinding.CategoryFragmentsBinding
import com.adamco.categoryfragmentssharedviewmodel.model.adapters.category_adapter.CategoryAdapter
import com.adamco.categoryfragmentssharedviewmodel.viewmodel.MainViewModel

class CategoryFragments : Fragment() {
    private lateinit var binding: CategoryFragmentsBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CategoryFragmentsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        setupObservers()
        viewModel.showCategories()
        return binding.root
    }

    private fun setupObservers() {



        viewModel.mealCategoriesResult.observe(viewLifecycleOwner) { result ->
            result.categories?.let { categories ->
                val adapter = CategoryAdapter(categories, requireActivity())
                binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.recyclerView.adapter = adapter
            }
        }
    }


}
