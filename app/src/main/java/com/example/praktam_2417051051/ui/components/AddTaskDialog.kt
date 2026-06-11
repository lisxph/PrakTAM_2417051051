package com.example.praktam_2417051051.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddTaskDialog(
    onDismiss:()->Unit,
    onSave:(String,String)->Unit
){

    var title by remember {
        mutableStateOf("")
    }

    var category by remember {
        mutableStateOf("")
    }

    AlertDialog(

        onDismissRequest = onDismiss,

        title = {
            Text("Add Task")
        },

        text = {

            Column {

                OutlinedTextField(
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    label = {
                        Text("Task")
                    }
                )

                Spacer(
                    modifier =
                        Modifier.height(8.dp)
                )

                OutlinedTextField(
                    value = category,
                    onValueChange = {
                        category = it
                    },
                    label = {
                        Text("Category")
                    }
                )
            }
        },

        confirmButton = {

            Button(
                onClick = {
                    onSave(
                        title,
                        category
                    )
                }
            ) {
                Text("Save")
            }
        }
    )
}