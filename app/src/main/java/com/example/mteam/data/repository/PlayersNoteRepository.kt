package com.example.mteam.data.repository

import com.example.mteam.data.model.LatePlayers
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.util.UiState

interface PlayersNoteRepository {

    fun getNotes(result: (UiState<List<PlayersNote>>) -> Unit)

    fun addNote(note: PlayersNote, result: (UiState<String>) -> Unit)

    fun updateNote(note: PlayersNote, result: (UiState<String>) -> Unit)

    fun deleteNote(note: PlayersNote, result: (UiState<String>) -> Unit)

  // fun getLatePlayers(result: (UiState<List<LatePlayers>>) -> Unit)

//   fun addLatePlayers(note: PlayersNote, result: (UiState<String>) -> Unit)

   fun excuseNote(note: PlayersNote, result: (UiState<String>) -> Unit)

//    fun addExcuse(ex: PlayersNote, result: (UiState<String>) -> Unit)
}