package com.dev.retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsuarioAdapter extends BaseAdapter {

    private List<Usuario> usuarios;

    public UsuarioAdapter(List<Usuario>usuarios){
        this.usuarios = usuarios;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Usuario getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        ViewHolder holder;
        if (v != null) {
            holder = (ViewHolder) v.getTag();
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        }
        Usuario usuario = usuarios.get(i);
        holder.nombre.setText(usuario.getUsername());
        holder.email.setText(usuario.getEmail());
        return v;
    }


     static class ViewHolder {

         @BindView(R.id.nombre)
         TextView nombre;
         @BindView(R.id.email)
         TextView email;

         public ViewHolder(View view) {
             ButterKnife.bind(this, view);
         }
    }


}
