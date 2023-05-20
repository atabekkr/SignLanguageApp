package com.atabekdev.signlanguage.data.sign

data class SignData(
    val image: Int,
    val words: List<String>,
    val correctIndex: Int
)
