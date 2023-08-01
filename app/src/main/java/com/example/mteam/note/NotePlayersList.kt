package com.example.mteam.note

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mteam.R
import com.example.mteam.databinding.FragmentNotePlayersListBinding
import com.google.android.material.tabs.TabLayout.TabGravity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotePlayersList : Fragment() {

    val TAG: String = "NotePlayersList"
    lateinit var binding : FragmentNotePlayersListBinding
    val viewModel: PlayersNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotePlayersListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getNotes()
        viewModel.note.observe(viewLifecycleOwner){
            //This is how we got data from live data inside fragment

            it.forEach {
                Log.e(TAG,it.toString())
            }
            }

        }
    }
