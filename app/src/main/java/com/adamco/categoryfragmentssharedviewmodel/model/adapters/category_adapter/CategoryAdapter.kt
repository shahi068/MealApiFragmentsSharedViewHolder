package com.adamco.categoryfragmentssharedviewmodel.model.adapters.category_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.adamco.categoryfragmentssharedviewmodel.databinding.CategoryItemBinding
import com.adamco.categoryfragmentssharedviewmodel.model.data.get_category.Category

class CategoryAdapter(
    private val categories: List<Category>,
    private val viewModelStoreOwner: ViewModelStoreOwner
) : Adapter<CategoryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        val binding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryItemViewHolder(binding, viewModelStoreOwner)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.bindData(categories[position])
    }
}
