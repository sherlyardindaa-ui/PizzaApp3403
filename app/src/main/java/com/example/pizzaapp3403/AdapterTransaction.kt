package com.example.pizzaapp3403

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterTransaction(private val listOrder: List<TransactionModel>): RecyclerView.Adapter<AdapterTransaction.ViewHolderOrder>() {
    class ViewHolderOrder(view: View): RecyclerView.ViewHolder(view) {
        val txtNama : TextView
        val txtHarga : TextView
        val txtJml : TextView
        val imgGambar : ImageView
        val context = view.context
        init {
            txtNama = view.findViewById(R.id.textNamaMenu)
            txtHarga = view.findViewById(R.id.textHargaMenu)
            txtJml = view.findViewById(R.id.textQtyMenu)
            imgGambar = view.findViewById(R.id.imageMenu)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTransaction.ViewHolderOrder {
        val li = LayoutInflater.from(parent.context)
        val cfr = li.inflate(R.layout.card_layout_menu, parent, false)
        return ViewHolderOrder(cfr)
    }

    override fun onBindViewHolder(
        holder: AdapterTransaction.ViewHolderOrder,
        position: Int
    ) {
        val modelTrx = listOrder[position]
        holder.txtNama.text = modelTrx.nama
        holder.txtHarga.text = modelTrx.harga
        holder.txtJml.text = modelTrx.jumlah
        holder.imgGambar.setImageResource(modelTrx.gambar)
    }

    override fun getItemCount(): Int {
        return listOrder.size
    }
}