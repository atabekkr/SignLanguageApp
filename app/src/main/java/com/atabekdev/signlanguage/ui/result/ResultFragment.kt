package com.atabekdev.signlanguage.ui.result

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.databinding.FragmentResultBinding
import com.google.android.material.snackbar.Snackbar

class ResultFragment : Fragment(R.layout.fragment_result) {

    private lateinit var binding: FragmentResultBinding
    private val navArgs: ResultFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultBinding.bind(view)

        initViews()
        initListeners()
    }

    private fun initViews() {
        binding.tvResult.text = getString(R.string.text_result, navArgs.all, navArgs.count)
    }

    private fun initListeners() {
        binding.btnYes.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnNo.setOnClickListener {
            findNavController().navigate(
                ResultFragmentDirections.actionResultFragmentToMainFragment()
            )
        }
    }
}