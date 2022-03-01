package com.mklc.interceptorapp.data.network.repositories;

import com.mklc.interceptorapp.data.network.ApiClient;
import com.mklc.interceptorapp.data.network.ApiService;

public class BaseRepository {

    private static ApiService api;

    public static ApiService getApi() {
        if (api == null) {
            api = ApiClient.getRetrofitInstance().create(ApiService.class);
        }
        return api;
    }
}
