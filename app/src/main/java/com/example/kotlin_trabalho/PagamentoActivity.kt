package com.example.kotlin_trabalho

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.view.View
import android.content.Intent

class PagamentoActivity : AppCompatActivity() {
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
