package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class PlayBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_board)

        val button_Menu = findViewById<Button>(R.id.button_Menu)
        button_Menu.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private var oPoints = 0
    private var xPoints = 0
    private var list = arrayListOf<String>("00", "01", "02", "10", "11", "12", "20", "21", "22")

    private fun checkWin(): Boolean {
        val bnt00 : Button = findViewById(R.id.button_00)
        val bnt01 : Button = findViewById(R.id.button_01)
        val bnt02 : Button = findViewById(R.id.button_02)

        val bnt10 : Button = findViewById(R.id.button_10)
        val bnt11 : Button = findViewById(R.id.button_11)
        val bnt12 : Button = findViewById(R.id.button_12)

        val bnt20 : Button = findViewById(R.id.button_20)
        val bnt21 : Button = findViewById(R.id.button_21)
        val bnt22 : Button = findViewById(R.id.button_22)


        val bnt00_txt = bnt00.text
        val bnt01_txt = bnt01.text
        val bnt02_txt = bnt02.text

        val bnt10_txt = bnt10.text
        val bnt11_txt = bnt11.text
        val bnt12_txt = bnt12.text

        val bnt20_txt = bnt20.text
        val bnt21_txt = bnt21.text
        val bnt22_txt = bnt22.text


        var win = false

        // horizontal
        if (bnt00_txt == bnt01_txt && bnt00_txt == bnt02_txt && bnt00_txt != "" && bnt01_txt != "" && bnt02_txt != "") win = true
        else if (bnt10_txt == bnt11_txt && bnt10_txt == bnt12_txt && bnt10_txt != "" && bnt11_txt != "" && bnt12_txt != "") win = true
        else if (bnt20_txt == bnt21_txt && bnt20_txt == bnt22_txt && bnt20_txt != "" && bnt21_txt != "" && bnt22_txt != "") win = true

        // vertical
        else if (bnt00_txt == bnt10_txt && bnt00_txt == bnt20_txt && bnt00_txt != "" && bnt10_txt != "" && bnt20_txt != "") win = true
        else if (bnt01_txt == bnt11_txt && bnt01_txt == bnt21_txt && bnt01_txt != "" && bnt11_txt != "" && bnt21_txt != "") win = true
        else if (bnt02_txt == bnt12_txt && bnt02_txt == bnt22_txt && bnt02_txt != "" && bnt12_txt != "" && bnt22_txt != "") win = true

        // obliquely
        else if (bnt00_txt == bnt11_txt && bnt00_txt == bnt22_txt && bnt00_txt != "" && bnt11_txt != "" && bnt22_txt != "") win = true
        else if (bnt02_txt == bnt11_txt && bnt02_txt == bnt20_txt && bnt02_txt != "" && bnt11_txt != "" && bnt20_txt != "") win = true


        return win
    }

    private fun blockAllButtons(): Unit {
        val bnt00 : Button = findViewById(R.id.button_00)
        val bnt01 : Button = findViewById(R.id.button_01)
        val bnt02 : Button = findViewById(R.id.button_02)

        val bnt10 : Button = findViewById(R.id.button_10)
        val bnt11 : Button = findViewById(R.id.button_11)
        val bnt12 : Button = findViewById(R.id.button_12)

        val bnt20 : Button = findViewById(R.id.button_20)
        val bnt21 : Button = findViewById(R.id.button_21)
        val bnt22 : Button = findViewById(R.id.button_22)

        bnt00.isClickable = false
        bnt01.isClickable = false
        bnt02.isClickable = false

        bnt10.isClickable = false
        bnt11.isClickable = false
        bnt12.isClickable = false

        bnt20.isClickable = false
        bnt21.isClickable = false
        bnt22.isClickable = false
    }

    private fun winOrNot(symbol: Char): Unit {
        val myTxt:TextView = findViewById(R.id.text_view_move)
        val oTxt: TextView = findViewById(R.id.text_view_Points_O)
        val xTxt: TextView = findViewById(R.id.text_view_Points_X)

        val bool = checkWin()
        if (bool) {
            blockAllButtons()
            myTxt.text = "$symbol WINS!!!"

            if (symbol.toString() == "O") {
                oPoints++
                oTxt.text = "" + oPoints
            }
            else{
                xPoints++
                xTxt.text = "" + xPoints
            }
        }
        else{
            if (symbol.toString() == "O") myTxt.text = "X move" else myTxt.text = "O move"
            if (list.size <= 0) myTxt.text = "!!! TIE !!!"
        }
    }

    fun onClick_button_00(view: View) {
        val myTxt:TextView = findViewById(R.id.text_view_move)
        val myBnt:Button = findViewById(R.id.button_00)

        val symbol = myTxt.text[0]
        myBnt.text = symbol.toString()
        myBnt.isClickable = false

        val numBnt = "00"
        removeButtonFromList(numBnt)

        winOrNot(symbol)
    }
    fun onClick_button_01(view: View) {
        val myTxt:TextView = findViewById(R.id.text_view_move)
        val myBnt:Button = findViewById(R.id.button_01)

        val symbol = myTxt.text[0]
        myBnt.text = symbol.toString()
        myBnt.isClickable = false

        val numBnt = "01"
        removeButtonFromList(numBnt)

        winOrNot(symbol)
    }
    fun onClick_button_02(view: View) {
        val myTxt:TextView = findViewById(R.id.text_view_move)
        val myBnt:Button = findViewById(R.id.button_02)

        val symbol = myTxt.text[0]
        myBnt.text = symbol.toString()
        myBnt.isClickable = false

        val numBnt = "02"
        removeButtonFromList(numBnt)

        winOrNot(symbol)
    }
    fun onClick_button_10(view: View) {
        val myTxt:TextView = findViewById(R.id.text_view_move)
        val myBnt:Button = findViewById(R.id.button_10)

        val symbol = myTxt.text[0]
        myBnt.text = symbol.toString()
        myBnt.isClickable = false

        val numBnt = "10"
        removeButtonFromList(numBnt)

        winOrNot(symbol)
    }
    fun onClick_button_11(view: View) {
        val myTxt:TextView = findViewById(R.id.text_view_move)
        val myBnt:Button = findViewById(R.id.button_11)

        val symbol = myTxt.text[0]
        myBnt.text = symbol.toString()
        myBnt.isClickable = false

        val numBnt = "11"
        removeButtonFromList(numBnt)

        winOrNot(symbol)
    }
    fun onClick_button_12(view: View) {
        val myTxt:TextView = findViewById(R.id.text_view_move)
        val myBnt:Button = findViewById(R.id.button_12)

        val symbol = myTxt.text[0]
        myBnt.text = symbol.toString()
        myBnt.isClickable = false

        val numBnt = "12"
        removeButtonFromList(numBnt)

        winOrNot(symbol)
    }
    fun onClick_button_20(view: View) {
        val myTxt:TextView = findViewById(R.id.text_view_move)
        val myBnt:Button = findViewById(R.id.button_20)

        val symbol = myTxt.text[0]
        myBnt.text = symbol.toString()
        myBnt.isClickable = false

        val numBnt = "20"
        removeButtonFromList(numBnt)

        winOrNot(symbol)
    }
    fun onClick_button_21(view: View) {
        val myTxt:TextView = findViewById(R.id.text_view_move)
        val myBnt:Button = findViewById(R.id.button_21)

        val symbol = myTxt.text[0]
        myBnt.text = symbol.toString()
        myBnt.isClickable = false

        val numBnt = "21"
        removeButtonFromList(numBnt)

        winOrNot(symbol)
    }
    fun onClick_button_22(view: View) {
        val myTxt:TextView = findViewById(R.id.text_view_move)
        val myBnt:Button = findViewById(R.id.button_22)

        val symbol = myTxt.text[0]
        myBnt.text = symbol.toString()
        myBnt.isClickable = false

        val numBnt = "22"
        removeButtonFromList(numBnt)

        winOrNot(symbol)
    }

    private fun removeButtonFromList(numBnt: String){
        when(numBnt) {
            "00" -> list.remove("00")
            "01" -> list.remove("01")
            "02" -> list.remove("02")
            "10" -> list.remove("10")
            "11" -> list.remove("11")
            "12" -> list.remove("12")
            "20" -> list.remove("20")
            "21" -> list.remove("21")
            "22" -> list.remove("22")
        }
    }

    fun onClick_Reset(view: View) {
        val myTxt : TextView = findViewById(R.id.text_view_move)

        val bnt00 : Button = findViewById(R.id.button_00)
        val bnt01 : Button = findViewById(R.id.button_01)
        val bnt02 : Button = findViewById(R.id.button_02)

        val bnt10 : Button = findViewById(R.id.button_10)
        val bnt11 : Button = findViewById(R.id.button_11)
        val bnt12 : Button = findViewById(R.id.button_12)

        val bnt20 : Button = findViewById(R.id.button_20)
        val bnt21 : Button = findViewById(R.id.button_21)
        val bnt22 : Button = findViewById(R.id.button_22)

        resetList()

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

        val symbol = myTxt.text[0]
        if (symbol.toString() == "O") myTxt.text = "X move" else myTxt.text = "O move"

    }

    private fun resetList() {
        list.clear()
        list.add("00")
        list.add("01")
        list.add("02")
        list.add("10")
        list.add("11")
        list.add("12")
        list.add("20")
        list.add("21")
        list.add("22")
    }


}