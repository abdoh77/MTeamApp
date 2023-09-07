package com.example.mteam.note

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mteam.R
import com.google.android.material.internal.ContextUtils.getActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NoteListItems  : AppCompatActivity() {

    val TAG: String = "NoteListItems"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.items_players_list)


        var isSelected = true


        val lateIcon = findViewById<ImageButton>(R.id.late_icon)

        lateIcon.setOnClickListener {
            Log.e(TAG, "I'm here")
            if (isSelected) {
                lateIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.default_timer_off
                    )
                )
                isSelected = false
            } else {
                lateIcon.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.timer_off_filled
                    )
                )
                isSelected = true
            }


        }
    }

}