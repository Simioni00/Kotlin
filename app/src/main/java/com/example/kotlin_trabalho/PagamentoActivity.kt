package com.example.kotlin_trabalho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.view.View
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface


class PagamentoActivity : AppCompatActivity() {

    var shouldNavigateToMain = false // Variável de controle

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_pagamento)
        } catch (e: Exception) {
            // Lidar com erros na inflação do layout
            Log.e("PagamentoActivity", "Erro na inflação do layout: ${e.message}")
            Toast.makeText(this, "Ops! Algo deu errado ao carregar a página de pagamento.", Toast.LENGTH_SHORT).show()
            finish() // Pode decidir finalizar a atividade se ocorrer um erro
        }
    }

    fun onClickMainActivity(view: View) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Confirmação")
        alertDialog.setMessage("Tem certeza de que deseja ir para o menu de desenvolvedor?")

        alertDialog.setPositiveButton("Sim") { dialog, which ->
            shouldNavigateToMain = true // Configura a variável para indicar que o usuário escolheu "Sim"
            // Inicie a próxima atividade após o usuário escolher "Sim"
            startMainActivity()
        }

        alertDialog.setNegativeButton("Não") { dialog, which ->
            shouldNavigateToMain = false // Configura a variável para indicar que o usuário escolheu "Não"
        }

        alertDialog.setCancelable(false) // Impede que o usuário feche o diálogo pressionando fora dele

        alertDialog.show()
    }

    private fun startMainActivity() {
        if (shouldNavigateToMain) {
            try {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                // Lidar com erros ao iniciar a próxima atividade
                Log.e("OutraAtividade", "Erro ao iniciar a MainActivity: ${e.message}")
                Toast.makeText(this, "Ops! Algo deu errado. Por favor, tente novamente.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
