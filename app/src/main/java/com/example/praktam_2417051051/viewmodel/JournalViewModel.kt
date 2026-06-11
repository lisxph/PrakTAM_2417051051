package com.example.praktam_2417051051.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.praktam_2417051051.data.model.Journal
import com.example.praktam_2417051051.data.repository.JournalRepository

class JournalViewModel : ViewModel() {

    private val repository =
        JournalRepository

    val journalList =
        mutableStateListOf<Journal>()

    init {

        journalList.addAll(
            repository.getJournals()
        )

    }

    fun addJournal(
        title: String,
        content: String,
        mood: String,
        date: String
    ) {

        val journal = Journal(
            id = journalList.size + 1,
            title = title,
            content = content,
            mood = mood,
            date = date
        )

        repository.addJournal(
            journal
        )

        journalList.add(
            journal
        )
    }

    fun deleteJournal(
        journal: Journal
    ) {

        repository.deleteJournal(
            journal
        )

        journalList.remove(
            journal
        )
    }

    fun totalJournal(): Int {

        return journalList.size

    }

    fun toggleFavorite(
        journal: Journal
    ){

        val updatedJournal =
            journal.copy(
                isFavorite =
                    !journal.isFavorite
            )

        repository.updateJournal(
            updatedJournal
        )

        val index =
            journalList.indexOf(journal)

        if(index != -1){

            journalList[index] =
                updatedJournal
        }
    }

    fun getJournalById(id: Int): Journal? {
        return journalList.find { it.id == id }
    }

    fun updateJournal(id: Int, title: String, content: String, mood: String) {
        val journal = getJournalById(id) ?: return
        val updatedJournal = journal.copy(title = title, content = content, mood = mood)
        repository.updateJournal(updatedJournal)

        val index = journalList.indexOf(journal)
        if (index != -1) {
            journalList[index] = updatedJournal
        }
    }
}