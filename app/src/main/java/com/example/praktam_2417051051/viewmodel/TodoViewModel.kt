package com.example.praktam_2417051051.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.praktam_2417051051.data.model.Task
import com.example.praktam_2417051051.data.repository.TaskRepository

class TodoViewModel : ViewModel() {

    private val repository =
        TaskRepository

    val taskList = mutableStateListOf<Task>()

    init {

        taskList.addAll(
            repository.getTasks()
        )

    }

    fun addTask(
        title: String,
        category: String
    ) {

        val task = Task(
            id = taskList.size + 1,
            title = title,
            category = category
        )

        repository.addTask(task)

        taskList.clear()
        taskList.addAll(
            repository.getTasks()
        )
    }

    fun toggleTask(task: Task){

        val updatedTask =
            task.copy(
                completed =
                    !task.completed
            )

        repository.updateTask(
            updatedTask
        )

        val index =
            taskList.indexOf(task)

        if(index != -1){

            taskList[index] =
                updatedTask
        }
    }

    fun completedTaskCount(): Int {

        return taskList.count {
            it.completed
        }
    }

    fun getTaskById(id: Int): Task? {
        return taskList.find { it.id == id }
    }

    fun updateTask(id: Int, title: String, category: String) {
        val task = getTaskById(id) ?: return
        val updatedTask = task.copy(title = title, category = category)
        repository.updateTask(updatedTask)
        
        val index = taskList.indexOf(task)
        if(index != -1){
            taskList[index] = updatedTask
        }
    }
}