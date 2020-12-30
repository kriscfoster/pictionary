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
    fun findWord(): Word
}
