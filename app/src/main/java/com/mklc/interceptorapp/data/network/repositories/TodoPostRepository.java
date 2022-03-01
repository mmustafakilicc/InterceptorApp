package com.mklc.interceptorapp.data.network.repositories;

import com.mklc.interceptorapp.data.model.network.Post;
import com.mklc.interceptorapp.data.model.network.Todo;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class TodoPostRepository extends BaseRepository {

    public Observable<List<Post>> getPostList() {
        return getApi().getPostList();
    }

    public Observable<List<Todo>> getTodoList() {
        return getApi().getTodoList();
    }
}
