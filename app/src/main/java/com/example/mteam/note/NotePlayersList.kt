package com.example.mteam.note

import android.nfc.Tag
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mteam.R
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.databinding.FragmentNotePlayersListBinding
import com.example.mteam.util.UiState
import com.example.mteam.util.hide
import com.example.mteam.util.show
import com.example.mteam.util.toast
import com.google.android.material.tabs.TabLayout.TabGravity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotePlayersList : Fragment() {

    val TAG: String = "NotePlayersList"
    lateinit var binding : FragmentNotePlayersListBinding
    val viewModel: PlayersNoteViewModel by viewModels()  // instance of viewModel to get the data to the fragment
    var deletePosition: Int = -1
    var list: MutableList<PlayersNote> = arrayListOf()
    val adapter by lazy {
        NoteListingAdapter(
            onItemClicked = { pos, item ->
                findNavController().navigate(R.id.action_notePlayersList_to_notePlayersDetails,Bundle().apply {
                        putString("type","view")
                        putParcelable("note",item)
                    })

            },
            onEditClicked = {pos, item ->

                findNavController().navigate(R.id.action_notePlayersList_to_notePlayersDetails,Bundle().apply {
                    putString("type","edit")
                    putParcelable("note",item)
                })
            },
            onDeleteClicked = { pos, item ->
                deletePosition = pos
                viewModel.deleteNote(item)

            }
        )

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotePlayersListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = null
        binding.createButton.setOnClickListener{
            findNavController().navigate(R.id.action_notePlayersList_to_notePlayersDetails,Bundle().apply {
                putString("type","create")
            })

        }
        viewModel.getNotes() //we are calling this function from the ViewModel
        viewModel.note.observe(viewLifecycleOwner){
            //This is how we got data from live data inside fragment

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
                    list = it.data.toMutableList()
                    adapter.updateList(list)

                }


            }


            }

        viewModel.deleteNote.observe(viewLifecycleOwner){
            //This is how we got data from live data inside fragment

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
                    toast(it.data)
                    if (deletePosition != -1) {
                        list.removeAt(deletePosition)
                        adapter.updateList(list)
                    }
                }


            }


        }

        }
    }
