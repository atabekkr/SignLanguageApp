package com.atabekdev.signlanguage.data.wordsbyimage

import android.media.Image

data class WordsByImageData(
    val word: String,
    val images: List<Int>,
    val correctIndex: Int

)
