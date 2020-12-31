package com.kriscfoster.pictionary.word

import org.springframework.stereotype.Service

@Service
class WordService(val wordRepository: WordRepository) {
    fun getRandomWords(count: Int): List<Word> {
        return when (count) {
            3 -> wordRepository.findRandomWords(3)
            5 -> wordRepository.findRandomWords(5)
            else -> wordRepository.findRandomWords(1)
        }
    }
}
