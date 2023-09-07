package com.example.mteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mteam.note.LateNotes.LatePlayersList
import com.example.mteam.note.NotePlayersList
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavController : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.late_bottom_sheet)

        val playersListFrag = NotePlayersList()
        val latePlayerFrag = LatePlayersList()

        setCurrentFragment(playersListFrag)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.notePlayersList-> setCurrentFragment(playersListFrag)
                R.id.late_fragment->setCurrentFragment(latePlayerFrag)

            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
         //   replace(R.id.main_fragment , fragment)
            commit()
        }
}