package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class hardComputer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hard_computer)

        val buttonMenu = findViewById<Button>(R.id.button_Menu)
        // bestMove()

        val myBnt00: Button = findViewById(R.id.button_00)
        val myBnt01: Button = findViewById(R.id.button_01)
        val myBnt02: Button = findViewById(R.id.button_02)
        val myBnt10: Button = findViewById(R.id.button_10)
        val myBnt11: Button = findViewById(R.id.button_11)
        val myBnt12: Button = findViewById(R.id.button_12)
        val myBnt20: Button = findViewById(R.id.button_20)
        val myBnt21: Button = findViewById(R.id.button_21)
        val myBnt22: Button = findViewById(R.id.button_22)

        myBnt00.visibility = View.GONE
        myBnt01.visibility = View.GONE
        myBnt02.visibility = View.GONE
        myBnt10.visibility = View.GONE
        myBnt11.visibility = View.GONE
        myBnt12.visibility = View.GONE
        myBnt20.visibility = View.GONE
        myBnt21.visibility = View.GONE
        myBnt22.visibility = View.GONE


        buttonMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private val row1: CharArray = charArrayOf('-', '-', '-')
    private val row2: CharArray = charArrayOf('-', '-', '-')
    private val row3: CharArray = charArrayOf('-', '-', '-')
    private var board: Array<CharArray> = arrayOf(row1, row2, row3)

    private val ai = 'X'
    private val human = 'O'
    private var currentPlayer = human

    private var aiPoints = 0
    private var humanPoints = 0


    // ---- sketch ----

    private fun equals3(a: Char, b: Char, c: Char): Boolean {
        return a == b && b == c && a != '-'
    }

    @Suppress("DEPRECATED_IDENTITY_EQUALS")
    private fun checkWinner(): String {
        var winner = "null"

        // horizontal
        for (i in 0..2) {
            if (equals3(board[i][0], board[i][1], board[i][2])) {
                winner = board[i][0].toString()
            }
        }

        // Vertical
        for (i in 0..2) {
            if (equals3(board[0][i], board[1][i], board[2][i])) {
                winner = board[0][i].toString()
            }
        }

        // Diagonal
        if (equals3(board[0][0], board[1][1], board[2][2])) {
            winner = board[0][0].toString()
        }
        if (equals3(board[2][0], board[1][1], board[0][2])) {
            winner = board[2][0].toString()
        }

        var openSpots = 0
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] === '-') {
                    openSpots++
                }
            }
        }

        return if (winner == "null" && openSpots == 0) {
            "tie"
        } else {
            winner
        }
    }

    fun onClick_button_00(view: View) {
        if (currentPlayer == human) {
            if (board[0][0] == '-'){
                board[0][0] = human
                val myBnt: Button = findViewById(R.id.button_00)
                myBnt.text = "O"

                if(!showResult()){
                    currentPlayer = ai
                    bestMove()
                }
            }
        }
    }
    fun onClick_button_01(view: View) {
        if (currentPlayer == human) {
            if (board[0][1] == '-'){
                board[0][1] = human
                val myBnt: Button = findViewById(R.id.button_01)
                myBnt.text = "O"
                if(!showResult()){
                    currentPlayer = ai
                    bestMove()
                }
            }
        }
    }
    fun onClick_button_02(view: View) {
        if (currentPlayer == human) {
            if (board[0][2] == '-'){
                board[0][2] = human
                val myBnt: Button = findViewById(R.id.button_02)
                myBnt.text = "O"
                if(!showResult()){
                    currentPlayer = ai
                    bestMove()
                }
            }
        }
    }
    fun onClick_button_10(view: View) {
        if (currentPlayer == human) {
            if (board[1][0] == '-'){
                board[1][0] = human
                val myBnt: Button = findViewById(R.id.button_10)
                myBnt.text = "O"
                if(!showResult()){
                    currentPlayer = ai
                    bestMove()
                }
            }
        }
    }
    fun onClick_button_11(view: View) {
        if (currentPlayer == human) {
            if (board[1][1] == '-'){
                board[1][1] = human
                val myBnt: Button = findViewById(R.id.button_11)
                myBnt.text = "O"
                if(!showResult()){
                    currentPlayer = ai
                    bestMove()
                }
            }
        }
    }
    fun onClick_button_12(view: View) {
        if (currentPlayer == human) {
            if (board[1][2] == '-'){
                board[1][2] = human
                val myBnt: Button = findViewById(R.id.button_12)
                myBnt.text = "O"
                if(!showResult()){
                    currentPlayer = ai
                    bestMove()
                }
            }
        }
    }
    fun onClick_button_20(view: View) {
        if (currentPlayer == human) {
            if (board[2][0] == '-'){
                board[2][0] = human
                val myBnt: Button = findViewById(R.id.button_20)
                myBnt.text = "O"
                if(!showResult()){
                    currentPlayer = ai
                    bestMove()
                }
            }
        }
    }
    fun onClick_button_21(view: View) {
        if (currentPlayer == human) {
            if (board[2][1] == '-'){
                board[2][1] = human
                val myBnt: Button = findViewById(R.id.button_21)
                myBnt.text = "O"
                if(!showResult()){
                    currentPlayer = ai
                    bestMove()
                }
            }
        }
    }
    fun onClick_button_22(view: View) {
        if (currentPlayer == human) {
            if (board[2][2] == '-'){
                board[2][2] = human
                val myBnt: Button = findViewById(R.id.button_22)
                myBnt.text = "O"
                if(!showResult()){
                    currentPlayer = ai
                    bestMove()
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun showResult(): Boolean {
        val result = checkWinner()
        if(result != "null"){
            val myTxt: TextView = findViewById(R.id.text_view_move)
            if(result == "tie"){
                myTxt.text = "! TIE !"
            }
            else {
                myTxt.text = "! $result WINS !"
                if(result == "O"){
                    humanPoints++
                    val humanPointsTxt: TextView = findViewById(R.id.text_view_p1)
                    humanPointsTxt.text = "Player O: $humanPoints"
                }
                else if(result == "X"){
                    aiPoints++
                    val aiPointsTxt: TextView = findViewById(R.id.text_view_p2)
                    aiPointsTxt.text = "Computer X: $aiPoints"
                }
            }
            blockAllButtons()
            return true
        }
        else {
            return false
        }
    }


    // ---- minimax ----

    @Suppress("DEPRECATED_IDENTITY_EQUALS")
    private fun bestMove(){
        // AI to make its turn
        var bestScore = -10000
        val move = IntArray(2)
        for (i in 0..2) {
            for (j in 0..2) {
                // Is the spot available?
                if (board[i][j] === '-') {
                    board[i][j] = ai
                    val score = minimax(board, 0, false)
                    board[i][j] = '-'
                    if (score > bestScore) {
                        bestScore = score
                        move[0] = i
                        move[1] = j
                    }
                }
            }
        }
        board[move[0]][move[1]] = ai

        when(move[0].toString() + move[1].toString()) {
            "00" -> {
                val myBnt: Button = findViewById(R.id.button_00)
                myBnt.text = "X"
            }
            "01" -> {
                val myBnt: Button = findViewById(R.id.button_01)
                myBnt.text = "X"
            }
            "02" -> {
                val myBnt: Button = findViewById(R.id.button_02)
                myBnt.text = "X"
            }
            "10" -> {
                val myBnt: Button = findViewById(R.id.button_10)
                myBnt.text = "X"
            }
            "11" -> {
                val myBnt: Button = findViewById(R.id.button_11)
                myBnt.text = "X"
            }
            "12" -> {
                val myBnt: Button = findViewById(R.id.button_12)
                myBnt.text = "X"
            }
            "20" -> {
                val myBnt: Button = findViewById(R.id.button_20)
                myBnt.text = "X"
            }
            "21" -> {
                val myBnt: Button = findViewById(R.id.button_21)
                myBnt.text = "X"
            }
            "22" -> {
                val myBnt: Button = findViewById(R.id.button_22)
                myBnt.text = "X"
            }
        }

        if(!showResult()){
            currentPlayer = human
        }
    }

    @Suppress("DEPRECATED_IDENTITY_EQUALS")
    private fun minimax(board: Array<CharArray>, depth: Int, isMaximizing: Boolean): Int {

        val result = checkWinner()
        if (result !== "null") {
            when (result) {
                "X" -> return 10
                "O" -> return -10
                "tie" -> return 0
            }
        }


        if (isMaximizing) {
            var bestScore = -10000
            for (i in 0..2) {
                for (j in 0..2) {
                    // Is the spot available?
                    if (board[i][j] === '-') {
                        board[i][j] = ai
                        val score = minimax(board, depth + 1, false)
                        board[i][j] = '-'
                        if(score > bestScore){
                            bestScore = score
                        }
                    }
                }
            }
            return bestScore
        } else {
            var bestScore = 10000
            for (i in 0..2) {
                for (j in 0..2) {
                    // Is the spot available?
                    if (board[i][j] === '-') {
                        board[i][j] = human
                        val score = minimax(board, depth + 1, true)
                        board[i][j] = '-'
                        if(score < bestScore){
                            bestScore = score
                        }
                    }
                }
            }
            return bestScore
        }
    }


    // ---- extra ----

    private fun blockAllButtons() {
        val myBnt00: Button = findViewById(R.id.button_00)
        val myBnt01: Button = findViewById(R.id.button_01)
        val myBnt02: Button = findViewById(R.id.button_02)
        val myBnt10: Button = findViewById(R.id.button_10)
        val myBnt11: Button = findViewById(R.id.button_11)
        val myBnt12: Button = findViewById(R.id.button_12)
        val myBnt20: Button = findViewById(R.id.button_20)
        val myBnt21: Button = findViewById(R.id.button_21)
        val myBnt22: Button = findViewById(R.id.button_22)

        myBnt00.isClickable = false
        myBnt01.isClickable = false
        myBnt02.isClickable = false
        myBnt10.isClickable = false
        myBnt11.isClickable = false
        myBnt12.isClickable = false
        myBnt20.isClickable = false
        myBnt21.isClickable = false
        myBnt22.isClickable = false
    }

    @SuppressLint("SetTextI18n")
    fun onClick_Reset(view: View) {
        val myTxt : TextView = findViewById(R.id.text_view_move)
        myTxt.text = "TIC TAC TOE - HARD"

        val bnt00 : Button = findViewById(R.id.button_00)
        val bnt01 : Button = findViewById(R.id.button_01)
        val bnt02 : Button = findViewById(R.id.button_02)

        val bnt10 : Button = findViewById(R.id.button_10)
        val bnt11 : Button = findViewById(R.id.button_11)
        val bnt12 : Button = findViewById(R.id.button_12)

        val bnt20 : Button = findViewById(R.id.button_20)
        val bnt21 : Button = findViewById(R.id.button_21)
        val bnt22 : Button = findViewById(R.id.button_22)

        bnt00.isClickable = true
        bnt01.isClickable = true
        bnt02.isClickable = true

        bnt10.isClickable = true
        bnt11.isClickable = true
        bnt12.isClickable = true

        bnt20.isClickable = true
        bnt21.isClickable = true
        bnt22.isClickable = true

        bnt00.text = ""
        bnt01.text = ""
        bnt02.text = ""

        bnt10.text = ""
        bnt11.text = ""
        bnt12.text = ""

        bnt20.text = ""
        bnt21.text = ""
        bnt22.text = ""

        // reset board
        for(i in 0..2){
            for(j in 0..2){
                board[i][j] = '-'
            }
        }

//        currentPlayer = ai
//        bestMove()

        showOptionsWhoStarts()

    }

    private fun showOptionsWhoStarts() {
        val bnt00 : Button = findViewById(R.id.button_00)
        val bnt01 : Button = findViewById(R.id.button_01)
        val bnt02 : Button = findViewById(R.id.button_02)

        val bnt10 : Button = findViewById(R.id.button_10)
        val bnt11 : Button = findViewById(R.id.button_11)
        val bnt12 : Button = findViewById(R.id.button_12)

        val bnt20 : Button = findViewById(R.id.button_20)
        val bnt21 : Button = findViewById(R.id.button_21)
        val bnt22 : Button = findViewById(R.id.button_22)

        val bntComputerStarts : Button = findViewById(R.id.buttonComputerStarts)
        val bntPlayerStarts : Button = findViewById(R.id.buttonPlayerStarts)
        bntComputerStarts.visibility = View.VISIBLE
        bntPlayerStarts.visibility = View.VISIBLE

        bnt00.visibility = View.INVISIBLE
        bnt01.visibility = View.INVISIBLE
        bnt02.visibility = View.INVISIBLE
        bnt10.visibility = View.INVISIBLE
        bnt11.visibility = View.INVISIBLE
        bnt12.visibility = View.INVISIBLE
        bnt20.visibility = View.INVISIBLE
        bnt21.visibility = View.INVISIBLE
        bnt22.visibility = View.INVISIBLE
    }

    fun onClickPlayerStarts(view: View) {
        val bnt00 : Button = findViewById(R.id.button_00)
        val bnt01 : Button = findViewById(R.id.button_01)
        val bnt02 : Button = findViewById(R.id.button_02)

        val bnt10 : Button = findViewById(R.id.button_10)
        val bnt11 : Button = findViewById(R.id.button_11)
        val bnt12 : Button = findViewById(R.id.button_12)

        val bnt20 : Button = findViewById(R.id.button_20)
        val bnt21 : Button = findViewById(R.id.button_21)
        val bnt22 : Button = findViewById(R.id.button_22)

        val bntComputerStarts : Button = findViewById(R.id.buttonComputerStarts)
        val bntPlayerStarts : Button = findViewById(R.id.buttonPlayerStarts)
        bntComputerStarts.visibility = View.GONE
        bntPlayerStarts.visibility = View.GONE

        bnt00.visibility = View.VISIBLE
        bnt01.visibility = View.VISIBLE
        bnt02.visibility = View.VISIBLE
        bnt10.visibility = View.VISIBLE
        bnt11.visibility = View.VISIBLE
        bnt12.visibility = View.VISIBLE
        bnt20.visibility = View.VISIBLE
        bnt21.visibility = View.VISIBLE
        bnt22.visibility = View.VISIBLE

        currentPlayer = human
    }

    fun onClickComputerStarts(view: View) {
        val bnt00 : Button = findViewById(R.id.button_00)
        val bnt01 : Button = findViewById(R.id.button_01)
        val bnt02 : Button = findViewById(R.id.button_02)

        val bnt10 : Button = findViewById(R.id.button_10)
        val bnt11 : Button = findViewById(R.id.button_11)
        val bnt12 : Button = findViewById(R.id.button_12)

        val bnt20 : Button = findViewById(R.id.button_20)
        val bnt21 : Button = findViewById(R.id.button_21)
        val bnt22 : Button = findViewById(R.id.button_22)

        val bntComputerStarts : Button = findViewById(R.id.buttonComputerStarts)
        val bntPlayerStarts : Button = findViewById(R.id.buttonPlayerStarts)
        bntComputerStarts.visibility = View.GONE
        bntPlayerStarts.visibility = View.GONE

        bnt00.visibility = View.VISIBLE
        bnt01.visibility = View.VISIBLE
        bnt02.visibility = View.VISIBLE
        bnt10.visibility = View.VISIBLE
        bnt11.visibility = View.VISIBLE
        bnt12.visibility = View.VISIBLE
        bnt20.visibility = View.VISIBLE
        bnt21.visibility = View.VISIBLE
        bnt22.visibility = View.VISIBLE

        currentPlayer = ai
        bestMove()
    }
}