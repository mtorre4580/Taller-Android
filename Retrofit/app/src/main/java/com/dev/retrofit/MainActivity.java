package com.dev.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        obtenerTodosLosUsuarios();
    }

    private UsuarioService crearServicio(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(UsuarioService.class);
    }

    private void obtenerTodosLosUsuarios(){
        UsuarioService usuarioService = crearServicio();
        Call<List<Usuario>> listUsuarios = usuarioService.getAllUsers();
        listUsuarios.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful()) {
                    UsuarioAdapter usuarioAdapter = new UsuarioAdapter(response.body());
                    listView.setAdapter(usuarioAdapter);
                }else{
                    Toast.makeText(getApplicationContext(), "Error al obtener los datos del servicio", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error al obtener los datos del servicio", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
