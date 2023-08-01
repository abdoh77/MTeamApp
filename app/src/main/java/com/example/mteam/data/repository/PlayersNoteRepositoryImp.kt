package com.example.mteam.data.repository

import com.example.mteam.data.model.PlayersNote
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Date

class PlayersNoteRepositoryImp(
    val database: FirebaseFirestore
): PlayersNoteRepository {

    //we will get data from firebase
    override fun getNotes(): List<PlayersNote> {
        return arrayListOf(
            PlayersNote(
                id = "4", username = "mohammed4", mobile = "mobile4", date = Date()
            ) ,
                    PlayersNote(
                        id = "3", username = "mohammed3", mobile = "mobile3", date = Date()
        ),
        PlayersNote(
            id = "2", username = "mohammed2", mobile = "mobily", date = Date()
        ),
                PlayersNote(
              id = "1", username = "mohammed", mobile = "okha", date = Date()
        )
        )
    }
}