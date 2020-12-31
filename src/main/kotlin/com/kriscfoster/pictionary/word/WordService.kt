package com.kriscfoster.pictionary.word

import org.springframework.stereotype.Service

@Service
class WordService(val wordRepository: WordRepository) {
    fun getRandomWords(count: Int): List<Word> {
        return when (count) {
            5 -> wordRepository.find5RandomWords()
            else -> wordRepository.findRandomWord()
        }
    }
}
