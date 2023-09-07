package com.example.mteam.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.databinding.ItemsPlayersListBinding



class NoteListingAdapter(
    private var listener: ItemClickListener? = null,
    val onItemClicked: (Int, PlayersNote) -> Unit,
    val onEditClicked: (Int, PlayersNote) -> Unit,
    val onDeleteClicked: (Int, PlayersNote) -> Unit,

    val onLateClicked: (Int, PlayersNote) -> Unit


//    val listener: MyOnClickListener

) : RecyclerView.Adapter<NoteListingAdapter.MyViewHolder>() {



    private var list: MutableList<PlayersNote> = arrayListOf()

//    inner class  bottomViewHolder(val itemBudgetBinding:ItemsPlayersListBinding ): RecyclerView.ViewHolder(
//        itemBudgetBinding.root
//    ){
//        init {
//            itemBudgetBinding.lateIcon.setOnClickListener {
//                val position = bindingAdapterPosition
//                listener.OnClick(position)
//                true
//            }
//        }
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ItemsPlayersListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
        holder.itemView.setOnClickListener{
            listener?.onItemClick(list[position].username)
        }
    }
    fun updateList(list: MutableList<PlayersNote>){
        this.list = list
        notifyDataSetChanged()
    }
//
//         fun onClick(position: Int){
//        val pos = PlayersNote[position]
//
//    }

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

            binding.lateIcon.setOnClickListener { onLateClicked.invoke(bindingAdapterPosition, item) }

        }
    }

//    interface MyOnClickListener{
//        fun OnClick(position:Int)
//    }
interface ItemClickListener {
    fun onItemClick(field: String)

}


}



