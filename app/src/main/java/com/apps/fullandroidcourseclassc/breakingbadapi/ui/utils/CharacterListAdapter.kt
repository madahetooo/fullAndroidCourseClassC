package com.apps.fullandroidcourseclassc.breakingbadapi.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.apps.fullandroidcourseclassc.R
import com.apps.fullandroidcourseclassc.breakingbadapi.model.BreakingBadCharacter
import com.apps.fullandroidcourseclassc.databinding.ItemCharacterBinding
import com.bumptech.glide.Glide

class CharacterListAdapter(private val clickCallBack : ((BreakingBadCharacter) -> Unit)?) :
    androidx.recyclerview.widget.ListAdapter<BreakingBadCharacter, CharacterListAdapter.CharacterViewHolder>(CharacterCompare()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
        holder.itemView.setOnClickListener { clickCallBack?.invoke(character) }
    }

    class CharacterViewHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val txCharacterName: TextView = itemView.findViewById(R.id.txCharacterName)
        private val txCharacterNickName: TextView = itemView.findViewById(R.id.txCharacterNickName)
        private val txCharacterBirthday: TextView = itemView.findViewById(R.id.txCharacterBirthday)
        private val txCharacterOccupation: TextView =
            itemView.findViewById(R.id.txCharacterOccupation)
        private val txCharacterStatus: TextView = itemView.findViewById(R.id.txCharacterStatus)
        private val ivCharacterImage: ImageView = itemView.findViewById(R.id.ivCharacterImage)

        fun bind(character: BreakingBadCharacter) {
            txCharacterName.text = character.name
            txCharacterNickName.text = character.nickname
            txCharacterBirthday.text = character.birthday
            txCharacterOccupation.text = character.occupation.joinToString(" , ")
            txCharacterStatus.text = character.status
            if (character.img != null) {
                Glide.with(itemView).load(character.img).centerCrop().into(ivCharacterImage)
            }
        }

        companion object {
            fun create(parent: ViewGroup): CharacterViewHolder {
                return CharacterViewHolder(
                    ItemCharacterBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }
}

class CharacterCompare : DiffUtil.ItemCallback<BreakingBadCharacter>() {
    override fun areItemsTheSame(
        oldItem: BreakingBadCharacter,
        newItem: BreakingBadCharacter
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: BreakingBadCharacter,
        newItem: BreakingBadCharacter
    ): Boolean {
        return oldItem.name == newItem.name
                && oldItem.nickname == newItem.nickname
                && oldItem.birthday == newItem.birthday
                && oldItem.occupation == newItem.occupation
                && oldItem.img == newItem.img
                && oldItem.status == newItem.status
    }

}
