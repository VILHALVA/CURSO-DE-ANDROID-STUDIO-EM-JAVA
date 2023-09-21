package com.example.listatelefonica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listatelefonica.R
import com.example.listatelefonica.adapter.listener.ContactoOnClickListener
import com.example.listatelefonica.adapter.viewholder.ContactoViewHolder
import com.example.listatelefonica.model.Contacto
class ContactoListAdapter(
    private val contactoList: List<Contacto>,
    private val contactoOnClickListener: ContactoOnClickListener
) : RecyclerView.Adapter<ContactoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        return ContactoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_contacto, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return contactoList.size
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val contacto = contactoList[position]

        holder.textNome.text = contacto.nome
        if (contacto.imagemId > 0) {
            holder.imagem.setImageResource(contacto.imagemId)
        } else {
            holder.imagem.setImageResource(R.drawable.profiledefault)
        }

        holder.itemView.setOnClickListener {
            contactoOnClickListener.clickListener(contacto)
        }
    }


}