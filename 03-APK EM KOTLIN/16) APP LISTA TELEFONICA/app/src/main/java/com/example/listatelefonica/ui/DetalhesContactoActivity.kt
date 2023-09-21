package com.example.listatelefonica.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listatelefonica.R
import com.example.listatelefonica.databinding.ActivityDetalhesContactoBinding
import com.example.listatelefonica.model.Contacto
import com.example.listatelefonica.viewmodel.DetalheContactoViewModel

class DetalhesContactoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesContactoBinding
    private lateinit var viewModel: DetalheContactoViewModel
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var i: Intent
    private var imagemId: Int = -1
    private lateinit var contacto: Contacto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesContactoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        i = intent

        val id = i.getIntExtra("id", 0)
        if (id <= 0) {
            setResult(0, i)
            finish()
        }

        viewModel = ViewModelProvider(this)[DetalheContactoViewModel::class.java]
        observe()

        viewModel.getContacto(id)

        binding.buttonCancelar.setOnClickListener {
            changeEditable(false)
            binding.layoutEditar.visibility = View.VISIBLE
            binding.layoutEditarEliminar.visibility = View.GONE
        }

        binding.buttonEditar.setOnClickListener {
            changeEditable(true)
            binding.layoutEditar.visibility = View.GONE
            binding.layoutEditarEliminar.visibility = View.VISIBLE
        }

        binding.imagemFoto.setOnClickListener {
            if (binding.editNome.isEnabled) {
                val i = Intent(applicationContext, SelecionarImagemContactoActivity::class.java)
                launcher.launch(i)
            }
        }

        binding.buttonEliminar.setOnClickListener {
            viewModel.delete(contacto)
            setResult(1, i)
            finish()
        }

        binding.buttonGravar.setOnClickListener {
            viewModel.update(
                Contacto(
                    id = contacto.id,
                    nome = binding.editNome.text.toString(),
                    endereco = binding.editEndereco.text.toString(),
                    email = binding.editEmail.text.toString(),
                    telefone = binding.editTelefone.text.toString(),
                    imagemId = imagemId
                )
            )
            setResult(1, i)
            finish()
        }

        binding.buttonVoltar.setOnClickListener { finish() }

        binding.imagemTelefone.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + contacto.telefone)
            startActivity(dialIntent)
        }
        binding.imagemEmail.setOnClickListener {
            val destinatario = contacto.email
            val assunto = "Contacto"
            val mensagem = "Enviado de ListaTelefonica APP"

            sendEmail(destinatario, assunto, mensagem)
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null && it.resultCode == 1) {
                imagemId = it.data?.getIntExtra("id", 0)!!
                if (imagemId > 0) {
                    binding.imagemFoto.setImageResource(imagemId)
                }
            }
        }
        changeEditable(false)
    }

    private fun sendEmail(destinatario: String, assunto: String, mensagem: String) {
        val i = Intent(Intent.ACTION_SEND)
        i.data = Uri.parse("mailto:")
        i.type = "text/plain"
        i.putExtra(Intent.EXTRA_EMAIL, arrayOf(destinatario))
        i.putExtra(Intent.EXTRA_SUBJECT, assunto)
        i.putExtra(Intent.EXTRA_TEXT, mensagem)

        try {
            startActivity(Intent.createChooser(i, "Escolha o cliente de email"))
        } catch (e: java.lang.Exception) {
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun changeEditable(status: Boolean) {
        binding.editNome.isEnabled = status
        binding.editEmail.isEnabled = status
        binding.editEndereco.isEnabled = status
        binding.editTelefone.isEnabled = status
    }

    private fun observe() {
        viewModel.contacto().observe(this, Observer {
            contacto = it
            populate()
        })

        viewModel.delete().observe(this, Observer {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })
        viewModel.update().observe(this, Observer {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })
    }

    private fun populate() {
        binding.editNome.setText(contacto.nome)
        binding.editEndereco.setText(contacto.endereco)
        binding.editEmail.setText(contacto.email)
        binding.editTelefone.setText(contacto.telefone)
        if (contacto.imagemId > 0) {
            imagemId = contacto.imagemId
            binding.imagemFoto.setImageResource(contacto.imagemId)
        } else {
            binding.imagemFoto.setImageResource(R.drawable.profiledefault)
        }
    }
}