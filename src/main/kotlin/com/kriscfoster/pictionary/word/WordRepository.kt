package com.kriscfoster.pictionary.word

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface WordRepository: JpaRepository<Word, Long> {
    @Query(
            value = "SELECT * FROM word ORDER BY RAND() LIMIT 1",
            nativeQuery = true
    )
    fun findRandomWord(): List<Word>

    @Query(
            value = "SELECT * FROM word ORDER BY RAND() LIMIT 5",
            nativeQuery = true
    )
    fun find5RandomWords(): List<Word>
}
