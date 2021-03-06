package com.example.week3activity1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
         /**
         * This method is called when the Activity is created.
         */
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            // Find the Button in the layout
            val rollButton: Button = findViewById(R.id.button)

            // Set a click listener on the button to roll the dice when the user taps the button
            rollButton.setOnClickListener { rollDice() }
        }

        /**
         * Roll the dice and update the screen with the result.
         */
        @RequiresApi(Build.VERSION_CODES.DONUT)
        private fun rollDice() {
            // Create new Dice object with 6 sides and roll it
            val dice = Dice(6)
            val diceRoll = dice.roll()
            // Find the ImageView in the layout
            val diceImage: ImageView = findViewById(R.id.imageView)

            // Determine which drawable resource ID to use based on the dice roll
            val drawableResource = when (diceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            // Update the ImageView with the correct drawable resource ID
            diceImage.setImageResource(drawableResource)
            // Update the content description
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.DONUT) {
                diceImage.contentDescription = diceRoll.toString()
            }
//            // Update the screen with the dice roll
//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = diceRoll.toString()
        }
    }
/**
 * Dice with a fixed number of sides.
 */
class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}