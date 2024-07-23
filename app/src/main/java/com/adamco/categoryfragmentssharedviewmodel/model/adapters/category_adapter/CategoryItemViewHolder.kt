package com.adamco.categoryfragmentssharedviewmodel.model.adapters.category_adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.adamco.categoryfragmentssharedviewmodel.databinding.CategoryItemBinding
import com.adamco.categoryfragmentssharedviewmodel.model.data.get_category.Category
import com.adamco.categoryfragmentssharedviewmodel.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.adamco.categoryfragmentssharedviewmodel.R

class CategoryItemViewHolder(
    val binding: CategoryItemBinding,
    viewModelStoreOwner: ViewModelStoreOwner
) : ViewHolder(binding.root) {

    private val viewModel: MainViewModel = ViewModelProvider(viewModelStoreOwner)[MainViewModel::class.java]

    fun bindData(category: Category) {
        with(binding) {
            txtCategory.text = category.strCategory
            txtCategoryDesc.text = shortenDesc(category.strCategoryDescription, 300)

            val imageUrl = category.strCategoryThumb

            Picasso.get()
                .load(imageUrl)
                .into(categoryThumbnail)

            entireItem.setOnClickListener {
                viewModel.updateCategory(category.strCategory)
            }
        }
    }

    private fun shortenDesc(description: String, maxLength: Int): String {
        return if (description.length > maxLength) {
            description.substring(0, maxLength) + "..."
        } else {
            description
        }
    }
}
