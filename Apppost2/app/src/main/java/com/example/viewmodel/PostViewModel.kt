package com.example.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apppost2.data.RetrofitInstance
import com.example.apppost2.data.models.CreatePostRequest
import com.example.apppost2.data.models.Post
import com.example.apppost2.data.models.User
import com.example.apppost2.data.models.UserCreateRequest
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    var post: List<Post> by mutableStateOf(listOf())
    var users: List<User> by mutableStateOf(listOf())
    var isLoading by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)
    val userId = 1 // Fixed user ID for testing

    fun fetchUsers() {
        viewModelScope.launch {
            isLoading = true
            try {
                users = RetrofitInstance.api.getUsers()
            } catch (e: Exception) {
                error = e.message
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }

    fun createUser(
        name: String,
        email: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        viewModelScope.launch {
            isLoading = true
            try {
                val newUser = UserCreateRequest(name, email)
                RetrofitInstance.api.createUser(newUser)
                fetchUsers()
                onSuccess()
            } catch (e: Exception) {
                error = e.message
                e.printStackTrace()
                onError()
            } finally {
                isLoading = false
            }
        }
    }

    fun fetchPosts() {
        viewModelScope.launch {
            isLoading = true
            try {
                println("Debug: Fetching posts for user $userId")
                post = RetrofitInstance.api.getPosts(userId)
                println("Debug: Fetched ${post.size} posts")
            } catch (e: Exception) {
                error = e.message
                println("Debug: Error fetching posts - ${e.message}")
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }

    fun createPost(
        title: String,
        content: String,
        onSuccess: () -> Unit,
        onError: () -> Unit
    ) {
        viewModelScope.launch {
            isLoading = true
            try {
                val newPost = CreatePostRequest(title, content)
                RetrofitInstance.api.createPost(userId, newPost)
                fetchPosts()
                onSuccess()
            } catch (e: Exception) {
                error = e.message
                e.printStackTrace()
                onError()
            } finally {
                isLoading = false
            }
        }
    }

    fun deletePost(postId: Int) {
        viewModelScope.launch {
            isLoading = true
            try {
                RetrofitInstance.api.deletePost(postId)
                fetchPosts()
            } catch (e: Exception) {
                error = e.message
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }

    fun updatePost(
        postId: Int,
        title: String,
        content: String
    ) {
        viewModelScope.launch {
            isLoading = true
            try {
                val updatedPost = CreatePostRequest(title, content)
                RetrofitInstance.api.updatePost(postId, updatedPost)
                fetchPosts()
            } catch (e: Exception) {
                error = e.message
                e.printStackTrace()
            } finally {
                isLoading = false
            }
        }
    }

    init {
        fetchPosts()
        fetchUsers()
    }
}