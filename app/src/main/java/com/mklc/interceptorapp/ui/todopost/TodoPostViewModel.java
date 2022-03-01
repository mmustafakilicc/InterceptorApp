package com.mklc.interceptorapp.ui.todopost;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.mklc.interceptorapp.data.model.network.TodoPost;
import com.mklc.interceptorapp.data.network.repositories.TodoPostRepository;
import com.mklc.interceptorapp.ui.base.BaseViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TodoPostViewModel extends BaseViewModel {

    private final TodoPostRepository repository;

    public TodoPostViewModel(@NonNull Application application) {
        super(application);
        repository = new TodoPostRepository();
    }

    private MutableLiveData<TodoPost> liveDataTodoPost;

    public MutableLiveData<TodoPost> getLiveDataTodoPost() {
        if (liveDataTodoPost == null) {
            liveDataTodoPost = new MutableLiveData<>();
        }
        return liveDataTodoPost;
    }

    public void loadTodoAndPostList() {

        getError().setValue(null);
        getLiveDataTodoPost().setValue(null);

        Observable.zip(repository.getPostList(), repository.getTodoList(), (posts, todos) -> {
            TodoPost todoPost = new TodoPost();
            todoPost.setTodoList(todos);
            todoPost.setPostList(posts);
            return todoPost;
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TodoPost>() {
                    @Override
                    public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.rxjava3.annotations.NonNull TodoPost todoPost) {
                        getLiveDataTodoPost().setValue(todoPost);
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        getError().setValue(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
