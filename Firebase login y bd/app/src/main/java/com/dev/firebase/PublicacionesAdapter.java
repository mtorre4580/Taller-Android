package com.dev.firebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PublicacionesAdapter extends BaseAdapter{


    private List<Post> list;

    public PublicacionesAdapter(List<Post> list){
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder holder;
        if (v != null) {
            holder = (ViewHolder) v.getTag();
        } else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_publicacion, parent, false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        }
        Post post = list.get(position);
        holder.cargarDato(post);
        return v;
    }

    static class ViewHolder {

        @BindView(R.id.nombreUsuario)
        TextView textViewNombre;
        @BindView(R.id.fecha)
        TextView textViewFecha;
        @BindView(R.id.contenido)
        TextView textViewContenido;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void cargarDato(Post post){
            textViewNombre.setText(post.getNombreUsuario());
            textViewFecha.setText(post.getFecha());
            textViewContenido.setText(post.getContenido());
        }
    }

}

