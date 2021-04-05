package com.tdm.tp.listeCommandes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tdm.tp.R


/* ------------------------- Dev : AIT SAID HICHAM  ----------------------- */

class commandesAdapter(private val list: List<commandeItem>, private val listener: OnItemClickListener) : RecyclerView.Adapter<commandesAdapter.Viewholder>() {


    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{
        val num_commande : TextView = itemView.findViewById(R.id.num_commande)

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
            R.layout.item_commande,
            parent,false)
        return Viewholder(itemView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val currentItem = list[position]

        holder.num_commande.setText(currentItem.num_commande)
        /*holder.abs.setText(currentItem.abs)
        holder.jst.setText(currentItem.jst)*/
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}

