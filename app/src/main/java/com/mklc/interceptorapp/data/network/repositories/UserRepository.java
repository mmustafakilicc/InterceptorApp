package com.mklc.interceptorapp.data.network.repositories;

import com.mklc.interceptorapp.data.model.network.User;

import java.util.List;

import retrofit2.Call;

public class UserRepository extends BaseRepository{

    public Call<List<User>> getUsers() {
        return getApi().getUsers();
    }

}
