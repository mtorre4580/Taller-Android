package com.dev.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Publicaciones extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference refPublicaciones;
    private List<Post> listPost;
    private PublicacionesAdapter publicacionesAdapter;

    @BindView(R.id.listViewPublicaciones)
    ListView listViewPublicaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicaciones);
        ButterKnife.bind(this);
        inicializarFirebaseBD();
        listPost = new ArrayList<>();
        publicacionesAdapter = new PublicacionesAdapter(listPost);
        listViewPublicaciones.setAdapter(publicacionesAdapter);
    }

    private void inicializarFirebaseBD(){
        database = FirebaseDatabase.getInstance();
        refPublicaciones  = database.getReference("publicaciones");
        refPublicaciones.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listPost.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    listPost.add(post);
                }
                publicacionesAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Error al leer los datos de firebase ..." + error.toException());
            }
        });
    }

    public void publicar(View v){
        startActivity(new Intent(this,CrearPublicacion.class));
    }


}
