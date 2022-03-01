package com.mklc.interceptorapp.ui.todopost;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.mklc.interceptorapp.R;
import com.mklc.interceptorapp.data.model.network.TodoPost;
import com.mklc.interceptorapp.databinding.ActivityTodoPostBinding;
import com.mklc.interceptorapp.ui.adapter.TodoPostPagerAdapter;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.tabs.TabLayoutMediator;

public class TodoPostActivity extends AppCompatActivity {

    private ActivityTodoPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTodoPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initialize();
    }

    private void initialize() {
        TodoPostViewModel todoPostViewModel = new ViewModelProvider(this).get(TodoPostViewModel.class);
        todoPostViewModel.getLiveDataTodoPost().observe(this, todoPost -> {
            if (todoPost != null) {
                setUp(todoPost);
            }

        });
        todoPostViewModel.getError().observe(this, error -> {
            if (error != null) {
                showError(error.getMessage());
            }
        });
        todoPostViewModel.loadTodoAndPostList();
    }

    private void showError(String message) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setPositiveButton(R.string.ok, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            finish();
        });
        builder.setMessage(message);
        builder.create().show();
    }

    private void setUp(TodoPost todoPost) {
        binding.progressIndicatorTPALoading.setVisibility(View.INVISIBLE);
        TodoPostPagerAdapter adapter = new TodoPostPagerAdapter(this, todoPost);
        binding.viewPagerTPAPage.setAdapter(adapter);
        new TabLayoutMediator(binding.tabLayoutTPATabs, binding.viewPagerTPAPage, (tab, position) -> {
            if (position == 0) {
                tab.setText(R.string.posts);
            } else if (position == 1) {
                tab.setText(R.string.todos);
            }
        }).attach();
    }
}