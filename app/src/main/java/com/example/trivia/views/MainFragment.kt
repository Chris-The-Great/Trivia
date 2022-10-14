package com.example.trivia.views

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.trivia.R
import com.example.trivia.api.TriviaApi
import com.example.trivia.api.UIState
import com.example.trivia.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {


    private val binding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy{
        ViewModelProvider(requireActivity())[TriviaViewModel::class.java]
    }
    private var aBtn = 0
    private var cBtn = 0
    private var dBtn = 0
    companion object{
        var qAmount : String = ""
        var qCategory : Int = 0
        var qDifficulty : String =""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var Questionsspinner: Spinner = binding.AmountItemHolder
        val Question = resources.getStringArray(R.array.amount_Array)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            Question
        )
        Questionsspinner.adapter = adapter

        Questionsspinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 > 0) {
                    qAmount = Question[p2]
                    aBtn = p2
                    binding.StartGame.isEnabled = true
                }
                else {
                    binding.AmountText.text = "Select amount of questions"
                }
            }


            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(requireContext(), "Please Select something", Toast.LENGTH_LONG)
                    .show()
            }
        }

        var Categoryspinner: Spinner = binding.CategoryItemHolder
        val Category = resources.getStringArray(R.array.category_Array)
        val catAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            Category
        )
        Categoryspinner.adapter = catAdapter

        Categoryspinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2 >0) {
                    qCategory = p2 + 7
                    cBtn = p2
                }
                else{
                    binding.CategoryText.text = "Please pick a category "
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(requireContext(), "Please Select something", Toast.LENGTH_LONG)
                    .show()
            }

        }

        var Difficultyspinner: Spinner = binding.DifficultyItemHolder
        val Difficulty = resources.getStringArray(R.array.Difficulty_Array)
        val difAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            Difficulty
        )
        Difficultyspinner.adapter = difAdapter

        Difficultyspinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if( p2 > 0){
                    qDifficulty = Difficulty[p2]
                    dBtn = p2
                }
                else {
                    binding.DifficultyText.text = "Please choice Difficulty"
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(requireContext(), "Please Select something", Toast.LENGTH_LONG)
                    .show()
            }

        }

        binding.StartGame.isEnabled = !(aBtn ==0 && cBtn == 0 && dBtn ==0)

        binding.StartGame.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment3_to_gameFragment)
        }

        viewModel.trivia.observe(viewLifecycleOwner){
            state ->
            when(state){
                is UIState.LOADING-> {
                    Toast.makeText(context, "Loading",Toast.LENGTH_LONG).show()
                }
                is UIState.SUCCESS -> {
                    Toast.makeText(context, "Yes",Toast.LENGTH_LONG).show()
                }
                is UIState.ERROR -> {
                    Toast.makeText(context, "Data Failed", Toast.LENGTH_LONG).show()
                    Log.e("Network","onFailure: ${state.error.localizedMessage}", state.error)
                }
            }

        }
        return (binding.root)
    }
}