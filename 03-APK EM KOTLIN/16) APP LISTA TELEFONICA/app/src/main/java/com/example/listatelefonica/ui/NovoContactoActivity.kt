package com.example.listatelefonica.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listatelefonica.R
import com.example.listatelefonica.databinding.ActivityNovoContactoBinding
import com.example.listatelefonica.viewmodel.NovoContactoViewModel

class NovoContactoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNovoContactoBinding
    private lateinit var viewModel: NovoContactoViewModel
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var i: Intent
    private var imagemId: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNovoContactoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        i = intent

        viewModel = ViewModelProvider(this)[NovoContactoViewModel::class.java]
        observe()

        binding.imagemFoto.setOnClickListener {
            launcher.launch(
                Intent(
                    applicationContext,
                    SelecionarImagemContactoActivity::class.java
                )
            )
        }

        binding.buttonGravar.setOnClickListener {
            val nome = binding.editNome.text.toString()
            val email = binding.editEmail.text.toString()
            val endereco = binding.editEndereco.text.toString()
            val telefone = binding.editTelefone.text.toString()
            viewModel.insert(nome, email, endereco, telefone, imagemId)
        }

        binding.buttonCancelar.setOnClickListener {
            setResult(0, i)
            finish()
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null && it.resultCode == 1) {
                imagemId = it.data?.getIntExtra("id", 0)!!
                if (imagemId > 0) {
                    binding.imagemFoto.setImageResource(imagemId)
                }
            }
        }
    }

    private fun observe() {
        viewModel.novoContacto().observe(this, Observer {
            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
            setResult(1, i)
            finish()
        })
    }
}