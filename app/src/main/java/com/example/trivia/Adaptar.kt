package com.example.trivia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trivia.databinding.QuestionItemBinding
import com.example.trivia.model.Trivia

class Adaptar(
    private val triviaData : MutableList<Trivia> = mutableListOf(),
    //private val
):RecyclerView.Adapter<Adaptar.TriviaHolder>() {


    fun StartGame(game : List<Trivia>){
        triviaData.clear()
        game.forEach{
            triviaData.add(it)
        }
        notifyDataSetChanged()
    }


    class TriviaHolder(private val binding: QuestionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(triviaData : Trivia)
        {
            binding.Question.text = triviaData.questions
            binding.Category.text = triviaData.category
            binding.Answer1.text = triviaData.answer1
            binding.Answer2.text = triviaData.answer2
            binding.Answer3.text = triviaData.answer3
            binding.Answer4.text = triviaData.correct
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TriviaHolder =
        TriviaHolder(
            QuestionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: TriviaHolder, position: Int) =
        holder.bind(triviaData[position])

    override fun getItemCount(): Int = triviaData.size


}