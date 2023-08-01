package com.example.mteam.data.repository

import com.example.mteam.data.model.PlayersNote

interface PlayersNoteRepository {

    fun getNotes(): List<PlayersNote>



}