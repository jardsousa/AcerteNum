package com.example.acerte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PerdeuActivity : AppCompatActivity() {
    private lateinit var btnPerdeu: Button
    private lateinit var aleatorio: Aleatorio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perdeu)

        this.btnPerdeu = findViewById(R.id.btnPerdeu)
        this.aleatorio = Aleatorio(1, 100)
        this.btnPerdeu.setOnClickListener{voltar()}
    }

    fun voltar(){
        finish()
        this.aleatorio.novaRodada()

    }
}