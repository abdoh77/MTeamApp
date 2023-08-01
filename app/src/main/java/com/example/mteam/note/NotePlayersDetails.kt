package com.example.mteam.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mteam.R
import com.example.mteam.databinding.FragmentNotePlayersDetailsBinding
import com.example.mteam.databinding.FragmentNotePlayersListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotePlayersDetails : Fragment() {

    var TAG: String = "NotePlayersDetails"
    lateinit var binding : FragmentNotePlayersDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotePlayersDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}