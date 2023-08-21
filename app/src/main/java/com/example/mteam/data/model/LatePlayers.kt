package com.example.mteam.data.model

import android.os.Parcelable
import com.google.firebase.firestore.ServerTimestamp
import kotlinx.parcelize.Parcelize
import java.util.Date


@Parcelize
data class LatePlayers(
    var late: String = "",
    var excuse: String= "",
    var noExcuse: String= " ",

    var id: String = "",
    val username: String ="",

    @ServerTimestamp
    val date: Date = Date(),
) : Parcelable