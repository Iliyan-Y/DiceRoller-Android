package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
         diceImage = findViewById(R.id.dice_image)

        rollButton.setOnClickListener {
           rollDice()
        }
    }

    private fun rollDice() {
        val rollResult: TextView = findViewById(R.id.roll_result)
        val randomNumber = Random.nextInt(1, 7).toString()
        rollResult.text = randomNumber
        makeToast(randomNumber)
        changeImageView(randomNumber)
    }

    private fun makeToast(randomNumber: String) {
        Toast.makeText(this, "You roll $randomNumber", Toast.LENGTH_SHORT).show()
    }

    private fun changeImageView(randomNumber: String) {
        when (randomNumber) {
            "1" -> diceImage.setImageResource(R.drawable.dice_1)
            "2" -> diceImage.setImageResource(R.drawable.dice_2)
            "3" -> diceImage.setImageResource(R.drawable.dice_3)
            "4" -> diceImage.setImageResource(R.drawable.dice_4)
            "5" -> diceImage.setImageResource(R.drawable.dice_5)
            else -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }
}