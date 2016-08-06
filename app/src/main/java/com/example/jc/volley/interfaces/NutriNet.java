package com.example.jc.volley.interfaces;

import com.example.jc.volley.models.ClienteNutri;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jc on 13/07/16.
 */
public interface NutriNet {
    @GET("GET-NutriNET-Cliente")
    Call<List<ClienteNutri>> getClientInfo();
}
