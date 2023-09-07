package com.example.mteam.note.LateNotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mteam.R
import com.example.mteam.data.model.LatePlayers
import com.example.mteam.databinding.FragmentLatePlayersBinding
import com.example.mteam.note.PlayersNoteViewModel
import com.example.mteam.util.UiState
import com.example.mteam.util.hide
import com.example.mteam.util.show
import com.example.mteam.util.toast

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LatePlayersList : Fragment(R.layout.fragment_late_players) {

    val TAG: String = "LatePlayersList"
    lateinit var binding : FragmentLatePlayersBinding
    var list: MutableList<LatePlayers> = arrayListOf()
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

        val adapter = LatePlayersNoteAdapter()

        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = null

//        viewModel.getLatePlayers()

//      viewModel.addLatePlayers(LatePlayers(
//          "","","","",""
//      ))

        viewModel.lateNote.observe(viewLifecycleOwner){
            when(it){

                is UiState.Loading -> {
                    binding.progressBar.show()
                    //Log.e(TAG,"Loading")
                }
                is UiState.Failure -> {
                    binding.progressBar.hide()
                    toast(it.error)
//                Log.e(TAG,it.error. toString())

                }
                is UiState.Success -> {
                    binding.progressBar.hide()



                }


            }
        }


    }
}