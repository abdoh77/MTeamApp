package com.example.mteam.note


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.data.repository.PlayersNoteRepository
import com.example.mteam.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PlayersNoteViewModel @Inject constructor(
    val repository: PlayersNoteRepository //Dependency of Repository
): ViewModel() {

    //To pass data from view model to fragment or activity we use livedata
    private val _notes = MutableLiveData<UiState<List<PlayersNote>>>()
    val note: LiveData<UiState<List<PlayersNote>>>
        get() = _notes

    // to add note
    private val _addNote = MutableLiveData< UiState<String>>()
    val addNote: LiveData<UiState<String>> //we used String because we are going to pass doucments ID
        get() = _addNote

    // to update note
    private val _updateNote = MutableLiveData< UiState<String>>()
    val updateNote: LiveData<UiState<String>> //we used String because we are going to pass doucments ID
        get() = _updateNote

    // to delete note
    private val _deleteNote = MutableLiveData< UiState<String>>()
    val deleteNote: LiveData<UiState<String>> //we used String because we are going to pass doucments ID
        get() = _deleteNote

    fun getNotes() {
        _notes.value = UiState.Loading
        repository.getNotes {
            _notes.value = it
        }
    }

    fun addNote(note: PlayersNote){ //will pass the note object
        _addNote.value =UiState.Loading // to trger the loading state
        repository.addNote(note){ //getting the note from repository
            _addNote.value = it
        }

    }

    fun updateNote(note: PlayersNote){ //will pass the note object
        _updateNote.value =UiState.Loading // to trger the loading state
        repository.updateNote(note){ //getting the note from repository
            _updateNote.value = it
        }

    }

    fun deleteNote(note: PlayersNote) {
        _deleteNote.value =UiState.Loading // to trger the loading state
        repository.deleteNote(note){ //getting the note from repository
            _deleteNote.value = it
        }
    }


}
