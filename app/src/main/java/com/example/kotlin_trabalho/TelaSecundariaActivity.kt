package com.example.kotlin_trabalho

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_trabalho.Adapter.AdapterProduto
import com.example.kotlin_trabalho.model.Produto
import android.content.Context
import android.content.SharedPreferences
import com.example.kotlin_trabalho.R.*
import com.example.kotlin_trabalho.controllers.ProdutoController


class TelaSecundariaActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_secundaria)
       // setContentView(layout.teste)

        val recyclerView_produtos = findViewById<RecyclerView>(id.recyclerView_produtos)
        recyclerView_produtos.layoutManager = LinearLayoutManager(this)
        recyclerView_produtos.setHasFixedSize(true)

        val listaProdutos: MutableList<Produto> = mutableListOf()
        val adapterProduto = AdapterProduto(this, listaProdutos)
        recyclerView_produtos.adapter = adapterProduto

        val produto1 = Produto (
            drawable.abacate,
            "Abacate",
            "12,00"
        )
        listaProdutos.add(produto1)

        val produto2 = Produto(
            drawable.abacaxi,
            "Abacaxi",
            "18,00"
        )
        listaProdutos.add(produto2)

        val produto3 = Produto(
            drawable.banana,
            "Banana",
            "5,00"
        )
        listaProdutos.add(produto3)

        val produto4 = Produto(
            drawable.kiwi,
            "Kiwi",
            "8,00"
        )
        listaProdutos.add(produto4)

        val produto5 = Produto(
            drawable.morango,
            "Morango",
            "10,00"
        )
        listaProdutos.add(produto5)
    }
    val produto5 = Produto(
        drawable.morango,
        "Morango",
        "10,00"
    )

    val produtoController = ProdutoController(this)

    fun onClickPaginaPagamento(view: View) {
        try {
            produtoController.adicionarProduto(produto5)
            val intent = Intent(this, PagamentoActivity::class.java)
            startActivity(intent)
        } catch (e: Exception) {
            // Lidar com erros ao iniciar a próxima atividade
            Log.e("TelaSecundariaActivity", "Erro ao iniciar a atividade de pagamento: ${e.message}")
            Toast.makeText(this, "Ops! Algo deu errado. Por favor, tente novamente.", Toast.LENGTH_SHORT).show()
        }
    }
}
