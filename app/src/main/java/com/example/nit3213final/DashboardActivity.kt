package com.example.nit3213final

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nit3213final.adapter.DashboardAdapter
import com.example.nit3213final.databinding.ActivityDashboardBinding
import com.example.nit3213final.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private val dashboardViewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        val adapter = DashboardAdapter(mutableListOf()) { entity ->
            // Navigate to Details Activity with entity information
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("property1", entity.property1)
                putExtra("property2", entity.property2)
                putExtra("description", entity.description)
            }
            startActivity(intent)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe ViewModel for dashboard data
        dashboardViewModel.dashboardData.observe(this) { result ->
            result.onSuccess { response ->
                adapter.updateEntities(response.entities) // Update the adapter with new entities
            }
            result.onFailure {
                Toast.makeText(this, "Failed to load data: ${it.message}", Toast.LENGTH_LONG).show()
            }
        }

        // Fetch data when the activity is created
        fetchDashboardData()
    }

    private fun fetchDashboardData() {
        val keypass = intent.getStringExtra("keypass") ?: return // Get the keypass from intent
        dashboardViewModel.fetchDashboardData(keypass) // Fetch the dashboard data with the keypass
    }
}