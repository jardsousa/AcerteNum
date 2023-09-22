package com.example.acerte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class GanhouActivity : AppCompatActivity() {
    private lateinit var btnGanhou: Button
    private lateinit var nometxt: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganhou)

        this.btnGanhou = findViewById(R.id.btnGanhou)
        this.nometxt = findViewById(R.id.nometxt)
        this.btnGanhou.setOnClickListener{voltar()}
    }

    fun voltar(){
        val nome = this.nometxt.text.toString()
        val intent = Intent().apply{
            putExtra("NOME_VENCEDOR", nome)
        }
        setResult(RESULT_OK,intent)
        finish()
    }
}