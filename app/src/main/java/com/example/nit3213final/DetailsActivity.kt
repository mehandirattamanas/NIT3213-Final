package com.example.nit3213final

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nit3213final.databinding.ActivityDetailsBinding


class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data passed from the DashboardActivity
        val property1 = intent.getStringExtra("property1") ?: return
        val property2 = intent.getStringExtra("property2") ?: return
        val description = intent.getStringExtra("description") ?: return }}

        // Display the entity