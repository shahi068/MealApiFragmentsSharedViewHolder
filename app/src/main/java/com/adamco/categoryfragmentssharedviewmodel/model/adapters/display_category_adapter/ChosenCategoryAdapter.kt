package com.adamco.categoryfragmentssharedviewmodel.model.adapters.display_category_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.adamco.categoryfragmentssharedviewmodel.databinding.CategoryItemBinding
import com.adamco.categoryfragmentssharedviewmodel.databinding.ChosenCategoryItemBinding
import com.adamco.categoryfragmentssharedviewmodel.model.data.choose_category.Meal
import com.adamco.categoryfragmentssharedviewmodel.model.data.get_category.Category

class ChosenCategoryAdapter(
    private val meals: List<Meal>,
    private val viewModelStoreOwner: ViewModelStoreOwner
) : Adapter<ChosenCategoryItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChosenCategoryItemViewHolder {
        val binding = ChosenCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChosenCategoryItemViewHolder(binding, viewModelStoreOwner)
    }

    override fun getItemCount() = meals.size

    override fun onBindViewHolder(holder: ChosenCategoryItemViewHolder, position: Int) {
        holder.bindData(meals[position])
    }
}
