package com.example.praktam_2417051051.data.repository

import com.example.praktam_2417051051.data.model.Journal

object JournalRepository {

    private val journals =
        mutableListOf<Journal>()

    fun getJournals():
            List<Journal> {

        return journals
    }

    fun addJournal(
        journal: Journal
    ) {
        journals.add(journal)
    }

    fun deleteJournal(
        journal: Journal
    ) {
        journals.remove(journal)
    }

    fun updateJournal(
        journal: Journal
    ){
        val index =
            journals.indexOfFirst {
                it.id == journal.id
            }

        if(index != -1){
            journals[index] = journal
        }
    }
}