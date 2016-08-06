package com.example.jc.volley.interfaces;

import com.example.jc.volley.models.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClienteService {
    @GET("/clientes")
    Call<List<Cliente>> getClientDetails();
}
