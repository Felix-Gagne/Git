package com.example.httpdemo.http;

import com.example.httpdemo.transfert.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {
    @GET("exos/long/double/{nombre}")
    Call<String> listNombre(@Path("nombre") String nombre);

    @GET("exos/truc/complexe")
    Call<String> userString(@Query("nom") String nom);

    @GET("exos/truc/complexe")
    Call<User> user(@Query("name") String nom);
}
