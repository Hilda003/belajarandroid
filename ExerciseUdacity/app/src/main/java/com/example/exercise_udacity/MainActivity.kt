package com.example.exercise_udacity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.*


class MainActivity : AppCompatActivity() {
    //membuat variable
    private lateinit var diceImage : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lempar_dadu_main)
        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
           rollDiece()
        }

        diceImage = findViewById(R.id.diceImage)
    }

    private fun rollDiece() {

        val resourceDrawable = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage.setImageResource(resourceDrawable)
    }


}