package com.mklc.interceptorapp.ui.user;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.mklc.interceptorapp.data.model.network.User;
import com.mklc.interceptorapp.data.network.repositories.UserRepository;
import com.mklc.interceptorapp.ui.base.BaseViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserListViewModel extends BaseViewModel {

    private final UserRepository userRepository;
    private MutableLiveData<List<User>> userLiveData;

    public UserListViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository();
    }

    public MutableLiveData<List<User>> getUserLiveData() {
        if (userLiveData == null) {
            userLiveData = new MutableLiveData<>();
        }
        return userLiveData;
    }

    public void getUsers() {
        userRepository.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        getUserLiveData().setValue(response.body());
                        return;
                    }
                }
                getError().setValue(new Throwable(response.message()));
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                getError().setValue(t);
            }
        });
    }
}
