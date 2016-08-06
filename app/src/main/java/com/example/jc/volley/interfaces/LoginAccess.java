package com.example.jc.volley.interfaces;

import com.example.jc.volley.models.LoginRequest;
import com.example.jc.volley.models.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by jc on 13/07/16.
 */
public interface LoginAccess {
    @POST("login/")
    Call<LoginResponse> getLoginAccess(@Body LoginRequest loginRequest);
}
