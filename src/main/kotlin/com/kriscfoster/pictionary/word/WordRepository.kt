package com.kriscfoster.pictionary.word

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface WordRepository: JpaRepository<Word, Long> {
    @Query(
            value = "SELECT * FROM word ORDER BY RAND() LIMIT :count",
            nativeQuery = true
    )
    fun findRandomWords(@Param("count") count: Int): List<Word>
}
