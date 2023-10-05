package com.example.kotlin_trabalho.model


data class Carrinho(
    val Usuario: Usuario,
    val frutas: MutableList<Produto> = mutableListOf()
)
