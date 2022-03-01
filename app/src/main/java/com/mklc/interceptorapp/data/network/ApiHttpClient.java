package com.mklc.interceptorapp.data.network;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiHttpClient {

    public static OkHttpClient getClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new MyInterceptor());
        return builder.build();
    }

    private static class MyInterceptor implements Interceptor {

        @NonNull
        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .addHeader("Content-type", "application/json")
                    .addHeader("Authorization", "2f3a7d67482db456d973c502856d7496e41c340dce75e68e1415a6c400f0b6cf")
                    .build();

            Response response = chain.proceed(request);
            // check response code if it is successful or not
            if(response.code() == 401){
                // refreshToken
            }
            return response;
        }
    }
}
