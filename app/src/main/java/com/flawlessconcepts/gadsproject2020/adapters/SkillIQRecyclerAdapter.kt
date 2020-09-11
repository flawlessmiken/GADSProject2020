package com.flawlessconcepts.gadsproject2020.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flawlessconcepts.gadsproject2020.data.Learner
import com.flawlessconcepts.gadsproject2020.data.Skiller
import com.flawlessconcepts.gadsproject2020.databinding.ItemLearnerListBinding
import com.flawlessconcepts.gadsproject2020.databinding.ItemSkilliqListBinding

class SkillIQRecyclerAdapter : ListAdapter<Skiller,
        SkillIQRecyclerAdapter.SkillerItemViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): SkillIQRecyclerAdapter.SkillerItemViewHolder {
        return SkillerItemViewHolder(ItemSkilliqListBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: SkillIQRecyclerAdapter.SkillerItemViewHolder, position: Int) {
        val skiller = getItem(position)
        holder.bind(skiller)
    }
    companion object DiffCallback : DiffUtil.ItemCallback<Skiller>() {
        override fun areItemsTheSame(oldItem: Skiller, newItem: Skiller): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Skiller, newItem: Skiller): Boolean {
            return oldItem.name == newItem.name
        }

    }


    class SkillerItemViewHolder
        (private var binding: ItemSkilliqListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mSkiller: Skiller) {
            binding.skiller = mSkiller
            binding.executePendingBindings()
        }

    }

}
