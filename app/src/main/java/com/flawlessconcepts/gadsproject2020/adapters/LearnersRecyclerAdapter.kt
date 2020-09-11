package com.flawlessconcepts.gadsproject2020.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flawlessconcepts.gadsproject2020.data.Learner
import com.flawlessconcepts.gadsproject2020.databinding.ItemLearnerListBinding

class LearnersRecyclerAdapter : ListAdapter<Learner,
        LearnersRecyclerAdapter.LearnerItemViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): LearnersRecyclerAdapter.LearnerItemViewHolder {
        return LearnerItemViewHolder(ItemLearnerListBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: LearnersRecyclerAdapter.LearnerItemViewHolder, position: Int) {
        val learner = getItem(position)
        holder.bind(learner)
    }
    companion object DiffCallback : DiffUtil.ItemCallback<Learner>() {
        override fun areItemsTheSame(oldItem: Learner, newItem: Learner): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Learner, newItem: Learner): Boolean {
            return oldItem.name == newItem.name
        }

    }


    class LearnerItemViewHolder
        (private var binding: ItemLearnerListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mLeaner: Learner) {
            binding.learner = mLeaner
            binding.executePendingBindings()
        }

    }

}
