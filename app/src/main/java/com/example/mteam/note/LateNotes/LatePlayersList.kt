package com.example.mteam.note.LateNotes


import android.app.ProgressDialog.show
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mteam.R
import com.example.mteam.data.model.LatePlayers
import com.example.mteam.data.model.PlayersNote
import com.example.mteam.databinding.FragmentLatePlayersBinding
import com.example.mteam.note.NoteListingAdapter
import com.example.mteam.note.NotePlayersList
import com.example.mteam.note.PlayersNoteViewModel
import com.example.mteam.util.UiState
import com.example.mteam.util.hide
import com.example.mteam.util.show
import com.example.mteam.util.toast


import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
open class LatePlayersList : Fragment(R.layout.fragment_late_players), NoteListingAdapter.ItemClickListener {

    companion object {
        fun newInstance(item: PlayersNote): LatePlayersList {
            val fragment = LatePlayersList()
            val args = Bundle()
            args.putParcelable("selectedItem", item)
            fragment.arguments = args
            return fragment
        }
    }
    var objNote: PlayersNote? = null
    val TAG: String = "LatePlayersList"
    lateinit var binding : FragmentLatePlayersBinding
    var list: MutableList<PlayersNote> = arrayListOf()
    val viewModel: PlayersNoteViewModel by viewModels()  // instance of viewModel to get the data to the fragment

     var lateItem: PlayersNote? = null

    fun recivingLatePlayers(item: PlayersNote) {
        val bundle = arguments
        if (bundle != null) {
            var item = bundle.getParcelable<PlayersNote>("lateItem")
            // Use the item in the receiving fragment
            Log.e("LateItemClicked", "${item}")
            item = lateItem
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_late_players, container, false)
        binding = FragmentLatePlayersBinding.inflate(layoutInflater)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = LatePlayersNoteAdapter()

        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = null



        val selectedItem = arguments?.getParcelable<PlayersNote>("selectedItem")
        // Use the selectedItem to populate the second RecyclerView
        if (selectedItem != null) {
//            val itemList = listOf(selectedItem)

        }

        viewModel.getLateNotes()

        viewModel.lateList.observe(viewLifecycleOwner){
            //This is how we got data from live data inside fragment

            when(it){

                is UiState.Loading -> {
                    binding.progressBar.show()
                    //Log.e(TAG,"Loading")
                }
                is UiState.Failure -> {
                    binding.progressBar.hide()
                    toast(it.error)
//

                }
                is UiState.Success -> {
                    binding.progressBar.hide()
                    list = it.data.toMutableList()
                    adapter.updateList(list)

                }


            }


        }
//        viewModel.addSelectedItem.observe(viewLifecycleOwner){
//            //This is how we got data from live data inside fragment
//            when(it){
//                is UiState.Loading -> {
//                    binding.progressBar.show()
//
//                    //Log.e(TAG,"Loading")
//                }
//                is UiState.Failure -> {
//                    binding.progressBar.hide()
//                    toast(it.error)
////                Log.e(TAG,it.error. toString())
//
//                }
//                is UiState.Success -> {
//                    binding.progressBar.hide()
//                    objNote = arguments?.getParcelable("lateItem")
//                    recivingLatePlayers(PlayersNote(id = objNote!!.id, username = objNote!!.username.toString(), mobile = objNote!!.mobile, date = Date()))
//                    toast(it.data)
//
//                }
//
//
//            }
//
//
//        }




    }
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        val adapter = LatePlayersNoteAdapter(requireActivity())
//        // Rest of your code
////        binding.recyclerView.adapter = adapter
////        binding.recyclerView.itemAnimator = null
//
//
//    }

    override fun onItemClick(field: String) {
     //No needed here!
    }


    override fun onItemClickListener(item: PlayersNote) {
        recivingLatePlayers(item)

        Log.e("SelectedItem", "${item}")
    }

}