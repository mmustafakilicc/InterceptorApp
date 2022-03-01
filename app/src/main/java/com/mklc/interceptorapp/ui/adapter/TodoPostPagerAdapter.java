package com.mklc.interceptorapp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mklc.interceptorapp.data.model.network.Post;
import com.mklc.interceptorapp.data.model.network.Todo;
import com.mklc.interceptorapp.data.model.network.TodoPost;
import com.mklc.interceptorapp.ui.todopost.PostFragment;
import com.mklc.interceptorapp.ui.todopost.TodoFragment;

import java.util.ArrayList;

public class TodoPostPagerAdapter extends FragmentStateAdapter {

    private final TodoPost todoPost;

    public TodoPostPagerAdapter(@NonNull FragmentActivity fragmentActivity, TodoPost todoPost) {
        super(fragmentActivity);
        this.todoPost = todoPost;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return TodoFragment.newInstance((ArrayList<Todo>) todoPost.getTodoList());
        }
        return PostFragment.newInstance((ArrayList<Post>) todoPost.getPostList());
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
