package com.example.nit3213final.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nit3213final.data.model.DashboardResponse
import com.example.nit3213final.data.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val dashboardRepository: DashboardRepository) : ViewModel() {

    private val _dashboardData = MutableLiveData<Result<DashboardResponse>>()
    val dashboardData: LiveData<Result<DashboardResponse>> = _dashboardData

    fun fetchDashboardData(keypass: String) {
        viewModelScope.launch {
            val result = dashboardRepository.getDashboardData(keypass)
            _dashboardData.value = result
        }
    }
}
