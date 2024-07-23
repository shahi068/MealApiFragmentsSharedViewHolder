package com.adamco.categoryfragmentssharedviewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adamco.categoryfragmentssharedviewmodel.model.data.choose_category.SelectedCategoryResponse
import com.adamco.categoryfragmentssharedviewmodel.model.data.get_category.MealCategoriesResponse
import com.adamco.categoryfragmentssharedviewmodel.model.remote.ApiClient
import com.adamco.categoryfragmentssharedviewmodel.model.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel() : ViewModel() {
    private val _category = MutableLiveData<String>()
    val category: LiveData<String> = _category
    private val apiService: ApiService = ApiClient.retrofit.create(ApiService::class.java)
    val mealCategoriesResult = MutableLiveData<MealCategoriesResponse>()
    val displayCategoryResult = MutableLiveData<SelectedCategoryResponse>()
    val error = MutableLiveData<String>()

    fun updateCategory(newCategory: String) {
        _category.postValue(newCategory)
    }

    fun showCategories(){
        val call = apiService.getCategories()

        call.enqueue(object : Callback<MealCategoriesResponse> {
            override fun onResponse(
                call: Call<MealCategoriesResponse>,
                response: Response<MealCategoriesResponse>
            ) {

                if(!response.isSuccessful) {
                    error.postValue(response.errorBody()?.string() ?: "Unknown server error")
                    return
                }

                val categoryResponse: MealCategoriesResponse? = response.body()

                if(categoryResponse == null) {
                    error.postValue("Empty result from server. Please retry.")
                    return
                }
                mealCategoriesResult.postValue(response.body())

            }

            override fun onFailure(call: Call<MealCategoriesResponse>, t: Throwable) {
                error.postValue("Failed to load result. Error is : $t")
            }

        })
    }


    fun displayChosenCategory(category: String) {
        val call = apiService.filterByCategory(category)

        call.enqueue(object : Callback<SelectedCategoryResponse> {
            override fun onResponse(
                call: Call<SelectedCategoryResponse>,
                response: Response<SelectedCategoryResponse>
            ) {
                if (!response.isSuccessful) {
                    error.postValue(response.errorBody()?.string() ?: "Unknown server error")
                    return
                }

                val selectedCategoryResponse: SelectedCategoryResponse? = response.body()

                if (selectedCategoryResponse == null) {
                    error.postValue("Empty result from server. Please retry.")
                    return
                }
                displayCategoryResult.postValue(selectedCategoryResponse!!)
            }

            override fun onFailure(call: Call<SelectedCategoryResponse>, t: Throwable) {
                error.postValue("Failed to load result. Error is: $t")
            }
        })
    }




}