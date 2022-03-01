package com.mklc.interceptorapp.ui.todopost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.mklc.interceptorapp.data.model.network.Post;
import com.mklc.interceptorapp.databinding.FragmentPostBinding;
import com.mklc.interceptorapp.ui.adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;

public class PostFragment extends Fragment {
    private static final String ARG_POSTS = "param_posts";

    private List<Post> postList;
    private FragmentPostBinding binding;

    public PostFragment() {
        // Required empty public constructor
    }

    public static PostFragment newInstance(ArrayList<Post> postList) {
        PostFragment fragment = new PostFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_POSTS, postList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            postList = (List<Post>) getArguments().getSerializable(ARG_POSTS);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPostBinding.inflate(inflater, container, false);
        setup();
        return binding.getRoot();
    }

    private void setup() {
        PostAdapter postAdapter = new PostAdapter(postList);
        binding.recyclerViewPFTodoList.setAdapter(postAdapter);
    }
}