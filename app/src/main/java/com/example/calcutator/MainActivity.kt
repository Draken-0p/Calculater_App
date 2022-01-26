package com.example.calcutator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var one : TextView
    lateinit var two : TextView
    lateinit var three : TextView
    lateinit var four : TextView
    lateinit var five : TextView
    lateinit var six : TextView
    lateinit var seven : TextView
    lateinit var eight : TextView
    lateinit var nine : TextView
    lateinit var zero : TextView


    lateinit var plus : TextView
    lateinit var minus : TextView
    lateinit var multiply : TextView
    lateinit var divide : TextView
    lateinit var mod : TextView

    lateinit var dot : TextView
    lateinit var equal : TextView
    lateinit var plus_minus : TextView
    lateinit var ac : TextView
    lateinit var back : ImageView

    lateinit var result :TextView
    lateinit var display : TextView

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        plus = findViewById(R.id.plus)
        minus = findViewById(R.id.minus)
        multiply = findViewById(R.id.multiply)
        divide = findViewById(R.id.divide)
        mod = findViewById(R.id.mod)
        dot = findViewById(R.id.dot)
        equal = findViewById(R.id.equal)
        plus_minus = findViewById(R.id.plus_minus)
        ac = findViewById(R.id.ac)
        back = findViewById(R.id.back)

         result =findViewById(R.id.result)
         display =findViewById(R.id.display)

         one.setOnClickListener {
                appendText("1" ,true)
         }
         two.setOnClickListener {
             appendText("2" ,true)
         }
         three.setOnClickListener {
             appendText("3" ,true)
         }
         four.setOnClickListener {
             appendText("4" ,true)
         }
         five.setOnClickListener {
             appendText("5" ,true)
         }
         six.setOnClickListener {
             appendText("6" ,true)
         }
         seven.setOnClickListener {
             appendText("7" ,true)
         }
         eight.setOnClickListener {
             appendText("8" ,true)
         }
         nine.setOnClickListener {
             appendText("9" ,true)
         }
         zero.setOnClickListener {
             appendText("0" ,true)
         }


         plus.setOnClickListener {
             appendText("+" ,false)
         }
         minus.setOnClickListener {
             appendText("-" ,false)
         }
         multiply.setOnClickListener {
             appendText("*" ,false)
         }
         divide.setOnClickListener {
             appendText("/" ,false)
         }
         mod.setOnClickListener {
             appendText("%" ,false)
         }
         back.setOnClickListener {
             result.text = ""
             val value = display.text
             if(value.isNotEmpty()){
                 display.text = value.substring(0,value.length -1)
             }
         }
         ac.setOnClickListener {
             result.text =""
             display.text = ""
         }

         equal.setOnClickListener {
             try {    val exp = ExpressionBuilder(display.text.toString()).build()
                 val ans = exp.evaluate()
                 result.text = ans.toString()
             }
             catch (e: Exception){
                    result.text = e.message
             }
         }

    }


    private fun appendText(value : String ,tobeclear:Boolean){
        if(result.text != ""){
            display.text = ""
        }
            if(tobeclear){
                result.text = ""
                display.append(value)
            } else{
                display.append(result.text)
                display.append(value)
                result.text =""
            }
    }
}