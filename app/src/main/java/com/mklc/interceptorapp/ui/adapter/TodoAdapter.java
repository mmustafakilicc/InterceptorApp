package com.mklc.interceptorapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mklc.interceptorapp.data.model.network.Todo;
import com.mklc.interceptorapp.databinding.ItemTodoPostBinding;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private final List<Todo> todoList;

    public TodoAdapter(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTodoPostBinding binding = ItemTodoPostBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(todoList.get(position));
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemTodoPostBinding binding;

        public ViewHolder(ItemTodoPostBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Todo todo) {
            binding.textViewPITitle.setText(todo.getTitle());
            binding.textViewPIBody.setText(todo.getStatus());
        }
    }
}
