package com.tdm.tp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



/* ------------------------- Dev : AIT SAID HICHAM  ----------------------- */

class detailsAdapter(private val list: List<detailsItem>, private val listener: OnItemClickListener) : RecyclerView.Adapter<detailsAdapter.Viewholder>() {


    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val nom_produit : TextView = itemView.findViewById(R.id.nom_produit)
        val prix_unitaire : TextView = itemView.findViewById(R.id.prix_unitaire)
        /*val abs : TextView = itemView.findViewById(R.id.nbr_abs)
        val jst : TextView = itemView.findViewById(R.id.abs_jst)*/
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.details_item,
            parent,false)
        return Viewholder(itemView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val currentItem = list[position]
        holder.nom_produit.setText(currentItem.nomProduit)
        holder.prix_unitaire.setText(currentItem.prixUnitaire)
        /*holder.abs.setText(currentItem.abs)
        holder.jst.setText(currentItem.jst)*/
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}

