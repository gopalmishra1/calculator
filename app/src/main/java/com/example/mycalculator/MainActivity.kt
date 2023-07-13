package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private var ramji:TextView?=null
    private var seven:Button?=null
    var lastnumeric:Boolean=false
    var lastdot:Boolean=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ramji = findViewById(R.id.ramji)
        seven = findViewById(R.id.seven)
    }
    fun myname(view: View){
        ramji?.append((view as Button).text)
        lastnumeric=true
        lastdot=false

    }


    fun onclear(view: View){
        ramji?.text=""
    }

    fun onDecimalpoint(view: View){
        ramji?.text?.let{
        if(lastnumeric  && !lastdot ){
            if(abc(it.toString())){
            ramji?.append(".")
            lastnumeric=false
            lastdot=true}
        }

    }}
    private  fun abc(value: String):Boolean {
        return if (value.contains(".")){
            false
        }else{
            true
        }
    }
     fun onoperator(view: View){
        ramji?.text?.let{
            if(lastnumeric && !isoperatoradded(it.toString()))
                ramji?.append((view as Button).text)
            lastnumeric=false
            lastdot=false
        }
    }


   private fun isoperatoradded(value : String):Boolean{
        return if(value.startsWith("-")){
            false }
       else{value.contains("+")||value.contains("-")||
                value.contains("*")||value.contains("/")

        }
    }
    fun onequal(view: View){

        if(lastnumeric){
            var tvValue=ramji?.text.toString()
            var prefix=""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                if (tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    ramji?.text = (one.toDouble() - two.toDouble()).toString()
                }else   if (tvValue.contains("+")) {
                    val splitValue = tvValue.split("+")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    ramji?.text = (one.toDouble() + two.toDouble()).toString()
                }else   if (tvValue.contains("*")) {
                    val splitValue = tvValue.split("*")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    ramji?.text = (one.toDouble() * two.toDouble()).toString()
                }else    if (tvValue.contains("/")) {
                    val splitValue = tvValue.split("/")
                    var one = splitValue[0]
                    var two = splitValue[1]
                    if (prefix.isNotEmpty()){
                        one = prefix + one
                    }
                    ramji?.text = (one.toDouble() /two.toDouble()).toString()
                }
            }
        catch (e: ArithmeticException) {
//hellogi
        ramji?.append(" ")}

        }
    }
}