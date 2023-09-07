package com.example.mteam.note.LateNotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mteam.data.model.LatePlayers
import com.example.mteam.databinding.ItemsLatePlayersBinding

class LatePlayersNoteAdapter()  : RecyclerView.Adapter<LatePlayersNoteAdapter.LateViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LateViewHolder {
        val itemView = ItemsLatePlayersBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LateViewHolder(itemView)
    }

    private var list: MutableList<LatePlayers> = arrayListOf()

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LateViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun updateLateList(list: MutableList<LatePlayers>){
        this.list = list
        notifyDataSetChanged()
    }


    inner class LateViewHolder(val binding: ItemsLatePlayersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: LatePlayers){
//            binding.id.setText(item.id)
            binding.LateTitle.setText(item.username)




        }
    }

}
