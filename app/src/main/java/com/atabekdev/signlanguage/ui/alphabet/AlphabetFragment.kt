package com.atabekdev.signlanguage.ui.alphabet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.data.constants.Constants
import com.atabekdev.signlanguage.databinding.FragmentAlphabetBinding
import com.atabekdev.signlanguage.ui.adapters.AlphabetAdapter

class AlphabetFragment : Fragment(R.layout.fragment_alphabet) {

    private lateinit var binding: FragmentAlphabetBinding
    private var currentIdOfWord = 0
    private var currentIdOfImage = 0
    private val listOfWords = Constants.provideWords()
    private val listOfImages = Constants.provideImageWords()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlphabetBinding.bind(view)


        initListeners()


    }

    private fun initListeners() {
        binding.tvNext.setOnClickListener {
            binding.tvPrev.visibility = View.VISIBLE
            val id = currentIdOfWord + 1
            val imageId = currentIdOfImage + 1
            if (id == listOfWords.size - 1) binding.tvNext.visibility = View.GONE
            if (id == listOfWords.size) return@setOnClickListener

            currentIdOfWord++
            currentIdOfImage++
            binding.tvWord.text = listOfWords[id].word
            binding.ivSign.setImageResource(listOfImages[imageId])
        }

        binding.tvPrev.setOnClickListener {
            binding.tvNext.visibility = View.VISIBLE
            val id = currentIdOfWord - 1
            val imageId = currentIdOfImage - 1
            if (id == 0) binding.tvPrev.visibility = View.GONE
            if (id < 0) {
                return@setOnClickListener
            }
            currentIdOfWord--
            currentIdOfImage--
            binding.tvWord.text = listOfWords[id].word
            binding.ivSign.setImageResource(listOfImages[imageId])
        }
    }
}