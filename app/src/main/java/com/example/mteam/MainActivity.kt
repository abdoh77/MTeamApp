package com.example.mteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mteam.note.LatePlayersList
import com.example.mteam.note.NotePlayersDetails
import com.example.mteam.note.NotePlayersList
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.players_nav_list_to_details) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)

        }
    }
//        val playersListFrag = NotePlayersList()
//        val latePlayerFrag = LatePlayersList()
//        val playersDetFrag = NotePlayersDetails()
//
//        setCurrentFragment(playersListFrag)
//
//        bottomNavigationView.setOnItemSelectedListener {
//
//            when (it.itemId) {
//
//                R.id.main_layout -> setCurrentFragment(playersListFrag)
//
//                R.id.late_fragment -> setCurrentFragment(latePlayerFrag)
//
//
//            }
//            true
//
//
//        }
//
//
//
//    }
//
//    fun setCurrentFragment(fragment: Fragment) =
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.players_nav_list_to_details, fragment)
//            commit()
//        }

//}