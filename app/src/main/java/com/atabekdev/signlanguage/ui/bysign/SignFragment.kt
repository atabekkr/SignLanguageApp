package com.atabekdev.signlanguage.ui.bysign

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.data.constants.Constants
import com.atabekdev.signlanguage.databinding.FragmentBySignBinding
import com.atabekdev.signlanguage.ui.word.WordFragmentDirections
import kotlin.random.Random
import kotlin.random.nextInt

class SignFragment : Fragment(R.layout.fragment_by_sign) {

    private lateinit var binding: FragmentBySignBinding
    private var timer: CountDownTimer? = null
    private var mediaPlayer : MediaPlayer? = null
    private val listOfWordsByImage = Constants.provideSign().shuffled()
    private val listOfWords = mutableListOf<TextView>()
    private var point = 0
        set(value) {
            field = if (value < 0) {
                0
            } else {
                value
            }
        }
    private var randomId = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBySignBinding.bind(view)
        binding.tvCheck.text = getString(R.string.tv_check, "0")

//        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.click2)
        startCountDownTimer()
        initWordList()
        installWords()
        initListeners()
    }

    private fun initWordList() {
        listOfWords.clear()
        listOfWords.add(binding.ivSign1)
        listOfWords.add(binding.ivSign2)
        listOfWords.add(binding.ivSign3)
        listOfWords.add(binding.ivSign4)
        listOfWords.add(binding.ivSign5)
        listOfWords.add(binding.ivSign6)
    }

    private fun startCountDownTimer() {
        timer?.cancel()
        timer = object : CountDownTimer(46000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvCountdownTimer.text =
                    activity?.getString(
                        R.string.countdown_timer,
                        (millisUntilFinished / 1000).toString()
                    )
            }

            override fun onFinish() {
                findNavController().navigate(
                    SignFragmentDirections.actionSignFragmentToResultSignFragment(point.toString())
                )
            }

        }.start()
    }

    private fun installWords() {
        randomId = Random.nextInt(0 .. 5)
        binding.imageSign.setImageResource(listOfWordsByImage[randomId].image)
        val list = listOfWordsByImage[randomId].words
        listOfWords.forEachIndexed { index, s ->
            s.text = list[index]
        }
    }

    private fun initListeners() {
        binding.ivSign1.setOnClickListener {
//            mediaPlayer?.start()
            if (listOfWordsByImage[randomId].correctIndex == 0) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            }
        }
        binding.ivSign2.setOnClickListener {
//            mediaPlayer?.start()
            if (listOfWordsByImage[randomId].correctIndex == 1) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            }
        }
        binding.ivSign3.setOnClickListener {
//            mediaPlayer?.start()
            if (listOfWordsByImage[randomId].correctIndex == 2) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            }
        }
        binding.ivSign4.setOnClickListener {
            if (listOfWordsByImage[randomId].correctIndex == 3) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            }
        }
        binding.ivSign5.setOnClickListener {
            if (listOfWordsByImage[randomId].correctIndex == 4) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            }
        }
        binding.ivSign6.setOnClickListener {
            if (listOfWordsByImage[randomId].correctIndex == 5) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installWords()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        timer?.cancel()
    }
}