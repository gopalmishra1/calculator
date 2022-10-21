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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ramji = findViewById(R.id.ramji)
        seven = findViewById(R.id.seven)
    }
    fun myname(view: View){
        ramji?.append((view as Button).text)

    }
    fun onclear(view: View){
        ramji?.text=""
    }
}