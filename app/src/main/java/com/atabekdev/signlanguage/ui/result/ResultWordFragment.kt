package com.atabekdev.signlanguage.ui.result

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.databinding.FragmentResultWordBinding

class ResultWordFragment : Fragment(R.layout.fragment_result_word) {

    private lateinit var binding: FragmentResultWordBinding
    private val navArgs: ResultWordFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultWordBinding.bind(view)

        initViews()
        initListeners()


    }

    private fun initViews() {
        binding.tvResult.text = getString(R.string.text_result_word, navArgs.point)
    }

    private fun initListeners() {
        binding.btnYes.setOnClickListener {
            findNavController().navigate(
                ResultWordFragmentDirections.actionResultWordFragmentToWordFragment()
            )
        }

        binding.btnNo.setOnClickListener {
            findNavController().navigate(
                ResultWordFragmentDirections.actionResultWordFragmentToMainFragment()
            )
        }
    }
}