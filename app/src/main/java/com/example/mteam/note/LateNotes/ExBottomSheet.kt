package com.example.mteam.note.LateNotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mteam.R
import com.example.mteam.data.model.LatePlayers
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.databinding.ItemsPlayersListBinding
import com.example.mteam.databinding.LateBottomSheetBinding
import com.example.mteam.note.NotePlayersList
import com.example.mteam.note.PlayersNoteViewModel
import com.example.mteam.util.toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date


@AndroidEntryPoint
class ExBottomSheet: BottomSheetDialogFragment() {

    companion object {
        fun newInstance(field: String):
                ExBottomSheet{
            val fragment = ExBottomSheet()

            val args = Bundle().apply {
                putString("username",field)
            }
            fragment.arguments= args
            return fragment
        }
    }

    private lateinit var binding: LateBottomSheetBinding
    lateinit var ExcuseViewModel: PlayersNoteViewModel
    var objNote: PlayersNote? = null


    private lateinit var nameItem: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = arguments?.getString("username")

        nameItem = item!!
        Log.d("FieldItemdSelected", "${nameItem} ")

    }

    val viewModel: PlayersNoteViewModel by viewModels()  // instance of viewModel to get the data to the fragment

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = LateBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        ExcuseViewModel = ViewModelProvider(this).get(PlayersNoteViewModel::class.java)

//        fun bind(item: PlayersNote) {
//            viewModel.excuseNote(
//                PlayersNote(
//                    username = binding.tvBottomSheet.setText(item.username)
//                )
//            )
//
//        }






//        objNote = arguments?.getParcelable("note")
//        val nameOfuser = objNote!!.username
//        Log.e("usernameSelected","$ ")
//
//        binding.bottomSheetTitle.setText("what is  r Excuse ?")
        binding.bottomSheetTitle.setText("what is ${nameItem} Excuse?")

        binding.rbNoExcuse.setOnClickListener{

            Toast.makeText(context,"No Excuse selected",Toast.LENGTH_LONG).show()
        }

        binding.bsButtonSave.setOnClickListener{
            excuseValidation()
            this.dismiss()
            binding.inputExcuseBs.text!!.clear()
//            inputEd.setText(null)
        }

//        ExcuseViewModel.bse.observe(this){
////            binding.inputExcuseBs.text = String.format("")
//           val f = binding.inputExcuseBs.findViewById<TextInputLayout>(R.id.input_excuse_bs)
//            val notes = arrayListOf<LatePlayers>()
//            var userInput= binding.inputExcuseBs.text.toString()
//            Log.e("Ex Entered","${userInput}")
//
//        }
//        val checkedExcuseRadioButton =



    }

    private fun createExcuse(){
        var userInput= binding.inputExcuseBs.text.toString()
        Log.e("Ex Entered","${userInput}")
    }

    private fun excuseValidation(): Boolean {

        var isValid = true

        val checkForSelection = binding.excuseOptions.checkedRadioButtonId
        val currentlyChecked =  binding.excuseFrag.findViewById<RadioButton>(checkForSelection)
        val excusedButton = binding.rbExcuse.findViewById<RadioButton>(R.id.rb_Excuse)
        val noExcusedButton = binding.rbExcuse.findViewById<RadioButton>(R.id.rb_noExcuse)

        Log.e("Selected button is => ","${currentlyChecked}" )






        binding.rbNoExcuse.setOnClickListener{
//            inputEd.isEnabled = false
            toast("No Excuse button is clicked")
            binding.inputExcuseBs.isEnabled = false
            binding.inputExcuseBs.isFocusable = false

        }


        if (noExcusedButton == excusedButton){

//            inputEd.isEnabled = false
            isValid = false
            toast("Selecte Excuse button To Write Excuse")

        }else{
            createExcuse()
        }
        return isValid
    }

}

