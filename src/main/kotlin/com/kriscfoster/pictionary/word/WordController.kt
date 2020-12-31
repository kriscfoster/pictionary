package com.kriscfoster.pictionary.word

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping
class WordController(val wordService: WordService) {

    @GetMapping
    fun getWords(
            @RequestParam(value = "count", defaultValue = "1") count: Int,
            model: Model
    ) : String {
        val words = wordService.getRandomWords(count)
        model.addAttribute("count", listOf(1, 3, 5))
        model.addAttribute("words", words)
        return "word"
    }
}
