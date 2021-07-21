package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_Play = findViewById<Button>(R.id.button_Play)
        button_Play.setOnClickListener{
            val intent = Intent(this, PlayBoard::class.java)
            startActivity(intent)
        }

        val button_vsComputer = findViewById<Button>(R.id.button_vsComputer)
        button_vsComputer.setOnClickListener{
            val intent = Intent(this, vsComputer::class.java)
            startActivity(intent)
        }
    }
}