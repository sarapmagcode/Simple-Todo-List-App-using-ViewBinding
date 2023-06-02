package com.example.todolistapp.ui

import androidx.lifecycle.ViewModel
import com.example.todolistapp.adapter.TodoListAdapter
import com.example.todolistapp.model.TodoItem

class TodoListViewModel : ViewModel() {
    fun addTodo(todo: String, todoListAdapter: TodoListAdapter) {
        todoListAdapter.addTodo(TodoItem(todo))
    }

    fun deleteDoneTodos(todoListAdapter: TodoListAdapter) {
        todoListAdapter.deleteDoneTodos()
    }
}