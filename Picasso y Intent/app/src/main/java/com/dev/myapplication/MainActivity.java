package com.dev.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editTextEmail)
    EditText editTextEmail;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;
    @BindView(R.id.imagenPicasso)
    ImageView imagenPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Picasso.with(this).load("https://lh3.googleusercontent.com/-gzkffFSc6zQ/AAAAAAAAAAI/AAAAAAAAJdw/86myn80MsZo/photo.jpg").into(imagenPicasso);
    }

    public void enviarClick(View v){
        Intent i = new Intent(this,SegundaActivity.class);
        i.putExtra("email",editTextEmail.getText().toString());
        startActivity(i);
    }


}
