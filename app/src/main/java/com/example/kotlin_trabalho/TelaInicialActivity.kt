package com.example.kotlin_trabalho

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class TelaInicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicialmain)
    }

    fun onClickProximaPagina(view: View) {
        try {
            val intent = Intent(this, TelaSecundariaActivity::class.java)
            startActivity(intent)
        } catch (e: Exception) {
            // Lidar com erros ao iniciar a próxima atividade
            Log.e("TelaInicialActivity", "Erro ao iniciar a próxima atividade: ${e.message}")
            Toast.makeText(this, "Ops! Algo deu errado. Por favor, tente novamente.", Toast.LENGTH_SHORT).show()
        }
    }

    fun onClickIrParaTelaCadastro(view: View) {
        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }
}
