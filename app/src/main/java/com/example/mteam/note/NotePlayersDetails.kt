package com.example.mteam.note

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mteam.R
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.databinding.FragmentNotePlayersDetailsBinding
import com.example.mteam.util.UiState
import com.example.mteam.util.hide
import com.example.mteam.util.show
import com.example.mteam.util.toast
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
class NotePlayersDetails : Fragment() {

    var TAG: String = "NotePlayersDetails"
    lateinit var binding : FragmentNotePlayersDetailsBinding
    val viewModel: PlayersNoteViewModel by viewModels()
    var isEdit:Boolean = false
    var objNote: PlayersNote? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotePlayersDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateUI()
        super.onViewCreated(view, savedInstanceState)
        binding.submitDialog.setOnClickListener{
            if(isEdit){
                updateNote()
            }else{
                createNote()
            }

        }

        }

    private fun createNote(){
            if(validation()){
                viewModel.addNote(
                    PlayersNote(
                        id = "",
                        username = binding.userName.text.toString(),
                        mobile = binding.userNo.text.toString(),
                        date = Date()

                    )

                )
            }

        viewModel.addNote.observe(viewLifecycleOwner){
            //This is how we got data from live data inside fragment

            when(it){

                is UiState.Loading -> {
                    binding.btnProgressAr.show()
                    //Log.e(TAG,"Loading")
                }
                is UiState.Failure -> {
                    binding.btnProgressAr.hide()
                    toast(it.error)
//                Log.e(TAG,it.error. toString())

                }
                is UiState.Success -> {
                    binding.btnProgressAr.hide()

                    toast(it.data)

                }


            }


        }


    }

    private fun updateNote(){
        if(validation()){
            viewModel.updateNote(
                PlayersNote(
                    id = objNote?.id ?: " ",
                    username = binding.userName.text.toString(),
                    mobile = binding.userNo.text.toString(),
                    date = Date()

                )

            )
        }



        viewModel.updateNote.observe(viewLifecycleOwner){
            //This is how we got data from live data inside fragment
            when(it){
                is UiState.Loading -> {
                    binding.btnProgressAr.show()
                    binding.submitDialog.text= ""
                    //Log.e(TAG,"Loading")
                }
                is UiState.Failure -> {
                    binding.btnProgressAr.hide()
                    binding.submitDialog.text= "update"
                    toast(it.error)
//                Log.e(TAG,it.error. toString())

                }
                is UiState.Success -> {
                    binding.btnProgressAr.hide()
                    binding.submitDialog.text= "update"
                    toast(it.data)

                }


            }


        }


    }

    private fun updateUI(){ val type = arguments?.getString("type", null)
            type?.let{
                when(it){
                    "view" ->{
                        isEdit = false
                        binding.userName.isEnabled= false
                        objNote = arguments?.getParcelable("note")
                        binding.userName.setText(objNote?.username)
                        binding.submitDialog.hide()


                    }
                    "creat" ->{
                        isEdit = false

                        binding.submitDialog.setText("Create")


                    }
                    "edit" ->{
                        isEdit = true
                        objNote = arguments?.getParcelable("note")
                        binding.userName.setText(objNote?.username)
                        binding.cancleDialog.hide()
                        binding.submitDialog.setText("Update")

                    }
                }
            }


    }

    private fun validation(): Boolean {
        var isValid = true

        if (binding.userName.text.toString().isNullOrEmpty()){
            isValid = false
            toast("EnterUsername")

        }
        return isValid
    }

}