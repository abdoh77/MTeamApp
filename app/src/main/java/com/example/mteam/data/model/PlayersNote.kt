package com.example.mteam.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class PlayersNote (
    val id: String = "",
    val username: String ="",
    val mobile: String="",

    @ServerTimestamp
    val date: Date,


    )