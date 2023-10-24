package com.example.kotlin_trabalho

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_trabalho.databinding.ActivityCadastroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar o botão de cadastro
        binding.btnCadastrar.setOnClickListener {
            val nome = binding.edtNome.text.toString()
            val email = binding.edtEmail.text.toString()
            val senha = binding.edtSenha.text.toString()

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "Digite um e-mail válido", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Inicie o processo de autenticação
                val mAuth = FirebaseAuth.getInstance()
                mAuth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Cadastro bem-sucedido
                            val user: FirebaseUser? = mAuth.currentUser
                            // Use a função para exibir uma mensagem adicional
                            exibirMensagemAdicionalCadastroSucesso()
                            // Você pode adicionar mais lógica aqui, como redirecionar para outra atividade
                        } else {
                            // Se o cadastro falhar, exiba uma mensagem de erro
                            Toast.makeText(this, "Erro ao cadastrar: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }

    // Função para exibir uma mensagem adicional em caso de cadastro bem-sucedido
    private fun exibirMensagemAdicionalCadastroSucesso() {
        Toast.makeText(this, "Seja bem-vindo! Seu cadastro foi realizado com sucesso.", Toast.LENGTH_SHORT).show()
        // Ou você pode exibir uma caixa de diálogo, navegar para outra atividade, etc.
    }
}
