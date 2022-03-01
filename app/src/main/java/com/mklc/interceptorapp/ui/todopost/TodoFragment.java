package com.mklc.interceptorapp.ui.todopost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mklc.interceptorapp.data.model.network.Todo;
import com.mklc.interceptorapp.databinding.FragmentTodoBinding;
import com.mklc.interceptorapp.ui.adapter.TodoAdapter;

import java.util.ArrayList;
import java.util.List;

public class TodoFragment extends Fragment {
    private static final String ARG_POSTS = "param_todos";

    private List<Todo> todoList;
    private FragmentTodoBinding binding;

    public TodoFragment() {
        // Required empty public constructor
    }

    public static TodoFragment newInstance(ArrayList<Todo> todoList) {
        TodoFragment fragment = new TodoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_POSTS, todoList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            todoList = (List<Todo>) getArguments().getSerializable(ARG_POSTS);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTodoBinding.inflate(inflater, container, false);
        setup();
        return binding.getRoot();
    }

    private void setup() {
        TodoAdapter todoAdapter = new TodoAdapter(todoList);
        binding.recyclerViewTFTodoList.setAdapter(todoAdapter);
    }
}