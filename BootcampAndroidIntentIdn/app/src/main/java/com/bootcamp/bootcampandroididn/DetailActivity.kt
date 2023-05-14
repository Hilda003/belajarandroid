package com.bootcamp.bootcampandroididn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bootcamp.bootcampandroididn.data.Hero
import com.bootcamp.bootcampandroididn.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val hero = intent.getParcelableExtra<Hero>(EXTRA_HERO)!!


        binding.apply {
            imgHero.setImageResource(hero.photo)
            txtHeroName.text = hero.nama
            txtDescription.text = hero.description
            btnShare.setOnClickListener {
                shareDescription(hero.description)
            }
        }

    }

    private fun shareDescription(description:String) {
        val intent = Intent()
        intent.apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,description)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(intent,"Share Description")
        startActivity(shareIntent)
    }

    companion object{
        const val EXTRA_HERO = "hero"
    }

}