package com.atabekdev.signlanguage.ui.alphabet

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.data.constants.Constants
import com.atabekdev.signlanguage.data.slider.SliderItemData
import com.atabekdev.signlanguage.data.slider.adapter.SliderAdapter
import com.atabekdev.signlanguage.databinding.FragmentAlphabetBinding
import com.atabekdev.signlanguage.ui.adapters.AlphabetAdapter
import kotlin.math.abs

class AlphabetFragment : Fragment(R.layout.fragment_alphabet) {

    private lateinit var binding: FragmentAlphabetBinding
    private val listOfWords = Constants.provideWords()
    private val listOfImages = Constants.provideImageWords()

    private lateinit var sliderItemList: ArrayList<SliderItemData>
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var sliderHandler: Handler
    private lateinit var sliderRun: Runnable

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlphabetBinding.bind(view)

        sliderItems()
        itemSliderView()

    }

    private fun sliderItems() {
        sliderItemList = ArrayList()
        sliderAdapter = SliderAdapter(binding.viewPagerImageSlider, sliderItemList)
        binding.viewPagerImageSlider.adapter = sliderAdapter
        binding.viewPagerImageSlider.clipToPadding = false
        binding.viewPagerImageSlider.clipChildren = false
        binding.viewPagerImageSlider.offscreenPageLimit = 3
        binding.viewPagerImageSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val comPPT = CompositePageTransformer()
        comPPT.addTransformer(MarginPageTransformer(40))
        comPPT.addTransformer { page, position ->
            val r : Float = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        binding.viewPagerImageSlider.setPageTransformer(comPPT)
        sliderHandler = Handler()
        sliderRun = Runnable {
            binding.viewPagerImageSlider.currentItem = binding.viewPagerImageSlider.currentItem + 1
        }
        binding.viewPagerImageSlider.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    sliderHandler.removeCallbacks(sliderRun)
                    sliderHandler.postDelayed(sliderRun, 2000)
                }
            }
        )
    }

    private fun itemSliderView() {
        listOfImages.forEachIndexed { index, i ->
            sliderItemList.add(SliderItemData(i, listOfWords[index].word))
        }
    }

//    private fun initListeners() {
//        binding.tvNext.setOnClickListener {
//            binding.tvPrev.visibility = View.VISIBLE
//            val id = currentIdOfWord + 1
//            val imageId = currentIdOfImage + 1
//            if (id == listOfWords.size - 1) binding.tvNext.visibility = View.GONE
//            if (id == listOfWords.size) return@setOnClickListener
//
//            currentIdOfWord++
//            currentIdOfImage++
//            binding.tvWord.text = listOfWords[id].word
//            binding.ivSign.setImageResource(listOfImages[imageId])
//        }
//
//        binding.tvPrev.setOnClickListener {
//            binding.tvNext.visibility = View.VISIBLE
//            val id = currentIdOfWord - 1
//            val imageId = currentIdOfImage - 1
//            if (id == 0) binding.tvPrev.visibility = View.GONE
//            if (id < 0) {
//                return@setOnClickListener
//            }
//            currentIdOfWord--
//            currentIdOfImage--
//            binding.tvWord.text = listOfWords[id].word
//            binding.ivSign.setImageResource(listOfImages[imageId])
//        }
//    }
}