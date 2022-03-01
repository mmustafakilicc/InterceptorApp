package com.mklc.interceptorapp.data.model.network;

import java.util.List;

public class TodoPost {

    private List<Post> postList;
    private List<Todo> todoList;

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
