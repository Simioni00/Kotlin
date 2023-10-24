package com.example.kotlin_trabalho
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_trabalho.databinding.ActivityCadastroBinding
import android.widget.Toast

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

            // Validar campos
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "Digite um e-mail válido", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                // Agora você pode prosseguir com o processamento dos dados, já que tudo está válido
                // Por exemplo, enviar para um servidor ou salvar localmente.
                println("Nome: $nome\nEmail: $email\nSenha: $senha")

                // Adicione aqui a lógica para enviar os dados para o servidor ou salvar localmente.
            }
        }
    }
}
