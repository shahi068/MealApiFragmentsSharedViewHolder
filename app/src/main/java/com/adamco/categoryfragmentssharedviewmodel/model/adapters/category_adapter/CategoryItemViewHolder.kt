package com.adamco.categoryfragmentssharedviewmodel.model.adapters.category_adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.adamco.categoryfragmentssharedviewmodel.databinding.CategoryItemBinding
import com.adamco.categoryfragmentssharedviewmodel.model.data.get_category.Category
import com.adamco.categoryfragmentssharedviewmodel.viewmodel.MainViewModel
import com.squareup.picasso.Picasso
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.adamco.categoryfragmentssharedviewmodel.MainActivity


class CategoryItemViewHolder(
    val binding: CategoryItemBinding,
    viewModelStoreOwner: ViewModelStoreOwner
) : ViewHolder(binding.root) {

    private val viewModel: MainViewModel = ViewModelProvider(viewModelStoreOwner)[MainViewModel::class.java]

    fun bindData(category: Category){
        with(binding){
            txtID.text = category.idCategory
            txtCategory.text = category.strCategory
            txtCategoryDesc.text = category.strCategoryDescription
//            val imageUrl = baseUrl + category.strCategoryThumb
            val imageUrl = category.strCategoryThumb + "/preview"
            Picasso.get().load(imageUrl).into(categoryThumbnail)

            entireItem.setOnClickListener{
                viewModel.updateCategory(category.strCategory)
            }

        }
    }

}