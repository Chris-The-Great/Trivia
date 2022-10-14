package com.example.trivia.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trivia.Adaptar
import com.example.trivia.R
import com.example.trivia.api.UIState
import com.example.trivia.databinding.FragmentGameBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameFragment : Fragment() {

    private val binding by lazy{
        FragmentGameBinding.inflate(layoutInflater)
    }

    private val gAdaptar by lazy{
        Adaptar()
    }

    private val viewModel by lazy{
        ViewModelProvider(requireActivity())[TriviaViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.REGame.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
            adapter = gAdaptar
        }

        viewModel.getTrivia()

        viewModel.trivia.observe(viewLifecycleOwner){
                state ->
            when(state){
                is UIState.LOADING-> {
                    Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                }
                is UIState.SUCCESS -> {
                    Toast.makeText(context, "Yes", Toast.LENGTH_LONG).show()
                    gAdaptar.StartGame(state.trivia)
                    Log.d("Data", gAdaptar.itemCount.toString())
                    if(gAdaptar.itemCount < MainFragment.qAmount.toInt()){
                        Toast.makeText(context, "Not enough questions. Loaded what questions were available",Toast.LENGTH_LONG).show()
                    }
                }
                is UIState.ERROR -> {
                    Toast.makeText(context, "Data Failed", Toast.LENGTH_LONG).show()
                    Log.e("Network","onFailure: ${state.error.localizedMessage}", state.error)
                }
            }

        }

        binding.Submit.setOnClickListener {
            findNavController().navigate(R.id.action_gameFragment_to_resultsFragment)
        }


        // Inflate the layout for this fragment
        return binding.root
    }
    fun onSupportNavigateUp() : Boolean{
        return findNavController().navigateUp()
    }

}