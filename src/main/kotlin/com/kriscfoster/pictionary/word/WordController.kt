package com.kriscfoster.pictionary.word

import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.MediaType.TEXT_HTML_VALUE
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class WordController(val wordService: WordService) {

    @GetMapping("/api/words", produces= [APPLICATION_JSON_VALUE])
    @ResponseBody
    fun getWords(
            @RequestParam(value = "count", defaultValue = "1") count: Int,
    ) : List<Word> {
        return wordService.getRandomWords(count)
    }

    @GetMapping(produces = [TEXT_HTML_VALUE])
    fun getWordsView(
            @RequestParam(value = "count", defaultValue = "1") count: Int,
            model: Model
    ) : String {
        model.addAttribute("count", listOf(1, 3, 5))
        model.addAttribute("words", getWords(count))
        return "word"
    }
}
