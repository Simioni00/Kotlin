package com.example.kotlin_trabalho.controllers
import com.example.kotlin_trabalho.model.Usuario
import android.content.Context
import android.content.SharedPreferences
class UsuarioController(private val context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MY_PREFS", Context.MODE_PRIVATE)
    fun salvarUsuario(usuario: Usuario) {
        if (usuario.nome != null) {
            sharedPreferences.edit().putString("nome", usuario.nome).apply()
        }
    }
    fun obterUsuarioPeloNome(nome: String): Usuario? {
        val nomeSalvo = sharedPreferences.getString("nome", null)
        return if (nomeSalvo == nome) {
            Usuario(nome)
        } else {
            null
        }
    }
}


