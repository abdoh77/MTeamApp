package com.example.mteam.note

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.data.repository.PlayersNoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PlayersNoteViewModel @Inject constructor(
    val repository: PlayersNoteRepository
): ViewModel() {

    //To pass data from view model to fragment or activity we use livedata
    private val _notes = MutableLiveData<List<PlayersNote>>()
    val note: LiveData<List<PlayersNote>>
        get() = _notes


    fun getNotes(){
        _notes.value = repository.getNotes() // To get Notes from repository and set for live data
    }



}
