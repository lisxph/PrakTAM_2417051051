package com.example.praktam_2417051051.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.praktam_2417051051.data.model.Quote
import com.example.praktam_2417051051.data.repository.QuoteRepository
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    private val repository =
        QuoteRepository()

    var quote by mutableStateOf("")
        private set

    var author by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(true)
        private set

    init {
        loadQuote()
    }

    private fun loadQuote() {

        viewModelScope.launch {

            try {

                isLoading = true

                val result =
                    repository.getQuote()

                if(result.isNotEmpty()) {

                    quote =
                        result[0].q

                    author =
                        result[0].a
                }

            } catch (e: Exception) {

                quote =
                    "Keep moving forward."

                author =
                    "Thryve"

            } finally {

                isLoading = false

            }
        }
    }
}