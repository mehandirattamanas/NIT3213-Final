package com.example.nit3213final.data.remote

import com.example.nit3213final.data.model.DashboardResponse
import com.example.nit3213final.data.model.LoginRequest
import com.example.nit3213final.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("/footscray/auth")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @GET("/dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): DashboardResponse

}
