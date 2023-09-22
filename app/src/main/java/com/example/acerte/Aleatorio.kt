package com.example.acerte

import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText


import kotlin.random.Random

class Aleatorio(minimo: Int, maximo: Int) {
    private var minimo: Int = minimo
    private var maximo: Int = maximo
    private var status = "Executando"
    private var sorteado = Random.nextInt(minimo, maximo + 1)

    fun getStatus(): String {
        return status
    }

    fun getMin(): Int {
        return minimo
    }

    fun getMax(): Int {
        return maximo
    }



    fun fazerPalpite(palpite: Int): String {
        if (palpite < minimo || palpite > maximo) {
            this.status = "VOCÊ PERDEU!"
        }
        else if (palpite == sorteado) {
            this.status = "VOCÊ GANHOU!"
        } else if (palpite < sorteado) {
            this.minimo = palpite
            this.status = "TENTE NOVAMENTE"
        } else if (palpite > sorteado) {
            this.maximo = palpite
            this.status = "TENTE NOVAMENTE"
        }

        return this.status
    }


    fun novaRodada() {
        this.minimo = 1
        this.maximo = 100
        this.sorteado = Random.nextInt(minimo, maximo + 1)
        this.status = "Executando"

    }
}
