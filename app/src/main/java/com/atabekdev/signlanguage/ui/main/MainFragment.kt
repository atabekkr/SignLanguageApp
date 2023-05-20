package com.atabekdev.signlanguage.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.cardAlphabet.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToAlphabetFragment()
            )
        }

        binding.cardQuestion.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToQuestionFragment()
            )
        }

        binding.cardByWord.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToWordFragment()
            )
        }

        binding.cardSign.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToSignFragment()
            )
        }
    }
}