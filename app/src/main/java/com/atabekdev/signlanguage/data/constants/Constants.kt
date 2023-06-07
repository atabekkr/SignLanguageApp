
package com.atabekdev.signlanguage.data.constants

import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.data.question.QuestionData
import com.atabekdev.signlanguage.data.sign.SignData
import com.atabekdev.signlanguage.data.word.WordData
import com.atabekdev.signlanguage.data.wordsbyimage.WordsByImageData
import kotlin.random.Random
import kotlin.random.nextInt

object Constants {

    fun provideWords(): List<WordData> {

        val list = mutableListOf<WordData>()
        list.add(WordData("А"))
        list.add(WordData("Á"))
        list.add(WordData("B"))
        list.add(WordData("C"))
        list.add(WordData("CH"))
        list.add(WordData("D"))
        list.add(WordData("E"))
        list.add(WordData("F"))
        list.add(WordData("G"))
        list.add(WordData("Ǵ"))
        list.add(WordData("H"))
        list.add(WordData("X"))
        list.add(WordData("I"))
        list.add(WordData("Í"))
        list.add(WordData("J"))
        list.add(WordData("K"))
        list.add(WordData("Q"))
        list.add(WordData("L"))
        list.add(WordData("M"))
        list.add(WordData("N"))
        list.add(WordData("Ń"))
        list.add(WordData("O"))
        list.add(WordData("Ó"))
        list.add(WordData("P"))
        list.add(WordData("R"))
        list.add(WordData("S"))
        list.add(WordData("SH"))
        list.add(WordData("T"))
        list.add(WordData("U"))
        list.add(WordData("Ú"))
        list.add(WordData("V"))
        list.add(WordData("W"))
        list.add(WordData("Y"))
        list.add(WordData("Z"))

        return list

    }

    fun provideImageWords(): List<Int> {
        val list = mutableListOf<Int>()
        list.add(R.drawable.a)
        list.add(R.drawable.a2)
        list.add(R.drawable.b)
        list.add(R.drawable.c)
        list.add(R.drawable.ch)
        list.add(R.drawable.d)
        list.add(R.drawable.e)
        list.add(R.drawable.f)
        list.add(R.drawable.g)
        list.add(R.drawable.g2)
        list.add(R.drawable.h)
        list.add(R.drawable.x)
        list.add(R.drawable.i2)
        list.add(R.drawable.i)
        list.add(R.drawable.j)
        list.add(R.drawable.k)
        list.add(R.drawable.q)
        list.add(R.drawable.l)
        list.add(R.drawable.m)
        list.add(R.drawable.n)
        list.add(R.drawable.n2)
        list.add(R.drawable.o)
        list.add(R.drawable.o2)
        list.add(R.drawable.p)
        list.add(R.drawable.r)
        list.add(R.drawable.s)
        list.add(R.drawable.sh)
        list.add(R.drawable.t)
        list.add(R.drawable.u)
        list.add(R.drawable.u2)
        list.add(R.drawable.v)
        list.add(R.drawable.w)
        list.add(R.drawable.y)
        list.add(R.drawable.z)

        return list
    }

    fun provideQuestions(): List<QuestionData> {
        val listOfImages = provideImageWords()
        val listOfWords = provideWords()
        val list = mutableListOf<QuestionData>()

        for (i in 0..listOfWords.size - 1) {
            val wordSet = mutableSetOf<String>()
            do {
                wordSet.add(listOfWords[Random.nextInt(0..listOfWords.size - 1)].word)
            } while (wordSet.size == 3)

            list.add(
                QuestionData(
                    listOfImages[i],
                    listOf(
                        listOfWords[i].word,
                        listOfWords[Random.nextInt(0..listOfWords.size - 1)].word,
                        listOfWords[Random.nextInt(0..listOfWords.size - 1)].word,
                        listOfWords[i].word
                    )
                )
            )
        }

        return list
    }

    fun provideWordsByImage(): List<WordsByImageData> {
        val list = mutableListOf<WordsByImageData>()
        val listOfWords = provideWords()
        val listOfImages = provideImageWords()


        for (i in 0 .. listOfWords.size - 1) {
            val randomId = Random.nextInt(0..5)

            val listImages = mutableListOf<Int>()
            listImages.add(listOfImages[Random.nextInt(0..listOfWords.size - 1)])
            listImages.add(listOfImages[Random.nextInt(0..listOfWords.size - 1)])
            listImages.add(listOfImages[Random.nextInt(0..listOfWords.size - 1)])
            listImages.add(listOfImages[Random.nextInt(0..listOfWords.size - 1)])
            listImages.add(listOfImages[Random.nextInt(0..listOfWords.size - 1)])
            listImages.add(randomId, listOfImages[i])

            list.add(
                WordsByImageData(
                    listOfWords[i].word,
                    listImages,
                    correctIndex = randomId
                )
            )
        }

        return list
    }

    fun provideSign(): List<SignData> {
        val list = mutableListOf<SignData>()
        val listOfImages = provideImageWords()
        val listOfWords = provideWords()


        for (i in 0 .. 33) {
            val randomId = Random.nextInt(0..5)

            val wordList = mutableListOf<String>()
            wordList.add(listOfWords[Random.nextInt(0..listOfWords.size - 1)].word)
            wordList.add(listOfWords[Random.nextInt(0..listOfWords.size - 1)].word)
            wordList.add(listOfWords[Random.nextInt(0..listOfWords.size - 1)].word)
            wordList.add(listOfWords[Random.nextInt(0..listOfWords.size - 1)].word)
            wordList.add(listOfWords[Random.nextInt(0..listOfWords.size - 1)].word)
            wordList.add(randomId, listOfWords[i].word)

            list.add(
                SignData(
                    listOfImages[i],
                    wordList,
                    randomId
                )
            )
        }

        return list

    }

}