package com.example.todolistapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.adapter.TodoListAdapter
import com.example.todolistapp.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {

    private var _binding: FragmentTodoListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TodoListViewModel by viewModels()

    private lateinit var todoListAdapter: TodoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView
        todoListAdapter = TodoListAdapter(mutableListOf())
        binding.todoList.adapter = todoListAdapter
        binding.todoList.layoutManager = LinearLayoutManager(requireContext())

        // Add button
        binding.addTask.setOnClickListener {
            val newTodo = binding.textTask.text.toString()
            if (newTodo.isNotEmpty()) {
                viewModel.addTodo(newTodo, todoListAdapter)
                binding.textTask.setText("")
            }
        }

        // Delete done button
        binding.deleteDone.setOnClickListener { viewModel.deleteDoneTodos(todoListAdapter) }
    }
}