package com.example.kotlin_trabalho.controllers
import android.content.Context
import android.content.SharedPreferences
import com.example.kotlin_trabalho.model.Produto

class ProdutoController(private val context: Context) {

    private val PREFS_NAME = "MY_PREFS"

    fun adicionarProduto(produto: Produto) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        val editor: SharedPreferences.Editor = prefs.edit()

        val produtoString = "${produto.foto}|${produto.nome}|${produto.preco}"

        editor.putString("produto_${produto.nome}", produtoString)

        editor.apply()
    }

    // Função para obter um produto
    fun obterProduto(nome: String): Produto? {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        // Obtendo o produto como String
        val produtoString = prefs.getString("produto_$nome", null)

        if (produtoString != null) {
            val partes = produtoString.split("|")
            return Produto(partes[0].toInt(), partes[1], partes[2])
        } else {
            return null
        }
    }
}
