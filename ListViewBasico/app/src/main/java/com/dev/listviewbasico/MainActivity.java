package com.dev.listviewbasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, generarValoresLista()));
    }

    private List<String> generarValoresLista(){
        List<String> usuarios = new ArrayList<>();
        usuarios.add("Matias");
        usuarios.add("Facundo");
        usuarios.add("Belen");
        usuarios.add("Cecilia");
        usuarios.add("Augusto");
        usuarios.add("Nico");
        usuarios.add("Fede");
        usuarios.add("Magali");
        return usuarios;
    }
}
