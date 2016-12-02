package com.dev.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsuarioService {

    @GET("users")
    Call<List<Usuario>> getAllUsers();

}
