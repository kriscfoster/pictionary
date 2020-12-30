package com.kriscfoster.pictionary.word

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class WordController(val wordService: WordService) {

    @GetMapping
    fun getWord() : Word {
        return wordService.getWord()
    }
}
