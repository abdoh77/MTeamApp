package com.example.mteam.note.LateNotes


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mteam.data.model.LatePlayers
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.databinding.ItemsLatePlayersBinding
import com.example.mteam.note.NotePlayersList
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

class LatePlayersNoteAdapter(
//    private val activity: FragmentActivity
)  : RecyclerView.Adapter<LatePlayersNoteAdapter.LateViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LateViewHolder {
        val itemView = ItemsLatePlayersBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LateViewHolder(itemView)
    }

    private var list: MutableList<PlayersNote> = arrayListOf()
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

//    val sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
//    val sdate = LocalDate.parse("2019-08-07 09:00:00" , sdf)

//    Log.d("parseTesting", date.dayOfWeek.toString()) // prints Wednesday
//    Log.d("parseTesting", date.month.toString()) // prints August


    fun addItem(item: PlayersNote) {
        list.add(item)
        notifyDataSetChanged()
    }

    fun updateList(list: MutableList<PlayersNote>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LateViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun updateLateList(list: MutableList<PlayersNote>){
        this.list = list
        notifyDataSetChanged()
    }


    inner class LateViewHolder(val binding: ItemsLatePlayersBinding) : RecyclerView.ViewHolder(binding.root) {
//        init {
//            itemView.setOnClickListener {
//                val item = list[bindingAdapterPosition]
//                (activity as NotePlayersList).sendItemToLateFragment(item)
//            }
//
//        }

        fun bind(item: PlayersNote){
//            binding.id.setText(item.id)
            binding.LateTitle.setText(item.username)
            binding.date.setText(sdf.format(item.date))
        }
    }

}
