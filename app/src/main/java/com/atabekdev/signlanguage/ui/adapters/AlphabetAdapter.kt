package com.atabekdev.signlanguage.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.data.word.WordData
import com.atabekdev.signlanguage.databinding.ItemAlphabetBinding

class AlphabetAdapter : ListAdapter<WordData, AlphabetAdapter.AViewHolder>(MyDiffUtil) {

    inner class AViewHolder(private val binding: ItemAlphabetBinding) : ViewHolder(binding.root) {
        fun bind() {
            val d = getItem(adapterPosition)
            binding.imageSign.text = d.word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AViewHolder {
        return AViewHolder(
            ItemAlphabetBinding.bind(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_alphabet,
                    parent,
                    false
                )
            )
        )
    }

    override fun onBindViewHolder(holder: AViewHolder, position: Int) {
        holder.bind()
    }

    private object MyDiffUtil: DiffUtil.ItemCallback<WordData>() {
        override fun areItemsTheSame(oldItem: WordData, newItem: WordData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WordData, newItem: WordData): Boolean {
            return oldItem == newItem
        }

    }
}