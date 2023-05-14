package com.bootcamp.bootcampandroididn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.bootcampandroididn.adapter.ListHeroAdapter
import com.bootcamp.bootcampandroididn.data.Hero
import com.bootcamp.bootcampandroididn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

	private lateinit var rvHeroes: RecyclerView
	private val list = ArrayList<Hero>()
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.rvHeroes.setHasFixedSize(true)

		list.addAll(getListHeroes())
		showRecyclerList()

	}

	private fun getListHeroes(): ArrayList<Hero> {

		val dataName = resources.getStringArray(R.array.data_name)
		val dataDescription = resources.getStringArray(R.array.data_description)
		val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
		val listHero = ArrayList<Hero>()

		for (i in dataName.indices) {
			val hero = Hero(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
			listHero.add(hero)
		}
		return listHero
	}

	private fun showRecyclerList() {
		binding.rvHeroes.layoutManager = LinearLayoutManager(this)
		val listHeroAdapter = ListHeroAdapter(list)
		binding.rvHeroes.adapter = listHeroAdapter

	}

}