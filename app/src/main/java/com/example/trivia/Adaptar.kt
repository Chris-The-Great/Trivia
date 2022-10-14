package com.example.trivia

import android.graphics.Color
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trivia.databinding.QuestionItemBinding
import com.example.trivia.model.Trivia
import com.example.trivia.views.MainFragment
import com.example.trivia.views.ResultsFragment
import okhttp3.internal.notify
import kotlin.properties.Delegates

class Adaptar(
    private val triviaData : MutableList<Trivia> = mutableListOf(),
    private val questionsBooleanArray : SparseBooleanArray = SparseBooleanArray(),
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


        fun bind(triviaData : Trivia, questionsBooleanArray: SparseBooleanArray)
        {
            var qRandom : Int = (1..4).random()
            binding.Answer1Checkbox.isChecked = questionsBooleanArray.get(adapterPosition,false)
            binding.Answer2Checkbox.isChecked = questionsBooleanArray.get(adapterPosition,false)
            binding.Answer3Checkbox.isChecked = questionsBooleanArray.get(adapterPosition, false)
            binding.Answer4Checkbox.isChecked = questionsBooleanArray.get(adapterPosition, false)


            binding.Question.text = triviaData.questions
            binding.Category.text = triviaData.category
            binding.Answer1.text = triviaData.correct
            binding.Answer2.text = triviaData.answer1
            binding.Answer3.text = triviaData.answer2
            binding.Answer4.text = triviaData.answer3
            Log.d("yes", binding.Question.text.contains("&quot;").toString())
            if(binding.Question.text.contains("&quot;"))
            {
                Log.d("Change","Running")
                 binding.Question.text = (binding.Question.text as String).replace("&quot;"," ")
            }

            when(qRandom){
                1 -> {
                    binding.Answer1.text = triviaData.correct
                    binding.Answer2.text = triviaData.answer1
                    binding.Answer3.text = triviaData.answer2
                    binding.Answer4.text = triviaData.answer3
                    if(binding.Answer1.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer1.text = (binding.Answer1.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer2.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer2.text = (binding.Answer2.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer3.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer3.text = (binding.Answer3.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer4.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer4.text = (binding.Answer4.text as String).replace("&quot;"," ")
                    }

                    binding.Answer1.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer1Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.c += 1

                        }

                    }
                    binding.Answer2.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer2Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.i += 1

                        }

                    }
                    binding.Answer3.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer3Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.i += 1

                        }

                    }
                    binding.Answer4.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer4Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.i += 1

                        }
                    }
                }
                2 -> {
                    binding.Answer1.text = triviaData.answer1
                    binding.Answer2.text = triviaData.correct
                    binding.Answer3.text = triviaData.answer2
                    binding.Answer4.text = triviaData.answer3
                    if(binding.Answer1.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer1.text = (binding.Answer1.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer2.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer2.text = (binding.Answer2.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer3.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer3.text = (binding.Answer3.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer4.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer4.text = (binding.Answer4.text as String).replace("&quot;"," ")
                    }
                        binding.Answer1.setOnClickListener {
                            with(!questionsBooleanArray.get(adapterPosition, false)) {
                                binding.Answer1Checkbox.isChecked = this
                                questionsBooleanArray.put(adapterPosition, this)
                                ResultsFragment.i += 1

                            }

                        }
                        binding.Answer2.setOnClickListener {
                            with(!questionsBooleanArray.get(adapterPosition, false)) {
                                binding.Answer2Checkbox.isChecked = this
                                questionsBooleanArray.put(adapterPosition, this)
                                ResultsFragment.c += 1

                            }

                        }
                        binding.Answer3.setOnClickListener {
                            with(!questionsBooleanArray.get(adapterPosition, false)) {
                                binding.Answer3Checkbox.isChecked = this
                                questionsBooleanArray.put(adapterPosition, this)
                                ResultsFragment.i += 1

                            }

                        }
                        binding.Answer4.setOnClickListener {
                            with(!questionsBooleanArray.get(adapterPosition, false)) {
                                binding.Answer4Checkbox.isChecked = this
                                questionsBooleanArray.put(adapterPosition, this)
                                ResultsFragment.i += 1

                            }
                        }

                }
                3 ->{
                    binding.Answer1.text = triviaData.answer1
                    binding.Answer2.text = triviaData.answer2
                    binding.Answer3.text = triviaData.correct
                    binding.Answer4.text = triviaData.answer3
                    if(binding.Answer1.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer1.text = (binding.Answer1.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer2.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer2.text = (binding.Answer2.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer3.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer3.text = (binding.Answer3.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer4.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer4.text = (binding.Answer4.text as String).replace("&quot;"," ")
                    }
                    binding.Answer1.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer1Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.i += 1

                        }

                    }
                    binding.Answer2.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer2Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.i += 1

                        }

                    }
                    binding.Answer3.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer3Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.c += 1

                        }

                    }
                    binding.Answer4.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer4Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.i += 1

                        }
                    }
                }
                4 ->{
                    binding.Answer1.text = triviaData.answer1
                    binding.Answer2.text = triviaData.answer2
                    binding.Answer3.text = triviaData.answer3
                    binding.Answer4.text = triviaData.correct
                    if(binding.Answer1.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer1.text = (binding.Answer1.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer2.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer2.text = (binding.Answer2.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer3.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer3.text = (binding.Answer3.text as String).replace("&quot;"," ")
                    }
                    if(binding.Answer4.text.contains("&quot;"))
                    {
                        Log.d("Change","Running")
                        binding.Answer4.text = (binding.Answer4.text as String).replace("&quot;"," ")
                    }
                    binding.Answer1.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer1Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.i += 1

                        }

                    }
                    binding.Answer2.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer2Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.i += 1

                        }

                    }
                    binding.Answer3.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer3Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.i += 1

                        }

                    }
                    binding.Answer4.setOnClickListener {
                        with(!questionsBooleanArray.get(adapterPosition, false)) {
                            binding.Answer4Checkbox.isChecked = this
                            questionsBooleanArray.put(adapterPosition, this)
                            ResultsFragment.c += 1

                        }
                    }
                }


            }
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
        holder.bind(triviaData[position],questionsBooleanArray)

    override fun getItemCount(): Int = triviaData.size


}