package com.example.praktam_2417051051.data.repository

import com.example.praktam_2417051051.data.model.Task

object TaskRepository {

    private val tasks = mutableListOf<Task>()

    fun getTasks(): List<Task> {
        return tasks
    }

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun updateTask(task: Task) {

        val index =
            tasks.indexOfFirst {
                it.id == task.id
            }

        if(index != -1){
            tasks[index] = task
        }
    }
}