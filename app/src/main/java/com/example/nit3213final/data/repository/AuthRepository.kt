package com.example.nit3213final.data.repository

import com.example.nit3213final.data.model.LoginRequest
import com.example.nit3213final.data.model.LoginResponse
import com.example.nit3213final.data.remote.ApiService
import jakarta.inject.Inject

class AuthRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun login(username: String, password: String): Result<LoginResponse> {
        return try {
            val response = apiService.login(LoginRequest(username, password))
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
