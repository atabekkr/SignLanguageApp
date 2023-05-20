package com.atabekdev.signlanguage.ui.result

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.databinding.FragmentResultSignBinding

class ResultSignFragment : Fragment(R.layout.fragment_result_sign) {

    private lateinit var binding: FragmentResultSignBinding
    private val navArgs: ResultSignFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultSignBinding.bind(view)

        initViews()
        initListners()
    }

    private fun initViews() {
        binding.tvResult.text = getString(R.string.text_result_word, navArgs.point)
    }

    private fun initListners() {
        binding.btnYes.setOnClickListener {
            findNavController().navigate(
                ResultSignFragmentDirections.actionResultSignFragmentToSignFragment()
            )
        }

        binding.btnNo.setOnClickListener {
            findNavController().navigate(
                ResultSignFragmentDirections.actionResultSignFragmentToMainFragment()
            )
        }
    }
}