package com.example.mteam.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mteam.R
import com.example.mteam.databinding.FragmentLatePlayersBinding
import com.example.mteam.databinding.FragmentNotePlayersListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LatePlayersList : Fragment(R.layout.fragment_late_players) {

    val TAG: String = "LatePlayersList"
    lateinit var binding : FragmentLatePlayersBinding
    val viewModel: PlayersNoteViewModel by viewModels()  // instance of viewModel to get the data to the fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_late_players, container, false)
        binding = FragmentLatePlayersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val adapter by lazy {
//            LatePlayersNoteAdapter(
//                OnItemClickListener(Int,LatePlayersList -> Unit)
//            )
//        }
//        binding.recyclerView.adapter = LatePlayersNoteAdapter()
//        binding.recyclerView.itemAnimator = null
//        binding.late.setOnClickListener{
//            findNavController().navigate(R.id.action_notePlayersList_to_notePlayersDetails,Bundle().apply {
//                putString("type","create")
//            })
//
//        }


}
}