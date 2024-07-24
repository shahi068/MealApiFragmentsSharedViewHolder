package com.adamco.categoryfragmentssharedviewmodel.model.adapters.display_category_adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.adamco.categoryfragmentssharedviewmodel.databinding.CategoryItemBinding
import com.adamco.categoryfragmentssharedviewmodel.model.data.get_category.Category
import com.adamco.categoryfragmentssharedviewmodel.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.adamco.categoryfragmentssharedviewmodel.databinding.ChosenCategoryItemBinding
import com.adamco.categoryfragmentssharedviewmodel.model.data.choose_category.Meal


class ChosenCategoryItemViewHolder(
    val binding: ChosenCategoryItemBinding,
    viewModelStoreOwner: ViewModelStoreOwner
) : ViewHolder(binding.root) {

    private val viewModel: MainViewModel = ViewModelProvider(viewModelStoreOwner)[MainViewModel::class.java]

    fun bindData(meals: Meal){
        with(binding){
            txtMealName.text = meals.strMeal
//            val imageUrl = baseUrl + category.strCategoryThumb
            val imageUrl = meals.strMealThumb + "/preview"
            Picasso.get().load(imageUrl).into(categoryThumbnail)

        }
    }

}