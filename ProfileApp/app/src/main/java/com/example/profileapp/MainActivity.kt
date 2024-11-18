package com.example.profileapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ImageView>(R.id.imageProfile)
        val nameText = findViewById<TextView>(R.id.nameText)
        val descriptionText =
    findViewById<TextView>(R.id.descriptionText)
        val currentJobText =
    findViewById<TextView>(R.id.currentJobText)
        val experienceLayout =
    findViewById<LinearLayout>(R.id.experienceLayout)

        nameText.text="Ghost"
        descriptionText.text = "Desenvolvedor de Software com 10 anos de experiência."
        currentJobText.text="Emprego: Engenheira de Software na UFC Quixadá"

          val experiencias = listOf( 
              "Analista de Sistema - Empresa ABC",
              "Desenvolvedor Júnior - Empresa DEF",
              "Estágiario - Empresa GHI"
          )


        for (experiencia in experiencias) {
            val textView = TextView(this)
            textView.text = experiencias.toString()
            textView.textSize = 16f
            experienceLayout.addView(textView)
        }
    }
}