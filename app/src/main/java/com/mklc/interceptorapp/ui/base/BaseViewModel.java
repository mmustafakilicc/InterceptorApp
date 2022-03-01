package com.mklc.interceptorapp.ui.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class BaseViewModel extends AndroidViewModel {

    private MutableLiveData<Throwable> error;

    public MutableLiveData<Throwable> getError() {
        if (error == null) {
            error = new MutableLiveData<>();
        }
        return error;
    }

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }
}
