package com.example.marvel.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.databinding.ItemCharacterBinding
import com.example.marvel.model.dataclases.CharacterInfo
import com.example.marvel.utils.ConstantsUrl
import com.example.marvel.utils.loadImage

class CharactersAdapter: RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private val listCharacters: ArrayList<CharacterInfo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = listCharacters.size

    fun addData(newCharacters: List<CharacterInfo>) {
        listCharacters.addAll(newCharacters)
        notifyDataSetChanged()
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val character = listCharacters[position]
            binding.nameTextView.text = character.name
            binding.imageImageView.loadImage(
                (character.imageInfo.path
                        + ConstantsUrl.ImageAspect.PORTRAIT.urlParam
                        + ConstantsUrl.ImageAspectSize.FANTASTIC.urlParam
                        + character.imageInfo.extension).replace("http", "https")
            )
        }
    }

}