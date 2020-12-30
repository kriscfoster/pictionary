package com.kriscfoster.pictionary.word

import org.springframework.stereotype.Service

@Service
class WordService(val wordRepository: WordRepository) {
    fun getWord(): Word {
        return wordRepository.findWord()
    }
}
