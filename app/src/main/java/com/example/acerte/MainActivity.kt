package com.example.acerte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var status: TextView
    private lateinit var minimo: TextView
    private lateinit var maximo: TextView
    private lateinit var palpite: TextInputEditText
    private lateinit var botao: Button
    private lateinit var vencedor: TextView
    private lateinit var aleatorio: Aleatorio
    private val vencedorRes = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == RESULT_OK){
            val nomVencedor = it.data?.getStringExtra("NOME_VENCEDOR")
            if (nomVencedor != null) {
                this.vencedor.text = "VENCEDOR: $nomVencedor"
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.status = findViewById(R.id.status)
        this.minimo = findViewById(R.id.minimo)
        this.maximo = findViewById(R.id.maximo)
        this.palpite = findViewById(R.id.palpite)
        this.botao = findViewById(R.id.botao)
        this.vencedor = findViewById(R.id.vencedor)

        this.aleatorio = Aleatorio(1, 100)
        this.botao.setOnClickListener {
            Clique()
        }
        this.status.setOnLongClickListener(OnLongClickListener{
            this.aleatorio = Aleatorio(1,100)
            this.aleatorio.novaRodada()
            this.minimo.text = aleatorio.getMin().toString()
            this.maximo.text = aleatorio.getMax().toString()
            this.status.text = aleatorio.getStatus().toString()
            Situacao("Reiniciando Jogo")
            true
        })



    }


    private fun Clique() {
        val palpiteText = this.palpite.text.toString()
        if (palpiteText.isNotEmpty()) {
            val palpite = Integer.parseInt(palpiteText)
            this.aleatorio.fazerPalpite(palpite)
            if(this.aleatorio.getStatus() == "VOCÊ PERDEU!"){
                this.telaPerdeu()
            }
            if (this.aleatorio.getStatus() == "VOCÊ GANHOU!"){
                this.telaGanhou()
            }

            this.status.text = aleatorio.getStatus()
            this.minimo.text = aleatorio.getMin().toString()
            this.maximo.text = aleatorio.getMax().toString()

            Situacao("Executando")
        }
        this.palpite.setText("")

    }

    private fun telaPerdeu(){
        val intent = Intent(this, PerdeuActivity::class.java)
        startActivity(intent)

    }
    fun ex(){
        this.aleatorio = Aleatorio(1,100)
        this.aleatorio.novaRodada()
        this.minimo.text = aleatorio.getMin().toString()
        this.maximo.text = aleatorio.getMax().toString()
        this.status.text = aleatorio.getStatus().toString()
        Situacao("Reiniciando Jogo")

    }
    private fun telaGanhou(){
        val intent = Intent(this,GanhouActivity::class.java)
        vencedorRes.launch(intent)
    }

    fun Situacao(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()

    }


}
