package com.example.nit3213final.data.repository

import com.example.nit3213final.data.model.DashboardResponse
import com.example.nit3213final.data.remote.ApiService
import jakarta.inject.Inject

class DashboardRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getDashboardData(keypass: String): Result<DashboardResponse> {
        return try {
            val response = apiService.getDashboardData(keypass)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
