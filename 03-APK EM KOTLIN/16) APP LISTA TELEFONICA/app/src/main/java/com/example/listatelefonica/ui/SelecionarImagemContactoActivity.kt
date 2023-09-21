package com.example.listatelefonica.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listatelefonica.R
import com.example.listatelefonica.databinding.ActivitySelecionarImagemContactoBinding

class SelecionarImagemContactoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelecionarImagemContactoBinding
    private lateinit var i: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelecionarImagemContactoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        i = intent

        binding.imagemProfile1.setOnClickListener { sendID(R.drawable.profile1) }
        binding.imagemProfile2.setOnClickListener { sendID(R.drawable.profile2) }
        binding.imagemProfile3.setOnClickListener { sendID(R.drawable.profile3) }
        binding.imagemProfile4.setOnClickListener { sendID(R.drawable.profile4) }
        binding.imagemProfile5.setOnClickListener { sendID(R.drawable.profile5) }
        binding.imagemProfile6.setOnClickListener { sendID(R.drawable.profile6) }
        binding.buttonRemoverImagem.setOnClickListener { sendID(R.drawable.profiledefault) }
    }

    private fun sendID(imagemId: Int) {
        i.putExtra("id", imagemId)
        setResult(1, i)
        finish()
    }
}