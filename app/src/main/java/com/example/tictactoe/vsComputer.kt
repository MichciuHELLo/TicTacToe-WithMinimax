package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.collections.ArrayList
import kotlin.random.Random

class vsComputer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vs_computer)

        val button_easyComputer = findViewById<Button>(R.id.button_easyComputer)
        button_easyComputer.setOnClickListener{
            val intent = Intent(this, easyComputer::class.java)
            startActivity(intent)
        }

        val button_hardComputer = findViewById<Button>(R.id.button_hardComputer)
        button_hardComputer.setOnClickListener{
            val intent = Intent(this, hardComputer::class.java)
            startActivity(intent)
        }
    }
}