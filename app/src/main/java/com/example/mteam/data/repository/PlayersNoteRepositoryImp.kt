package com.example.mteam.data.repository

import com.example.mteam.data.model.LatePlayers
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.note.LatePlayersList
import com.example.mteam.util.FireStoreTables
import com.example.mteam.util.UiState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PlayersNoteRepositoryImp(
    val database: FirebaseFirestore ,  //Repository depending on Firebase to get the data.

): PlayersNoteRepository {

    //we will get data from firebase collection
    override fun getNotes(result: (UiState<List<PlayersNote>>) -> Unit) {
        database.collection(FireStoreTables.NOTE)
            .get()
            .addOnSuccessListener {
                val notes = arrayListOf<PlayersNote>()
                for (document in it) {  //convert the document into model class
                    val note =
                        document.toObject(PlayersNote::class.java) // convert the document to this model class
                    notes.add(note) // add model class into the playersNote list
                }
                result.invoke(
                    UiState.Success(notes)
                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Failure(
                        it.localizedMessage
                    )
                )
            }
    }

    override fun addNote(note: PlayersNote, result: (UiState<String>) -> Unit) {
        val document = database.collection(FireStoreTables.NOTE).document()
        note.id = document.id

        document
            .set(note)
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success("Created successfully")

                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Failure(
                        it.localizedMessage
                    )
                )

            }
    }


    override fun updateNote(note: PlayersNote, result: (UiState<String>) -> Unit) {
        val document = database.collection(FireStoreTables.NOTE).document(note.id)
        document
            .set(note)
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success("Note updated successfully")

                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Failure(
                        it.localizedMessage
                    )
                )

            }
    }

    override fun deleteNote(note: PlayersNote, result: (UiState<String>) -> Unit) {
        val document = database.collection(FireStoreTables.NOTE).document(note.id)
        document
            .delete()
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success("Note Deleted successfully")

                )
            }
            .addOnFailureListener {
                result.invoke(
                    UiState.Failure(
                        it.localizedMessage
                    )
                )

            }
    }
}

//    override fun addLatePlayers(lateNotes: LatePlayers, result: (UiState<String>) -> Unit){
//       val late = database.collection("note").document(auth.uid!!).collection("lateList")
//           .whereEqualTo("username", lateNotes.username ).get()
//           .addOnSuccessListener{
//                it.documents.let{
//                    if (it.isEmpty()){
//
//                    }else{
//                        val name = it.first().toObject(LatePlayersList::class.java)
//                    }
//                }
//           }.addOnFailureListener{
//
//           }
//    }
//}