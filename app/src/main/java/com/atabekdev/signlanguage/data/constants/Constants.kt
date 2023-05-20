
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
        list.add(WordData("Б"))
        list.add(WordData("В"))
        list.add(WordData("Г"))
        list.add(WordData("Д"))
        list.add(WordData("Е"))
        list.add(WordData("Ё"))
        list.add(WordData("Ж"))
        list.add(WordData("З"))
        list.add(WordData("И"))
        list.add(WordData("Й"))
        list.add(WordData("К"))
        list.add(WordData("Л"))
        list.add(WordData("М"))
        list.add(WordData("Н"))
        list.add(WordData("О"))
        list.add(WordData("П"))
        list.add(WordData("Р"))
        list.add(WordData("С"))
        list.add(WordData("Т"))
        list.add(WordData("У"))
        list.add(WordData("Ф"))
        list.add(WordData("Х"))
        list.add(WordData("Ц"))
        list.add(WordData("Ч"))
        list.add(WordData("Ш"))
        list.add(WordData("Щ"))
        list.add(WordData("Ъ"))
        list.add(WordData("Ы"))
        list.add(WordData("Ь"))
        list.add(WordData("Э"))
        list.add(WordData("Ю"))
        list.add(WordData("Я"))

        return list

    }

    fun provideImageWords(): List<Int> {
        val list = mutableListOf<Int>()
        list.add(R.drawable.a)
        list.add(R.drawable.b)
        list.add(R.drawable.v)
        list.add(R.drawable.g)
        list.add(R.drawable.d)
        list.add(R.drawable.e)
        list.add(R.drawable.ye)
        list.add(R.drawable.j)
        list.add(R.drawable.z)
        list.add(R.drawable.i)
        list.add(R.drawable.ikratkiy)
        list.add(R.drawable.k)
        list.add(R.drawable.l)
        list.add(R.drawable.m)
        list.add(R.drawable.n)
        list.add(R.drawable.o)
        list.add(R.drawable.p)
        list.add(R.drawable.r)
        list.add(R.drawable.s)
        list.add(R.drawable.t)
        list.add(R.drawable.u)
        list.add(R.drawable.f)
        list.add(R.drawable.x)
        list.add(R.drawable.ts)
        list.add(R.drawable.ch)
        list.add(R.drawable.sh)
        list.add(R.drawable.she)
        list.add(R.drawable.tv_znak)
        list.add(R.drawable.iyy)
        list.add(R.drawable.m_znak)
        list.add(R.drawable.iee)
        list.add(R.drawable.yu)
        list.add(R.drawable.ya)

        return list
    }

    fun provideQuestions(): List<QuestionData> {
        val listOfImages = provideImageWords()
        val listOfWords = provideWords()
        val list = mutableListOf<QuestionData>()

        for (i in 0..32) {
            val wordSet = mutableSetOf<String>()
            do {
                wordSet.add(listOfWords[Random.nextInt(0..32)].word)
            } while (wordSet.size == 3)

            list.add(
                QuestionData(
                    listOfImages[i],
                    listOf(
                        listOfWords[i].word,
                        listOfWords[Random.nextInt(0..32)].word,
                        listOfWords[Random.nextInt(0..32)].word,
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


        for (i in 0 .. 32) {
            val randomId = Random.nextInt(0..5)

            val listImages = mutableListOf<Int>()
            listImages.add(listOfImages[Random.nextInt(0..32)])
            listImages.add(listOfImages[Random.nextInt(0..32)])
            listImages.add(listOfImages[Random.nextInt(0..32)])
            listImages.add(listOfImages[Random.nextInt(0..32)])
            listImages.add(listOfImages[Random.nextInt(0..32)])
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


        for (i in 0 .. 32) {
            val randomId = Random.nextInt(0..5)

            val wordList = mutableListOf<String>()
            wordList.add(listOfWords[Random.nextInt(0..32)].word)
            wordList.add(listOfWords[Random.nextInt(0..32)].word)
            wordList.add(listOfWords[Random.nextInt(0..32)].word)
            wordList.add(listOfWords[Random.nextInt(0..32)].word)
            wordList.add(listOfWords[Random.nextInt(0..32)].word)
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