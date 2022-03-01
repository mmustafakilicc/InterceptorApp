package com.mklc.interceptorapp.ui.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mklc.interceptorapp.databinding.ActivityMainBinding;
import com.mklc.interceptorapp.ui.todopost.TodoPostActivity;
import com.mklc.interceptorapp.ui.user.UserListActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initialize();
    }

    private void initialize() {
        binding.buttonMAStartUserList.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, UserListActivity.class)));
        binding.buttonMAStartTodoPostList.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, TodoPostActivity.class)));
    }
}