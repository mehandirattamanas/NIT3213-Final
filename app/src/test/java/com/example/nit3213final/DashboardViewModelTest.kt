package com.example.nit3213final

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.nit3213final.data.model.DashboardResponse
import com.example.nit3213final.data.model.Entity
import com.example.nit3213final.data.repository.DashboardRepository
import com.example.nit3213final.viewmodel.DashboardViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

@ExperimentalCoroutinesApi
class DashboardViewModelTest {

    // Rule to allow LiveData to work synchronously
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val dashboardRepository: DashboardRepository = mockk()
    private val viewModel = DashboardViewModel(dashboardRepository)

    @Test
    fun `fetchDashboardData should update dashboardData with success result`() = runTest {
        // Arrange
        val keypass = "testKeypass"
        val dummyResponse = DashboardResponse(
            entities = listOf(
                Entity(property1 = "Entity1", property2 = "Value1", description = "Description1"),
                Entity(property1 = "Entity2", property2 = "Value2", description = "Description2")
            ),
            entityTotal = 2
        )

        coEvery { dashboardRepository.getDashboardData(keypass) } returns Result.success(dummyResponse)

        // Act
        viewModel.fetchDashboardData(keypass)

        // Observe the LiveData
        val observer = mockk<Observer<Result<DashboardResponse>>>(relaxed = true)
        viewModel.dashboardData.observeForever(observer)

        // Assert
        verify { observer.onChanged(Result.success(dummyResponse)) }
        assertEquals(dummyResponse.entities.size, viewModel.dashboardData.value?.getOrNull()?.entities?.size)
    }

    @Test
    fun `fetchDashboardData should update dashboardData with failure result`() = runTest {
        // Arrange
        val keypass = "testKeypass"
        val dummyException = Exception("Network Error")

        coEvery { dashboardRepository.getDashboardData(keypass) } returns Result.failure(dummyException)

        // Act
        viewModel.fetchDashboardData(keypass)

        // Observe the LiveData
        val observer = mockk<Observer<Result<DashboardResponse>>>(relaxed = true)
        viewModel.dashboardData.observeForever(observer)

        // Assert
        verify { observer.onChanged(Result.failure(dummyException)) }
        assertEquals(true, viewModel.dashboardData.value?.isFailure == true)
    }
}