package com.dev.ejemplo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        listView.setAdapter(new UsuarioAdapter(armarListaUsuarios()));
    }

    private List<Usuario> armarListaUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Belen","belen77@gmail.com","4444-4444"));
        usuarios.add(new Usuario("Agostina","agos@gmail.com","2341-2345"));
        usuarios.add(new Usuario("Facundo","facu91@gmail.com","2222-4234"));
        usuarios.add(new Usuario("Matias","mtorre4580@gmail.com","1111-3333"));
        usuarios.add(new Usuario("Evangelina","eva@gmail.com","222-3333"));
        usuarios.add(new Usuario("Chechu","ceci@gmail.com","1111-3333"));
        usuarios.add(new Usuario("Nicolas","nico@gmail.com","2345-3333"));
        return  usuarios;
    }


}
