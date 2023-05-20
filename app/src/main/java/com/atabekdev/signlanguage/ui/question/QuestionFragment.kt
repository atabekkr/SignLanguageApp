package com.atabekdev.signlanguage.ui.question

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.data.constants.Constants
import com.atabekdev.signlanguage.databinding.FragmentQuestionBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random
import kotlin.random.nextInt

class QuestionFragment : Fragment(R.layout.fragment_question) {

    private lateinit var binding: FragmentQuestionBinding
    private val list = Constants.provideQuestions()
    var index = 0
    private var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuestionBinding.bind(view)

        installQuestions()
        initListeners()


    }

    private fun installQuestions() {
        binding.progressBar.progress = index + 1
        binding.tvTablo.text = getString(R.string.text_tablo, "${index + 1}", "${list.size}")
        binding.ivSign.setImageResource(list[index].image)
        binding.tvWord.text = list[index].answers[Random.nextInt(0..2)]
    }

    private fun initListeners() {

        binding.btnYes.setOnClickListener {
            if (index == list.size - 1) {
                findNavController().navigate(
                    QuestionFragmentDirections.actionQuestionFragmentToResultFragment(count.toString(), list.size.toString())
                )
            } else if (list[index].answers[3] == binding.tvWord.text) {
                count++
                index++
                installQuestions()
            } else {
                index++
                installQuestions()
            }
        }

        binding.btnNo.setOnClickListener {
            if (index == list.size - 1) {
                findNavController().navigate(
                    QuestionFragmentDirections.actionQuestionFragmentToResultFragment(count.toString(), list.size.toString())
                )
            } else if (list[index].answers[3] != binding.tvWord.text) {
                count++
                index++
                installQuestions()
            } else {
                index++
                installQuestions()
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onStart() {
        super.onStart()
        index = 0
        count = 0
        installQuestions()
    }
}