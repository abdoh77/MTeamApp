package com.example.mteam.data.model

import android.net.Uri
import android.os.Parcelable
import com.google.firebase.firestore.ServerTimestamp
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class PlayersNote (

    var id: String = "",
    val username: String ="",
    val mobile: String="",


    @ServerTimestamp
    val date: Date = Date(),


):Parcelable


