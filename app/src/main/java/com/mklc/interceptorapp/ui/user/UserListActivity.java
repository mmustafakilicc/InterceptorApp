package com.mklc.interceptorapp.ui.user;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.mklc.interceptorapp.R;
import com.mklc.interceptorapp.data.model.network.User;
import com.mklc.interceptorapp.databinding.ActivityUserListBinding;
import com.mklc.interceptorapp.ui.adapter.UserAdapter;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.List;

public class UserListActivity extends AppCompatActivity {

    private ActivityUserListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initialize();
    }

    private void initialize() {
        UserListViewModel userListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);
        userListViewModel.getUserLiveData().observe(this, this::controlUserList);
        userListViewModel.getUsers();
    }

    private void controlUserList(List<User> userList) {
        if (userList != null) {
            fillUserList(userList);
        } else {
            showWarning("User list null");
        }
    }

    private void fillUserList(List<User> userList) {
        UserAdapter userAdapter = new UserAdapter(userList);
        binding.recyclerViewULAUserList.setAdapter(userAdapter);
        binding.recyclerViewULAUserList.setVisibility(View.VISIBLE);
        binding.progressBarULA.setVisibility(View.INVISIBLE);
    }

    private void showWarning(String message) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setPositiveButton(R.string.ok, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            finish();
        });
        builder.setMessage(message);
        builder.create().show();
    }
}