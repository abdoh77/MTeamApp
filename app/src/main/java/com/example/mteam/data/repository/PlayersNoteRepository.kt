package com.example.mteam.data.repository

import com.example.mteam.data.model.LatePlayers
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.util.UiState

interface PlayersNoteRepository {

    fun getNotes(result: (UiState<List<PlayersNote>>) -> Unit)

    fun addNote(note: PlayersNote, result: (UiState<String>) -> Unit)

    fun updateNote(note: PlayersNote, result: (UiState<String>) -> Unit)

    fun deleteNote(note: PlayersNote, result: (UiState<String>) -> Unit)

//    fun addLatePlayers(lateNotes: LatePlayers, result: (UiState<String>) -> Unit)

}