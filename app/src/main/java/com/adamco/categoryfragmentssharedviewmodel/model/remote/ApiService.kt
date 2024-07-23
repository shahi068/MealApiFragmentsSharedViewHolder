package com.adamco.categoryfragmentssharedviewmodel.model.remote

import com.adamco.categoryfragmentssharedviewmodel.model.data.choose_category.SelectedCategoryResponse
import com.adamco.categoryfragmentssharedviewmodel.model.data.get_category.MealCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("categories.php")
    fun getCategories() : Call<MealCategoriesResponse>

    @GET("filter.php")
    fun filterByCategory(
        @Query("c") category : String
    ) : Call<SelectedCategoryResponse>
}