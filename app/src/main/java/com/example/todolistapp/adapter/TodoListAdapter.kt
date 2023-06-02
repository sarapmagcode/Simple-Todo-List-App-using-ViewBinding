package com.example.todolistapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.databinding.TodoListItemBinding
import com.example.todolistapp.model.TodoItem

class TodoListAdapter(private val allTodos: MutableList<TodoItem>) :
    RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder>() {

    class TodoListViewHolder(private var binding: TodoListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(todoItem: TodoItem) {
            binding.todo.text = todoItem.todo
            binding.isDone.isChecked = todoItem.isDone
            binding.isDone.setOnCheckedChangeListener { _, _ -> todoItem.isDone = !todoItem.isDone }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        return TodoListViewHolder(
            TodoListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = allTodos.size

    fun addTodo(todo: TodoItem) {
        allTodos.add(todo)
        notifyItemInserted(allTodos.size - 1)
    }

    fun deleteDoneTodos() {
        allTodos.removeAll { it.isDone }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.bind(allTodos[position])
    }
}