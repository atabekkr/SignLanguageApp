package com.atabekdev.signlanguage.ui.word

import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.data.constants.Constants
import com.atabekdev.signlanguage.databinding.FragmentByWordBinding
import kotlin.random.Random
import kotlin.random.nextInt

class WordFragment : Fragment(R.layout.fragment_by_word) {

    private lateinit var binding: FragmentByWordBinding
    private var timer: CountDownTimer? = null
    private val listOfWordsByImage = Constants.provideWordsByImage().shuffled()
    private val listOfImages = mutableListOf<ImageView>()
    private var point = 0
    set(value) {
        field = if (value < 0) {
            0
        } else {
            value
        }
    }
    private var randomId = 0

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentByWordBinding.bind(view)

        binding.tvCheck.text = getString(R.string.tv_check, "0")

        initListOfImage()
        startCountDownTimer()
        installImages()
        initListeners()


    }

    private fun initListOfImage() {
        listOfImages.clear()
        listOfImages.add(binding.ivSign1)
        listOfImages.add(binding.ivSign2)
        listOfImages.add(binding.ivSign3)
        listOfImages.add(binding.ivSign4)
        listOfImages.add(binding.ivSign5)
        listOfImages.add(binding.ivSign6)
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
                    WordFragmentDirections.actionWordFragmentToResultWordFragment(point.toString())
                )
            }

        }.start()
    }

    private fun installImages() {
        randomId = Random.nextInt(0 .. 5)
        binding.imageSign.text = listOfWordsByImage[randomId].word
        val list = listOfWordsByImage[randomId].images
        listOfImages.forEachIndexed { index, imageView ->
            imageView.setImageResource(list[index])
        }
    }

    private fun initListeners() {
        binding.ivSign1.setOnClickListener {

            if (listOfWordsByImage[randomId].correctIndex == 0) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            }
        }
        binding.ivSign2.setOnClickListener {

            if (listOfWordsByImage[randomId].correctIndex == 1) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            }
        }
        binding.ivSign3.setOnClickListener {
            if (listOfWordsByImage[randomId].correctIndex == 2) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            }
        }
        binding.ivSign4.setOnClickListener {
            if (listOfWordsByImage[randomId].correctIndex == 3) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            }
        }
        binding.ivSign5.setOnClickListener {
            if (listOfWordsByImage[randomId].correctIndex == 4) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            }
        }
        binding.ivSign6.setOnClickListener {

            if (listOfWordsByImage[randomId].correctIndex == 5) {
                point += 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            } else {
                point -= 50
                binding.tvCheck.text = getString(R.string.tv_check, point.toString())
                installImages()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        timer?.cancel()
    }
}