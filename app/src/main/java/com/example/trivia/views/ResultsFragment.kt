package com.example.trivia.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.trivia.R
import com.example.trivia.databinding.FragmentResultsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.system.exitProcess

@AndroidEntryPoint
class ResultsFragment : Fragment() {

    private val binding by lazy{
        FragmentResultsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    companion object {
        var c : Int = 0
        var i : Int = 0
        lateinit var cAnswer : String
        lateinit var iAnswer : String
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        cAnswer = "Correct Answers : " + c + "/" + MainFragment.qAmount
        iAnswer = "Incorrect Answers : " + i + "/" + MainFragment.qAmount

        if(c > i){

        }
        else{

        }
         binding.cAnswers.text = cAnswer
         binding.iAnswers.text = iAnswer

        binding.playAgain.setOnClickListener {
            findNavController().navigate(R.id.action_resultsFragment_to_mainFragment3)
        }
        binding.quit.setOnClickListener {
            exitProcess(0)
        }

        return binding.root
    }


}