package com.bootcamp.bootcampandroididn.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.bootcampandroididn.DetailActivity
import com.bootcamp.bootcampandroididn.data.Hero
import com.bootcamp.bootcampandroididn.databinding.ItemRowHeroBinding

class ListHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

	inner class ListViewHolder(val binding: ItemRowHeroBinding) : RecyclerView.ViewHolder(binding.root)

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
		return ListViewHolder(ItemRowHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false))
	}

	override fun getItemCount(): Int {
		return listHero.size
	}

	override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
		val (name, description, photo) = listHero[position]

		holder.binding.imgItemPhoto.setImageResource(photo)
		holder.binding.tvItemName.text = name
		holder.binding.tvItemDescription.text = description

		holder.binding.cardView.setOnClickListener {
			val intent = Intent(holder.itemView.context,DetailActivity::class.java)
//			intent.putExtra(DetailActivity.EXTRA_HERO,listHero[position])
			holder.itemView.context.startActivity(intent)
		}

	}

}