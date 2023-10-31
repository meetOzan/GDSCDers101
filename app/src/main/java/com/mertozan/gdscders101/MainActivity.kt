package com.mertozan.gdscders101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val diceList = listOf<Dice>(
        Dice(1,R.drawable.dice_1),
        Dice(2,R.drawable.dice_2),
        Dice(3,R.drawable.dice_3),
        Dice(4,R.drawable.dice_4),
        Dice(5,R.drawable.dice_5),
        Dice(6,R.drawable.dice_6)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageDice = findViewById<ImageView>(R.id.imageDice)
        val buttonDice = findViewById<Button>(R.id.buttonRollTheDice)
        val textDice = findViewById<TextView>(R.id.tvNumberOfDice)

        buttonDice.setOnClickListener {
            val diceNumber = rollDice()

            imageDice.setImageResource(diceList[diceNumber].image)
            textDice.text = diceList.get(diceNumber).number.toString()

            Toast.makeText(this,"Dice Number: ${diceList.get(diceNumber).number}",Toast.LENGTH_SHORT).show()
        }
    }

    fun rollDice() : Int{
        return (0..5).random()
    }
}