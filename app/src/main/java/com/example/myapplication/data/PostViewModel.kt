package com.example.myapplication.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Api.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel :ViewModel(){

    private val _post = MutableStateFlow<List<Post>?>(null)
    val posts: MutableStateFlow<List<Post>?> = _post
    var loading = MutableStateFlow(false)
    fun fetchPost() {
        viewModelScope.launch {
            try {
                loading.value=true;
                val response = RetrofitClient.instance.getPost()
                _post.value = response
                loading.value=false
            } catch (e: Exception) {
                // Handle error
                loading.value=false
                e.printStackTrace()
            }
        }
    }

}