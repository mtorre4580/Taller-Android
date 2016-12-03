package com.dev.firebase;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CrearPublicacion extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference refPublicaciones;

    @BindView(R.id.editTextPublicacion)
    EditText editTextPublicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_publicacion);
        ButterKnife.bind(this);
        inicializarFirebase();
    }

    private void inicializarFirebase(){
        database = FirebaseDatabase.getInstance();
        refPublicaciones = database.getReference("publicaciones");
    }

    public void publicar(View v){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            refPublicaciones.push().setValue(crearPost(user));
            mostrarMensaje();
        }
    }

    private Post crearPost(FirebaseUser user){
        Post p = new Post();
        p.setNombreUsuario(user.getEmail());
        p.setContenido(editTextPublicacion.getText().toString());
        p.setFecha((String) DateFormat.format("dd-MM-yyyy",new Date()));
        return p;
    }

    private void mostrarMensaje(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.dialog_publicar));
        builder.setMessage(getString(R.string.dialog_mensaje_publicacion_exitosa));
        String positiveText = getString(R.string.aceptar);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
