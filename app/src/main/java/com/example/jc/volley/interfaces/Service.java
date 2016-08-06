package com.example.jc.volley.interfaces;

import com.example.jc.volley.models.Greeting;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("greeting/")
    Call<Greeting> getGreeting();
}
