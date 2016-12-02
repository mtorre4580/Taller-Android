package com.dev.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        Bundle bundle = this.getIntent().getExtras();
        mostrarMensaje((String)bundle.get("email"));
    }

    private void mostrarMensaje(String email){
        Toast.makeText(this,"Hola " + email, Toast.LENGTH_SHORT).show();
    }

}
