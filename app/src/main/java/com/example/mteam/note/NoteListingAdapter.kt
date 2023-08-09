package com.example.mteam.note


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.databinding.ItemsPlayersListBinding

class NoteListingAdapter(
    val onItemClicked: (Int, PlayersNote) -> Unit,
    val onEditClicked: (Int, PlayersNote) -> Unit,
    val onDeleteClicked: (Int, PlayersNote) -> Unit
) : RecyclerView.Adapter<NoteListingAdapter.MyViewHolder>() {

    private var list: MutableList<PlayersNote> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ItemsPlayersListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun updateList(list: MutableList<PlayersNote>){
        this.list = list
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        list.removeAt(position)
        notifyItemChanged(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(val binding: ItemsPlayersListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlayersNote){
//            binding.id.setText(item.id)
            binding.mTitle.setText(item.username)
            binding.mSubTitle.setText(item.mobile)
            binding.edit.setOnClickListener { onEditClicked.invoke(bindingAdapterPosition,item) }
            binding.delete.setOnClickListener { onDeleteClicked.invoke(bindingAdapterPosition,item) }
            binding.itemLayout.setOnClickListener { onItemClicked.invoke(bindingAdapterPosition,item) }
        }
    }
}