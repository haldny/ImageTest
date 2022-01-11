package com.haldny.imagetest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.haldny.imagetest.databinding.AnimalViewBinding

class AnimalAdapter(private val context: Context): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    private val items = mutableListOf<Animal>()

    fun setData(newItems: List<Animal>) {
        with(items) {
            clear()
            addAll(newItems)
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = AnimalViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                binding.tvAnimalName.text = name
                val resourceId: Int = context.resources.getIdentifier(name, "drawable", context.packageName)
                binding.ivAnimal.setImageResource(resourceId)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    inner class AnimalViewHolder(val binding: AnimalViewBinding) : RecyclerView.ViewHolder(binding.root)
}