package com.example.kotlin_trabalho

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.kotlin_trabalho.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            _binding = FragmentFirstBinding.inflate(inflater, container, false)
            return binding.root
        } catch (e: Exception) {
            // Lidar com erros na inicialização do Fragment
            Log.e("FirstFragment", "Erro na inicialização do Fragment: ${e.message}")
            Toast.makeText(requireContext(), "Ops! Algo deu errado. Tente novamente.", Toast.LENGTH_SHORT).show()
            // Pode decidir não retornar a view se algo der errado
            return null
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            super.onViewCreated(view, savedInstanceState)

            binding.buttonFirst.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        } catch (e: Exception) {
            // Lidar com erros no código relacionado à view
            Log.e("FirstFragment", "Erro ao configurar a view: ${e.message}")
            Toast.makeText(requireContext(), "Ops! Algo deu errado ao configurar a tela. Tente novamente.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

