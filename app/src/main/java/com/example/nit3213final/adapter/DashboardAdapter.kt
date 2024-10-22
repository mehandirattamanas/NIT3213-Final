package com.example.nit3213final.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nit3213final.DetailsActivity
import com.example.nit3213final.R
import com.example.nit3213final.data.model.Entity

class DashboardAdapter(
    private var entities: MutableList<Entity>, // Change to MutableList
    private val itemClick: (Entity) -> Unit
) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val property1: TextView = view.findViewById(R.id.tvProperty1)
        val property2: TextView = view.findViewById(R.id.tvProperty2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entity = entities[position]
        holder.property1.text = entity.property1
        holder.property2.text = entity.property2
        holder.itemView.setOnClickListener { itemClick(entity) }
    }

    override fun getItemCount(): Int = entities.size

    // Method to update the list of entities
    fun updateEntities(newEntities: List<Entity>) {
        entities.clear()
        entities.addAll(newEntities)
        notifyDataSetChanged() // Notify the adapter to refresh the view
    }
}

