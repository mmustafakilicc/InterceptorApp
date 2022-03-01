package com.mklc.interceptorapp.data.network;

import com.mklc.interceptorapp.data.model.network.Post;
import com.mklc.interceptorapp.data.model.network.Todo;
import com.mklc.interceptorapp.data.model.network.User;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users")
    Call<List<User>> getUsers();

    @GET("todos")
    Observable<List<Todo>> getTodoList();

    @GET("posts")
    Observable<List<Post>> getPostList();
}
